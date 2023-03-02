package com.bursary.state;

import com.bursary.entities.Application;
import com.bursary.entities.Status;
import com.bursary.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import static com.bursary.state.ApplicationStatus.*;

@Slf4j
@Service("CREATED")
public class ApplicationCreateState implements ApplicationStatusHandler {

    public static final String GPA_BELOW_MINIMUM = "GPA below minimum";
    public static final int MIN_GPA = 60;
    private final ApplicationRepository applicationRepository;

    private final CassandraOperations cassandraTemplate;
    private final ApplicationEventPublisher publisher;

    public ApplicationCreateState(ApplicationRepository applicationRepository, CassandraOperations cassandraTemplate, ApplicationEventPublisher publisher) {
        this.applicationRepository = applicationRepository;
        this.cassandraTemplate = cassandraTemplate;
        this.publisher = publisher;
    }
    @Override
    public Application review(Application application) {
        application.setStatus(Status.StatusBuilder().status(CREATED).build());
//        if (application.getGpa() < MIN_GPA) {
            application.setStatus(Status.StatusBuilder().status(REJECTED).reason(GPA_BELOW_MINIMUM).build());
        System.out.println("application = " + application);
        Application app = cassandraTemplate.insert(application);
//        applicationRepository.insert(application);
            return app;
//        }
//        try {
//            var savedApplication = applicationRepository.insert(application);
//            log.info("Application saved: {}", savedApplication);
//            savedApplication.setStatus(Status.StatusBuilder().status(PENDING).build()); // update status to PENDING before returning
//             savedApplication;
//        } catch (Exception e) {
//            log.error("An error occurred while saving the application: {}", e.getMessage());
//            throw new RuntimeException("Could not save application", e);
//        }
    }
}
