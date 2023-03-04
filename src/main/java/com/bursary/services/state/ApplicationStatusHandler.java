package com.bursary.services.state;

import com.bursary.repository.entities.Application;

public interface ApplicationStatusHandler {
    public Application review(Application application);
}

