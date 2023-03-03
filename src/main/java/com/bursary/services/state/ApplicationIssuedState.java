package com.bursary.services.state;

import com.bursary.repository.entities.Application;
import com.bursary.repository.entities.Status;
import com.bursary.repository.repository.ApplicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service(value = "ISSUED")
public class ApplicationIssuedState implements ApplicationStatusHandler {

    private final ApplicationRepository applicationRepository;
    private final ApplicationEventPublisher publisher;

    public ApplicationIssuedState(ApplicationRepository applicationRepository, ApplicationEventPublisher publisher) {
        this.applicationRepository = applicationRepository;
        this.publisher = publisher;
    }

    /*
     * @param a
     * @return
     */
    @Override
    public Application review(Application application) {
        Status status = Status.StatusBuilder().status(ApplicationStatus.OFFER_ISSUED).build();
        application.setStatus(status);
        Application app = applicationRepository.insert(application);
        log.info("applicant " + app);
        publisher.publishEvent(app);
        return app;
    }
}
