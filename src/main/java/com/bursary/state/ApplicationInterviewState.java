package com.bursary.state;

import com.bursary.entities.Applicant;
import com.bursary.event.ApplicationPublisher;
import com.bursary.repository.ApplicantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class ApplicationInterviewState implements ApplicationState {
    private ApplicantRepository applicantRepository;
    private ApplicationPublisher<Applicant> publisher;

    public ApplicationInterviewState(ApplicantRepository applicantRepository, ApplicationPublisher<Applicant> publisher) {
        this.applicantRepository = applicantRepository;
        this.publisher = publisher;
    }

    public ApplicationInterviewState() {

    }

    /**
     * @param applicant
     * @return
     */
    @Override
    public Applicant review(Applicant applicant) {
        Applicant app = applicantRepository.save(applicant);
        log.info("applicant " + app);
        publisher.publishApplicationEvent(app);
        return app;
    }
}
