package com.bursary.state;

import com.bursary.entities.Applicant;
import com.bursary.event.ApplicationPublisher;
import com.bursary.repository.ApplicantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;


@Slf4j
@Component
public class ApplicationPendingState implements ApplicationState {

    private final ApplicationEventPublisher publisher;
    private final ApplicantRepository applicantRepository;

    @Autowired
    public ApplicationPendingState(ApplicationEventPublisher publisher, ApplicantRepository applicantRepository) {

        this.publisher = publisher;
        this.applicantRepository = applicantRepository;
    }

    @Override
    public Applicant review(Applicant applicant) {
        Applicant app = applicantRepository.save(applicant);
        log.info("applicant " + app);

//        applicationId and Status
        Map<UUID, List<ApplicationStatus>> applicationStatus = Arrays.asList(app)
                .stream()
                .map(app1 -> new ApplicationStatus(null, app1.getId(), ApplicationStateType.PENDING))
                .collect(Collectors.groupingBy(ApplicationStatus::id));
        publisher.publishEvent(applicationStatus);
        return app;
    }
}
