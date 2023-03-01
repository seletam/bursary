package com.bursary.state;

import com.bursary.entities.Application;
import com.bursary.repository.ApplicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;


@Slf4j
@Service("InterviewState")
public class ApplicationInterviewState implements ApplicationStatusHandler {
    private final ApplicationRepository applicationRepository;
    private final ApplicationEventPublisher publisher;

    @Autowired
    public ApplicationInterviewState(ApplicationRepository applicationRepository, ApplicationEventPublisher publisher) {
        this.applicationRepository = applicationRepository;
        this.publisher = publisher;
    }

    /**
     * @param application
     * @return
     */
    @Override
    public Application review(Application application) {
        Application app = applicationRepository.insert(application);
        log.info("applicant " + app);
        publisher.publishEvent(app);
        return app;
    }
}
