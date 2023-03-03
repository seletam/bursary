package com.bursary.services.state;

import com.bursary.repository.entities.Application;
import com.bursary.repository.repository.ApplicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service("ReviewState")
public class ApplicationReviewState implements ApplicationStatusHandler {
    private final ApplicationRepository applicationRepository;

    private final ApplicationEventPublisher publisher;


    @Autowired
    public ApplicationReviewState(ApplicationEventPublisher publisher,
                                  ApplicationRepository applicationRepository) {
        this.publisher = publisher;
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Application review(Application application) {
        Application app = applicationRepository.insert(application);
        log.info("applicant " + app);
        publisher.publishEvent(app);
        return app;
    }
}
