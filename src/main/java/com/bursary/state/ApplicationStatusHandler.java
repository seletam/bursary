package com.bursary.state;

import com.bursary.entities.Application;

public interface ApplicationStatusHandler {
    public Application review(Application application);
}

