package com.bursary.services.state;

import com.bursary.repository.entities.Application;
import com.bursary.repository.repository.ApplicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service("ACCEPT")
public class ApplicationAcceptState implements ApplicationStatusHandler {

    private final ApplicationRepository applicationRepository;
    private final ApplicationEventPublisher publisher;

    @Autowired
    public ApplicationAcceptState(ApplicationRepository applicationRepository, ApplicationEventPublisher publisher) {
        this.applicationRepository = applicationRepository;
        this.publisher = publisher;
    }


    @Override
    public Application review(Application application) {
        Application app = applicationRepository.insert(application);
        log.info("applicant " + app);
        publisher.publishEvent(app);
        return app;
    }
}
