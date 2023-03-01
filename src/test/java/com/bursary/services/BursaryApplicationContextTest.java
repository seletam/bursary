//package com.bursary.services;
//
//import com.bursary.entities.Applicant;
//import com.bursary.entities.Application;
//import com.bursary.entities.Status;
//import com.bursary.repository.ApplicationRepository;
//import com.bursary.state.*;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.context.ApplicationEventPublisher;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
//import static com.bursary.state.ApplicationStatus.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class BursaryApplicationContextTest {
//
//    @Mock
//    private ApplicationRepository applicationRepository;
//    @Mock
//    private  ApplicationEventPublisher publisher;
//
//    @BeforeEach
//    public void init() {
////        stateTypeApplicationStateMap.put(CREATED, new ApplicationCreateState(applicationRepository, publisher));
////        stateTypeApplicationStateMap.put(PENDING, new ApplicationPendingState(publisher, applicationRepository));
////        stateTypeApplicationStateMap.put(UNDER_REVIEW, new ApplicationPendingState(publisher, applicationRepository));
////        stateTypeApplicationStateMap.put(SHORTLISTED, new ApplicationShortlistedState(publisher, applicationRepository));
////        stateTypeApplicationStateMap.put(INTERVIEW, new ApplicationInterviewState(applicationRepository, publisher));
////        stateTypeApplicationStateMap.put(OFFER_ISSUED, new ApplicationIssuedState(applicationRepository, publisher));
////        stateTypeApplicationStateMap.put(ACCEPTED, new ApplicationAcceptState(applicationRepository, publisher));
////        stateTypeApplicationStateMap.put(REJECTED, new ApplicationAcceptState(applicationRepository, publisher));
////        stateTypeApplicationStateMap.put(DECLINED, new ApplicationAcceptState(applicationRepository, publisher));
////        stateTypeApplicationStateMap.put(PENDING_DOCUMENTS, new ApplicationAcceptState(applicationRepository, publisher));
//    }
//
//    @Test
//    public void testProcessApplicationStateCreated() {
//        Map<ApplicationStatus, ApplicationStatusHandler> stateTypeApplicationStateMap = new HashMap<>();
//        ApplicationCreateState applicationCreateState = mock(ApplicationCreateState.class);
//        stateTypeApplicationStateMap.put(CREATED, applicationCreateState);
//        Application application =  Application.ApplicationBuilder().status(Status.StatusBuilder().status(CREATED).build()).applicant(Applicant.applicantBuilder().build()).build();
//        BursaryApplicationContext bursaryApplicationContext = new BursaryApplicationContext(applicationRepository, publisher);
//        stateTypeApplicationStateMap.put(CREATED, applicationCreateState);
//
//        bursaryApplicationContext.processApplicationState(application);
//
//        verify(applicationCreateState).review(application);
//    }
//
//    @Test
//    public void testProcessApplicationStatePending() {
//        Map<ApplicationStatus, ApplicationStatusHandler> stateTypeApplicationStateMap = new HashMap<>();
//        Application application =  Application.ApplicationBuilder().status(Status.StatusBuilder().status(PENDING).build()).applicant(Applicant.applicantBuilder().build()).build();
//        ApplicationPendingState applicationPendingState = mock(ApplicationPendingState.class);
//        stateTypeApplicationStateMap.put(CREATED, applicationPendingState);
//        BursaryApplicationContext bursaryApplicationContext = new BursaryApplicationContext(applicationRepository, publisher);
//        stateTypeApplicationStateMap.put(PENDING, applicationPendingState);
//
//        bursaryApplicationContext.processApplicationState(application);
//
//        verify(applicationPendingState).review(application);
//    }
//
//    @Test
//    public void testProcessApplicationStateUnderReview() {
//        Map<ApplicationStatus, ApplicationStatusHandler> stateTypeApplicationStateMap = new HashMap<>();
//        Application application =  Application.ApplicationBuilder().status(Status.StatusBuilder().status(UNDER_REVIEW).build()).applicant(Applicant.applicantBuilder().build()).build();
//        ApplicationPendingState applicationPendingState = mock(ApplicationPendingState.class);
//        BursaryApplicationContext bursaryApplicationContext = new BursaryApplicationContext(applicationRepository, publisher);
//        stateTypeApplicationStateMap.put(UNDER_REVIEW, applicationPendingState);
//
//        bursaryApplicationContext.processApplicationState(application);
//
//        verify(applicationPendingState).review(application);
//    }
//
//    @Test
//    public void testProcessApplicationStateShortlisted() {
//        Map<ApplicationStatus, ApplicationStatusHandler> stateTypeApplicationStateMap = new HashMap<>();
//        Application application =  Application.ApplicationBuilder().status(Status.StatusBuilder().status(SHORTLISTED).build()).applicant(Applicant.applicantBuilder().build()).build();
//        ApplicationShortlistedState applicationShortlistedState = mock(ApplicationShortlistedState.class);
//        BursaryApplicationContext bursaryApplicationContext = new BursaryApplicationContext(applicationRepository, publisher);
//        stateTypeApplicationStateMap.put(SHORTLISTED, applicationShortlistedState);
//
//        bursaryApplicationContext.processApplicationState(application);
//
//        verify(applicationShortlistedState).review(application);
//    }
//
//    @Test
//    public void testProcessApplicationStateInterview() {
//        Map<ApplicationStatus, ApplicationStatusHandler> stateTypeApplicationStateMap = new HashMap<>();
//        Application application =  Application.ApplicationBuilder().status(Status.StatusBuilder().status(INTERVIEW).build()).applicant(Applicant.applicantBuilder().build()).build();
//        ApplicationInterviewState applicationInterviewState = mock(ApplicationInterviewState.class);
//        BursaryApplicationContext bursaryApplicationContext = new BursaryApplicationContext(applicationRepository, publisher);
//        stateTypeApplicationStateMap.put(INTERVIEW, applicationInterviewState);
//
//        bursaryApplicationContext.processApplicationState(application);
//
//        verify(applicationInterviewState).review(application);
//    }
//
//    @Test
//    public void testProcessApplicationStateOfferIssued() {
//        Map<ApplicationStatus, ApplicationStatusHandler> stateTypeApplicationStateMap = new HashMap<>();
//        Application application =  Application.ApplicationBuilder().status(Status.StatusBuilder().status(OFFER_ISSUED).build()).applicant(Applicant.applicantBuilder().build()).build();
//        ApplicationIssuedState applicationIssuedState = mock(ApplicationIssuedState.class);
//        BursaryApplicationContext bursaryApplicationContext = new BursaryApplicationContext(applicationRepository, publisher);
//        stateTypeApplicationStateMap.put(OFFER_ISSUED, applicationIssuedState);
//
//        bursaryApplicationContext.processApplicationState(application);
//
//        verify(applicationIssuedState).review(application);
//    }
//
//    @Test
//    public void testProcessApplicationStateAccepted() {
//        Map<ApplicationStatus, ApplicationStatusHandler> stateTypeApplicationStateMap = new HashMap<>();
//        Application application =  Application.ApplicationBuilder().status(Status.StatusBuilder().status(ACCEPTED).build()).applicant(Applicant.applicantBuilder().build()).build();
//        ApplicationAcceptState applicationAcceptState = mock(ApplicationAcceptState.class);
//        BursaryApplicationContext bursaryApplicationContext = new BursaryApplicationContext(applicationRepository, publisher);
//        stateTypeApplicationStateMap.put(ACCEPTED, applicationAcceptState);
//
//        bursaryApplicationContext.processApplicationState(application);
//
//        verify(applicationAcceptState).review(application);
//    }
//
//    @Test
//    public void testProcessApplicationStateRejected() {
//        Map<ApplicationStatus, ApplicationStatusHandler> stateTypeApplicationStateMap = new HashMap<>();
//        Application application =  Application.ApplicationBuilder().status(Status.StatusBuilder().status(REJECTED).build()).applicant(Applicant.applicantBuilder().build()).build();
//        ApplicationAcceptState applicationAcceptState = mock(ApplicationAcceptState.class);
//        BursaryApplicationContext bursaryApplicationContext = new BursaryApplicationContext(applicationRepository, publisher);
//        stateTypeApplicationStateMap.put(REJECTED, applicationAcceptState);
//
//        bursaryApplicationContext.processApplicationState(application);
//
//        verify(applicationAcceptState).review(application);
//    }
//
//    @Test
//    public void testProcessApplicationStateRejected1() {
//        Map<ApplicationStatus, ApplicationStatusHandler> stateTypeApplicationStateMap = new HashMap<>();
//        Application application = Application.ApplicationBuilder()
//                .id(UUID.randomUUID())
//                .status(Status.StatusBuilder().status(REJECTED).build())
//                .applicant(Applicant.applicantBuilder()
//                        .id(UUID.randomUUID())
//                        .firstName("Seleta")
//                        .lastName("Mootwane")
//                        .referenceNo(UUID.randomUUID().toString())
//                        .build())
//                .gpa(45)
//                .build();
//        // Mock the ApplicationRepository
//        ApplicationRepository applicationRepository = mock(ApplicationRepository.class);
//        when(applicationRepository.save(any(Application.class))).thenReturn(application);
//
//        ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
//        doNothing().when(applicationEventPublisher).publishEvent(any(Application.class));
//
//        ApplicationRejectState applicationRejectState = mock(ApplicationRejectState.class);
//        BursaryApplicationContext bursaryApplicationContext = new BursaryApplicationContext(applicationRepository, applicationEventPublisher);
//        stateTypeApplicationStateMap.put(REJECTED, applicationRejectState);
//
//        bursaryApplicationContext.processApplicationState(application);
//
//        // Verify that the application was processed by the correct state handler
//        verify(applicationRejectState).review(application);
//
//        // Verify that the application was saved to the repository
//        verify(applicationRepository).save(application);
//    }
//
//
//    @Test
//    public void testProcessApplicationStateDeclined() {
//        Map<ApplicationStatus, ApplicationStatusHandler> stateTypeApplicationStateMap = new HashMap<>();
//        Application application =  Application.ApplicationBuilder().status(Status.StatusBuilder().status(DECLINED).build()).applicant(Applicant.applicantBuilder().build()).build();
//        ApplicationAcceptState applicationAcceptState = mock(ApplicationAcceptState.class);
//        BursaryApplicationContext bursaryApplicationContext = new BursaryApplicationContext(applicationRepository, publisher);
//        stateTypeApplicationStateMap.put(REJECTED, applicationAcceptState);
//
//        bursaryApplicationContext.processApplicationState(application);
//
//        verify(applicationAcceptState).review(application);
//    }
//}
