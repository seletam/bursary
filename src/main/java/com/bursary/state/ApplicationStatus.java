package com.bursary.state;


import org.springframework.context.ApplicationEvent;

import java.time.Clock;
import java.util.UUID;

public class ApplicationStatus extends ApplicationEvent {
    private UUID id;
    private ApplicationStateType type;

    public ApplicationStatus(Object source, UUID id, ApplicationStateType type) {
        super(source);
        this.id = id;
        this.type = type;
    }

    public ApplicationStatus(Object source, Clock clock, UUID id, ApplicationStateType type) {
        super(source, clock);
        this.id = id;
        this.type = type;
    }

    public ApplicationStatus(Object source) {
        super(source);
    }

    public ApplicationStatus(Object source, Clock clock) {
        super(source, clock);
    }


    public void setId(UUID id) {
        this.id = id;
    }

    public void setType(ApplicationStateType type) {
        this.type = type;
    }

    public UUID id() {
        return id;
    }

    public ApplicationStateType type() {
        return type;
    }
}
