package com.bursary.state;

import com.bursary.entities.Applicant;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ApplicationStateFactoryTest {

//    @Mock
//    private ApplicationPublisher<Applicant> publisher;
//
//    @InjectMocks
//    private ApplicationContext applicationContext;
//    @MockBean
//    private ApplicantRepository applicantRepository;
//
//    @BeforeEach
//    public void init() {
//        publisher = mock(ApplicationPublisher.class);
//    }
//
//    @Test
//    public void testGetInstance_created() {
//        Applicant applicant = Applicant.builder()
//                .dob(new Date())
//                .email("Seletam@gmail.com")
//                .gender(GENDER.MALE).firstName("Seleta")
//                .lastName("Mootwane")
//                .referenceNo(UUID.randomUUID().toString())
//                .middleName("Keane")
//                .id(UUID.randomUUID())
//                .build();
//
//        doNothing().when(publisher).publishApplicationEvent(applicant);
//        when(applicantRepository.insert(applicant)).thenReturn(applicant);
//
//        Applicant created = applicationContext.getInstance(ApplicationStateType.CREATION, applicant);
//        System.out.println("created = " + created);
//        assertNotNull(created);
//        verify(publisher, times(1)).publishApplicationEvent(applicant);
//    }
//
//    @Test
//    public void testGetInstance_pendingReview() {
//        Applicant applicant = Applicant.builder()
//                .dob(new Date())
//                .email("Seletam@gmail.com")
//                .gender(GENDER.MALE).firstName("Seleta")
//                .lastName("Mootwane")
//                .referenceNo(UUID.randomUUID().toString())
//                .middleName("Keane")
//                .build();
//
//        doNothing().when(publisher).publishApplicationEvent(applicant);
//        when(applicantRepository.insert(applicant)).thenReturn(any(Applicant.class));
//
//        Applicant pendingReview = applicationContext.getInstance(ApplicationStateType.PENDING, applicant);
//        System.out.println("pendingReview = " + pendingReview);
//        assertNotNull(pendingReview);
////        assertEquals("Bursary application pending review.", pendingReview.printStatus());
//    }
//
//    @Test
//    public void testGetInstance_approved() {
//        Applicant applicant = Applicant.builder()
//                .dob(new Date())
//                .email("Seletam@gmail.com")
//                .gender(GENDER.MALE).firstName("Seleta")
//                .lastName("Mootwane")
//                .referenceNo(UUID.randomUUID().toString())
//                .middleName("Keane")
//                .build();
//
//        Applicant approved = applicationContext.getInstance(ApplicationStateType.ACCEPTED, applicant);
//        assertNotNull(approved);
////        assertEquals("Bursary application approved.", approved.printStatus());
//    }
//
//    @Test
//    public void testGetInstance_rejected() {
//        Applicant applicant = Applicant.builder()
//                .dob(new Date())
//                .email("Seletam@gmail.com")
//                .gender(GENDER.MALE).firstName("Seleta")
//                .lastName("Mootwane")
//                .referenceNo(UUID.randomUUID().toString())
//                .middleName("Keane")
//                .build();
//
//        Applicant rejected = applicationContext.getInstance(ApplicationStateType.REJECTED, applicant);
//        System.out.println("rejected = " + rejected);
//        assertNotNull(rejected);
////        assertEquals("Bursary application rejected.", rejected.printStatus());
//    }
//
//    @Test
//    public void testGetInstance_null() {
//        Applicant applicant = Applicant.builder()
//                .dob(new Date())
//                .email("Seletam@gmail.com")
//                .gender(GENDER.MALE).firstName("Seleta")
//                .lastName("Mootwane")
//                .referenceNo(UUID.randomUUID().toString())
//                .middleName("Keane")
//                .build();
//
//        Applicant nullState = applicationContext.getInstance(null, applicant);
//        assertNull(nullState);
//    }
}