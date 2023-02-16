package com.bursary.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class ApplicationPublisher<T> {

    private final ApplicationEventPublisher publisher;


    public ApplicationPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publishApplicationEvent(T t) {
        publisher.publishEvent(t);
    }

    public void publishApplicationEventException(String message) {
        publisher.publishEvent(message);
    }
}
