package com.bursary.services.state;


import org.springframework.context.ApplicationEvent;

import java.util.UUID;

public class ApplicationStatusEvent extends ApplicationEvent {
    private UUID applicationId;
    private ApplicationStatus applicationStatus;

    public ApplicationStatusEvent(Object source, UUID applicationId, ApplicationStatus applicationStatus) {
        super(source);
        this.applicationId = applicationId;
        this.applicationStatus = applicationStatus;
    }


    public UUID id() {
        return applicationId;
    }

    public ApplicationStatus type() {
        return applicationStatus;
    }
}
