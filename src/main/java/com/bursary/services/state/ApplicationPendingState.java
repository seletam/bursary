package com.bursary.services.state;

import com.bursary.repository.entities.Application;
import com.bursary.repository.entities.Status;
import com.bursary.repository.repository.ApplicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;


@Slf4j
@Service("PENDING")
public class ApplicationPendingState implements ApplicationStatusHandler {
    private final ApplicationRepository applicationRepository;
    private final ApplicationEventPublisher publisher;

    public ApplicationPendingState(ApplicationRepository applicationRepository, ApplicationEventPublisher publisher) {
        this.applicationRepository = applicationRepository;
        this.publisher = publisher;
    }

    @Override
    public Application review(Application application) {
        application.setStatus(Status.StatusBuilder().status(ApplicationStatus.PENDING).build());
        Application savedApplication = applicationRepository.insert(application);
        log.info("Application saved: {}", savedApplication);

        // Publish application status update event
        ApplicationStatusEvent applicationStatusEvent = new ApplicationStatusEvent(application, savedApplication.getId(), ApplicationStatus.PENDING);
        Map<UUID, List<ApplicationStatusEvent>> applicationStatuses = Arrays.asList(applicationStatusEvent)
                .stream()
                .collect(Collectors.groupingBy(ApplicationStatusEvent::id));
        publisher.publishEvent(applicationStatuses);

        return savedApplication;
    }
}
