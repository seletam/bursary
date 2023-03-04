package com.bursary.services.state;

import com.bursary.repository.entities.Application;
import com.bursary.repository.entities.Status;
import com.bursary.repository.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static com.bursary.services.state.ApplicationStatus.*;

@Slf4j
@Service("CREATED")
@RequiredArgsConstructor
public class ApplicationCreateState implements ApplicationStatusHandler {

    public static final String GPA_BELOW_MINIMUM = "GPA below minimum";
    public static final double MIN_GPA = 60;
    private final ApplicationRepository applicationRepository;

    private final CassandraOperations cassandraTemplate;
    private final ApplicationEventPublisher publisher;

    @Override
    public Application review(@Validated Application application) {
        application.setStatus(Status.StatusBuilder().status(CREATED).build());
        if (application.getGpa() < MIN_GPA) {
            application.setStatus(Status.StatusBuilder().status(REJECTED).reason(GPA_BELOW_MINIMUM).build());
            System.out.println("application = " + application);
            Application app = cassandraTemplate.insert(application);
            applicationRepository.insert(application);
            return app;
        }
        try {
            var savedApplication = applicationRepository.insert(application);
            log.info("Application saved: {}", savedApplication);
            savedApplication.setStatus(Status.StatusBuilder().status(PENDING).build()); // update status to PENDING before returning
            System.out.println("savedApplication = " + savedApplication);
            publisher.publishEvent(savedApplication);
            return savedApplication;
        } catch (Exception e) {
            log.error("An error occurred while saving the application: {}", e.getCause());
            throw new RuntimeException("We could not process the application. Please try again later. " + e.getMessage());
        }
    }
}
