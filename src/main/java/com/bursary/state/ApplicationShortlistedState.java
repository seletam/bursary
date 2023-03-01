package com.bursary.state;

import com.bursary.entities.Application;
import com.bursary.repository.ApplicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service("ShortlistState")
public class ApplicationShortlistedState implements ApplicationStatusHandler {

    private final ApplicationEventPublisher publisher;
    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationShortlistedState(ApplicationEventPublisher publisher, ApplicationRepository applicationRepository) {
        this.publisher = publisher;
        this.applicationRepository = applicationRepository;
    }

    /*
        TODO
        create automatic behaviour that runs on its own Thread
     */
    @Override
    public Application review(Application application) {
        Application app = applicationRepository.insert(application);
        log.info("applicant " + app);
        publisher.publishEvent(app);
        return app;
    }

}
