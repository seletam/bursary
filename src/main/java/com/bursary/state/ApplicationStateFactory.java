package com.bursary.state;

import com.bursary.entities.Applicant;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ApplicationStateFactory {

    private final ApplicationPendingState applicationState;

    public ApplicationStateFactory(ApplicationPendingState applicationState) {
        this.applicationState = applicationState;
    }

    /**
     * @param type
     * @param applicant
     * @return
     */
    public Applicant getInstance(ApplicationStateType type, Applicant applicant) {
        switch (type) {
            case CREATION, PENDING, PENDING_DOCUMENTS, REVIEW -> {
                return applicationState.review(applicant);
            }
//            case SHORTLISTING -> {
//                return new ApplicationShortlistedState().review(applicant);
//            } case INTERVIEW -> {
//                return new ApplicationInterviewState().review(applicant);
//            }
//            case ISSUED -> {
//                return new ApplicationIssuedState();
//            } case ACCEPTED -> {
//                return new ApplicationAcceptedState();
//            }
//            } case REJECTED -> {
//                return new ApplicationRejectedState();
//            }
//            case DECLINED -> {
//                return new ApplicationDeclinedState();
//            }

            default -> {
                throw new IllegalArgumentException(type + " is not valid");
            }
        }
    }
}
