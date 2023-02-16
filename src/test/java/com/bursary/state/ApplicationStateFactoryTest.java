package com.bursary.state;

import com.bursary.entities.Applicant;
import com.bursary.entities.objects.GENDER;
import com.bursary.event.ApplicationPublisher;
import com.bursary.repository.ApplicantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class ApplicationStateFactoryTest {

    @Mock
    private ApplicationPublisher<Applicant> publisher;

    @InjectMocks
    private ApplicationStateFactory applicationStateFactory;
    @MockBean
    private ApplicantRepository applicantRepository;

    @BeforeEach
    public void init() {
        publisher = mock(ApplicationPublisher.class);
    }

    @Test
    public void testGetInstance_created() {
        Applicant applicant = Applicant.builder()
                .dob(new Date())
                .email("Seletam@gmail.com")
                .gender(GENDER.MALE).firstName("Seleta")
                .lastName("Mootwane")
                .referenceNo(UUID.randomUUID().toString())
                .middleName("Keane")
                .id(UUID.randomUUID())
                .build();

        doNothing().when(publisher).publishApplicationEvent(applicant);
        when(applicantRepository.insert(applicant)).thenReturn(applicant);

        Applicant created = applicationStateFactory.getInstance(ApplicationStateType.CREATION, applicant);
        System.out.println("created = " + created);
        assertNotNull(created);
        verify(publisher, times(1)).publishApplicationEvent(applicant);
    }

    @Test
    public void testGetInstance_pendingReview() {
        Applicant applicant = Applicant.builder()
                .dob(new Date())
                .email("Seletam@gmail.com")
                .gender(GENDER.MALE).firstName("Seleta")
                .lastName("Mootwane")
                .referenceNo(UUID.randomUUID().toString())
                .middleName("Keane")
                .build();

        doNothing().when(publisher).publishApplicationEvent(applicant);
        when(applicantRepository.save(applicant)).thenReturn(any(Applicant.class));

        Applicant pendingReview = applicationStateFactory.getInstance(ApplicationStateType.PENDING, applicant);
        System.out.println("pendingReview = " + pendingReview);
        assertNotNull(pendingReview);
//        assertEquals("Bursary application pending review.", pendingReview.printStatus());
    }

    @Test
    public void testGetInstance_approved() {
        Applicant applicant = Applicant.builder()
                .dob(new Date())
                .email("Seletam@gmail.com")
                .gender(GENDER.MALE).firstName("Seleta")
                .lastName("Mootwane")
                .referenceNo(UUID.randomUUID().toString())
                .middleName("Keane")
                .build();

        Applicant approved = applicationStateFactory.getInstance(ApplicationStateType.ACCEPTED, applicant);
        assertNotNull(approved);
//        assertEquals("Bursary application approved.", approved.printStatus());
    }

    @Test
    public void testGetInstance_rejected() {
        Applicant applicant = Applicant.builder()
                .dob(new Date())
                .email("Seletam@gmail.com")
                .gender(GENDER.MALE).firstName("Seleta")
                .lastName("Mootwane")
                .referenceNo(UUID.randomUUID().toString())
                .middleName("Keane")
                .build();

        Applicant rejected = applicationStateFactory.getInstance(ApplicationStateType.REJECTED, applicant);
        System.out.println("rejected = " + rejected);
        assertNotNull(rejected);
//        assertEquals("Bursary application rejected.", rejected.printStatus());
    }

    @Test
    public void testGetInstance_null() {
        Applicant applicant = Applicant.builder()
                .dob(new Date())
                .email("Seletam@gmail.com")
                .gender(GENDER.MALE).firstName("Seleta")
                .lastName("Mootwane")
                .referenceNo(UUID.randomUUID().toString())
                .middleName("Keane")
                .build();

        Applicant nullState = applicationStateFactory.getInstance(null, applicant);
        assertNull(nullState);
    }
}