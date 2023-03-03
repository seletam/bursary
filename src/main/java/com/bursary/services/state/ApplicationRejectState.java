package com.bursary.services.state;

import com.bursary.repository.entities.Application;
import com.bursary.repository.entities.Status;
import com.bursary.repository.repository.ApplicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;


@Slf4j
@Service("RejectState")
public class ApplicationRejectState implements ApplicationStatusHandler {

    private final ApplicationRepository applicationRepository;
    private final ApplicationEventPublisher publisher;

    @Autowired
    public ApplicationRejectState(ApplicationRepository applicationRepository, ApplicationEventPublisher publisher) {
        log.info("Application Rejection State initiated...");
        this.applicationRepository = applicationRepository;
        this.publisher = publisher;
    }


    @Override
    public Application review(Application application) {
        application.setStatus(Status.StatusBuilder().status(ApplicationStatus.REJECTED).build());
        Application app = applicationRepository.insert(application);
        log.info("applicant " + app);
        publisher.publishEvent(app);
        return app;
    }
}
