package com.bursary.services.event;

import com.bursary.repository.entities.Application;
import com.bursary.repository.entities.Status;
import com.bursary.repository.repository.ApplicationRepository;
import com.bursary.services.state.ApplicationStatusEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApplicationStatusEventProcessor {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationStatusEventProcessor(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @EventListener(ApplicationStatusEvent.class)
    public void handleApplicationStatusEvent(ApplicationStatusEvent event) {
        UUID applicationId = event.id();
        Application application = applicationRepository.findById(applicationId).orElseThrow(() -> new RuntimeException("Application not found"));

        System.out.println("application = " + application);

        application.setStatus(Status.StatusBuilder().status(event.type()).build());
        applicationRepository.save(application);
    }
}