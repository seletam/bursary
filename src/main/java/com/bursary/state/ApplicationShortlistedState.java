package com.bursary.state;

import com.bursary.entities.Applicant;
import com.bursary.event.ApplicationPublisher;
import com.bursary.repository.ApplicantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationShortlistedState implements ApplicationState {

    private ApplicationPublisher<Applicant> publisher;
    private ApplicantRepository applicantRepository;

    public ApplicationShortlistedState(ApplicationPublisher publisher, ApplicantRepository applicantRepository) {
        this.publisher = publisher;
        this.applicantRepository = applicantRepository;
    }

    public ApplicationShortlistedState() {

    }

    @Override
    public Applicant review(Applicant applicant) {
        Applicant app = applicantRepository.save(applicant);
        log.info("applicant " + app);
        publisher.publishApplicationEvent(app);
        return app;
    }
}
