package com.bursary.repository;

import com.bursary.entities.Applicant;
import com.bursary.entities.objects.GENDER;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicantRepositoryTest {

    @Mock
    private ApplicantRepository applicantRepository;


    @Test
    public void readsApplicantTableCorrectly() {
        Iterable<Applicant> applicants = applicantRepository.findAll();
        assertThat(applicants.iterator().hasNext()).isFalse();
    }

    @Test
    public void testFindApplicantById() {
        // Given
        UUID id = UUID.randomUUID();
        Applicant applicant = Applicant.builder()
                .id(id)
                .dob(new Date())
                .email("Seletam@gmail.com")
                .gender(GENDER.MALE).firstName("Seleta")
                .lastName("Mootwane")
                .referenceNo(UUID.randomUUID().toString())
                .middleName("Keane")
                .build();

        applicantRepository.save(applicant);

        // When
        Optional<Applicant> result = applicantRepository.findById(id);

        // Then
        assertTrue(result.isPresent());
        assertEquals(applicant, result.get());
    }

    @Test
    public void testSaveApplicant() {
        // Given
        UUID id = UUID.randomUUID();
        Applicant applicant = Applicant.builder()
                .id(id)
                .dob(new Date())
                .email("Seletam@gmail.com")
                .gender(GENDER.MALE).firstName("Seleta")
                .lastName("Mootwane")
                .referenceNo(UUID.randomUUID().toString())
                .middleName("Keane")
                .build();

        // When
        Applicant result = applicantRepository.save(applicant);

        // Then
        assertEquals(applicant, result);
        assertEquals(applicant, applicantRepository.findById(id).get());
    }

    @Test
    public void testDeleteApplicantById() {
        // Given
        UUID id = UUID.randomUUID();
        Applicant applicant = Applicant.builder()
                .id(id)
                .dob(new Date())
                .email("Seletam@gmail.com")
                .gender(GENDER.MALE).firstName("Seleta")
                .lastName("Mootwane")
                .referenceNo(UUID.randomUUID().toString())
                .middleName("Keane")
                .build();

        applicantRepository.save(applicant);

        // When
        applicantRepository.deleteById(id);

        // Then
        assertFalse(applicantRepository.findById(id).isPresent());
    }

    @Test
    public void testFindApplicantByIdNotFound() {
        // Given
        UUID id = UUID.randomUUID();
        Applicant applicant = Applicant.builder()
                .id(id)
                .dob(new Date())
                .email("Seletam@gmail.com")
                .gender(GENDER.MALE).firstName("Seleta")
                .lastName("Mootwane")
                .referenceNo(UUID.randomUUID().toString())
                .middleName("Keane")
                .build();

        // When
        Optional<Applicant> result = applicantRepository.findById(id);

        // Then
        assertFalse(result.isPresent());
    }

    @Test
    public void testSaveApplicantWithExistingId() {
        // Given
        UUID id = UUID.randomUUID();
        Applicant applicant = Applicant.builder()
                .id(id)
                .dob(new Date())
                .email("Seletam@gmail.com")
                .gender(GENDER.MALE).firstName("Seleta")
                .lastName("Mootwane")
                .referenceNo(UUID.randomUUID().toString())
                .middleName("Keane")
                .build();

        applicantRepository.save(applicant);
        Applicant updatedApplicant = Applicant.builder()
                .id(id)
                .dob(new Date())
                .email("Seletam@gmail.com")
                .gender(GENDER.MALE).firstName("Seleta")
                .lastName("Mootwane")
                .referenceNo(UUID.randomUUID().toString())
                .middleName("Keane")
                .build();

        // When
        Applicant result = applicantRepository.save(updatedApplicant);

        // Then
        assertEquals(updatedApplicant, result);
        assertEquals(updatedApplicant, applicantRepository.findById(id).get());
    }
}