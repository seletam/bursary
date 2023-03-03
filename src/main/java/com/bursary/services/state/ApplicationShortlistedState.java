package com.bursary.services.state;

import com.bursary.repository.entities.Application;
import com.bursary.repository.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service("ShortlistState")
@RequiredArgsConstructor
public class ApplicationShortlistedState implements ApplicationStatusHandler {

    private final ApplicationEventPublisher publisher;
    private final ApplicationRepository applicationRepository;

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
