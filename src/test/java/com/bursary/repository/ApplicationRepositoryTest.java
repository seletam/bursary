package com.bursary.repository;

import com.bursary.entities.Applicant;
import com.bursary.entities.Application;
import com.bursary.entities.Status;
import com.bursary.state.ApplicationStatus;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.bindMarker;
import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.literal;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplicationRepositoryTest {

    @Mock
    private CassandraOperations cassandraOperations;

    @InjectMocks
    private ApplicationRepository applicationRepository;

    @Test
    void testFindByStatusWithPagination() {
        // Set up test data
//        List<Application> applications = Arrays.asList(
//                Application.builder().id(UUID.randomUUID()).applicant(Applicant.applicantBuilder().firstName("John").lastName("Doe").build()).status(Status.builder().status(ApplicationStatus.CREATED).build()).build(),
//                Application.builder().id(UUID.randomUUID()).applicant(Applicant.applicantBuilder().firstName("Jane").lastName( "Doe").build()).status(Status.builder().status(ApplicationStatus.PENDING).build()).build(),
//                Application.builder().id(UUID.randomUUID()).applicant(Applicant.applicantBuilder().firstName("Bob").lastName("Smith").build()).status(Status.builder().status(ApplicationStatus.SHORTLISTED).build()).build()
//        );
//        Select select = QueryBuilder.selectFrom("applications")
//                .all()
//                .whereColumn("status").isEqualTo(literal("PENDING"));
//
//        when(cassandraOperations.select(select.build(), Application.class))
//                .thenReturn(applications);
//
//        // Call the repository method
//        Slice<Application> result = applicationRepository.findApplicationsByStatus(ApplicationStatus.PENDING, Pageable.ofSize(20));
//
//        // Verify the results
//        assertEquals(applications, result);
//        verify(cassandraOperations).select(select, Application.class);
    }
}
