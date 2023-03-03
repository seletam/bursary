//package com.bursary.services;
//
//import com.bursary.repository.entities.Applicant;
//import com.bursary.common.constant.GENDER;
//import com.bursary.repository.repository.ApplicantRepository;
//import com.bursary.common.exception.utils.ApplicantNotFoundException;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Date;
//import java.util.Optional;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class ApplicantServiceTest {
//
//        private ApplicantRepository applicantRepository = Mockito.mock(ApplicantRepository.class);
//        private final ApplicantService applicantService = new ApplicantService(applicantRepository);
//
//        @Test
//        public void testGetUser_whenApplicantExists_returnsApplicant() {
//            UUID id = UUID.randomUUID();
//            Applicant expectedApplicant = Applicant.builder()
//                    .id(id)
//                    .dob(new Date())
//                    .email("Seletam@gmail.com")
//                    .gender(GENDER.MALE).firstName("Seleta")
//                    .lastName("Mootwane")
//                    .referenceNo(UUID.randomUUID().toString())
//                    .middleName("Keane")
//                    .build();
//
//            Mockito.when(applicantRepository.findById(id)).thenReturn(Optional.of(expectedApplicant));
//            Applicant result = applicantService.getUser(id);
//            assertEquals(expectedApplicant, result);
//        }
//
//        @Test
//        public void testGetUser_whenApplicantDoesNotExist_throwsApplicantNotFoundException() {
//            UUID id = UUID.randomUUID();
//            Mockito.when(applicantRepository.findById(id)).thenReturn(Optional.empty());
//            assertThrows(ApplicantNotFoundException.class, () -> applicantService.getUser(id));
//        }
//
//        @Test
//        public void testGetUser_whenIdIsNull_throwsApplicantNotFoundException() {
//            UUID id = null;
//            assertThrows(ApplicantNotFoundException.class, () -> applicantService.getUser(id));
//        }
//
//        @Test
//        public void testGetUser_whenIdIsInvalid_throwsApplicantNotFoundException() {
//            UUID id = UUID.fromString("invalid-uuid");
//            assertThrows(IllegalArgumentException.class, () -> applicantService.getUser(id));
//        }
//
//        @Test
//        public void testGetUser_whenRepositoryFindByIdThrowsException_throwsException() {
//            UUID id = UUID.randomUUID();
//            Mockito.when(applicantRepository.findById(id)).thenThrow(new RuntimeException("Something went wrong"));
//            assertThrows(RuntimeException.class, () -> applicantService.getUser(id));
//        }
//    }