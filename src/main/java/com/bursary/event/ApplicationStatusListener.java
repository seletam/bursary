package com.bursary.event;

import com.bursary.state.ApplicationStatus;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStatusListener implements ApplicationListener<ApplicationStatus> {
    /**
     * @param status
     */
    @Override
    public void onApplicationEvent(ApplicationStatus status) {
        System.out.println("status = " + status);
    }
}
