package com.bursary.state;

import com.bursary.entities.Applicant;
import org.springframework.stereotype.Component;

@Component
public class PendingReviewProcess implements ApplicationState {


    @Override
    public Applicant review(Applicant applicant) {

        return applicant;
    }

}
