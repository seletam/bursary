package com.bursary.services;

import com.bursary.entities.Application;
import com.bursary.repository.ApplicationRepository;
import com.bursary.state.*;
import io.micrometer.core.annotation.Timed;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.bursary.state.ApplicationStatus.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class BursaryApplicationContext {

    private final ApplicationRepository applicationRepository;
    private final ApplicationEventPublisher publisher;

    private final CassandraOperations cassandraTemplate;
    private final ObservationRegistry observationRegistry;

    @Timed(extraTags = {"region", "us-east-1"})
    @Timed(value = "all.application", longTask = true)
    public Application processApplicationState(Application application) {
//        log.info("Application Process Started. {}", application);

        Map<ApplicationStatus, ApplicationStatusHandler> applicationStatusHandlerHashMap = new HashMap<>();
        applicationStatusHandlerHashMap.put(CREATED, new ApplicationCreateState(applicationRepository, cassandraTemplate, publisher));
        applicationStatusHandlerHashMap.put(PENDING, new ApplicationPendingState(publisher, applicationRepository));
        applicationStatusHandlerHashMap.put(UNDER_REVIEW, new ApplicationPendingState(publisher, applicationRepository));
        applicationStatusHandlerHashMap.put(SHORTLISTED, new ApplicationShortlistedState(publisher, applicationRepository));
        applicationStatusHandlerHashMap.put(INTERVIEW, new ApplicationInterviewState(applicationRepository, publisher));
        applicationStatusHandlerHashMap.put(OFFER_ISSUED, new ApplicationIssuedState(applicationRepository, publisher));
        applicationStatusHandlerHashMap.put(ACCEPTED, new ApplicationAcceptState(applicationRepository, publisher));
        applicationStatusHandlerHashMap.put(REJECTED, new ApplicationRejectState(applicationRepository, publisher));
        applicationStatusHandlerHashMap.put(DECLINED, new ApplicationAcceptState(applicationRepository, publisher));
        applicationStatusHandlerHashMap.put(PENDING_DOCUMENTS, new ApplicationAcceptState(applicationRepository, publisher));

        return Observation.createNotStarted("applicationProcess", this.observationRegistry).observe(() -> getInstance(application, applicationStatusHandlerHashMap));
    }

    private Application getInstance(Application application, Map<ApplicationStatus, ApplicationStatusHandler> statusApplicationStatusHandlerHashMap) {
        var status = application.getStatus().getStatus();
        if (!statusApplicationStatusHandlerHashMap.containsKey(status)) {
            log.error("Unknown application status: ", status);
            throw new IllegalArgumentException("Unknown application status: " + status);
        }
        System.out.println("status = " + status);
        ApplicationStatusHandler applicationStatusHandler = statusApplicationStatusHandlerHashMap.get(status);
        System.out.println("applicationStatusHandler = " + applicationStatusHandler);
        return applicationStatusHandler
                .review(Application
                        .ApplicationBuilder()
                        .applicant(application.getApplicant())
                        .build());
    }
}
