package com.bursary.repository;

import com.bursary.repository.repository.ApplicationRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.cassandra.core.CassandraOperations;

import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.bindMarker;
import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.literal;
import static org.mockito.Mockito.verify;

/**
 *
 */
@ExtendWith(MockitoExtension.class)
public class ApplicationRepositoryTest {

    @Mock
    private CassandraOperations cassandraOperations;

    @InjectMocks
    private ApplicationRepository applicationRepository;

    @Test
    public void testFindByStatusWithPagination() {
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
