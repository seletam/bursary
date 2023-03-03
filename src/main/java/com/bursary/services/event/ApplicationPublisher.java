package com.bursary.services.event;

import com.bursary.repository.entities.Applicant;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicReference;

@Component
public class ApplicationPublisher<T> {

    private final ApplicationEventPublisher publisher;


    public ApplicationPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publishApplicationEvent(AtomicReference<Applicant> t) {
        publisher.publishEvent(t);
    }

    public void publishApplicationEventException(String message) {
        publisher.publishEvent(message);
    }
}
