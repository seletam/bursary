package com.bursary.repository;

import com.bursary.entities.Application;
import com.bursary.state.ApplicationStatus;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApplicationRepository extends CassandraRepository<Application, UUID> {
    // Query to fetch all applications
    @Query("SELECT * FROM application")
    Slice<Application> findAllApplications(Pageable pageable);

    // Query to fetch applications with a specific status
    @Query("SELECT * FROM application WHERE status = ?0")
    Slice<Application> findApplicationsByStatus(ApplicationStatus status, Pageable pageable);

    // Query to fetch applications for a specific applicant
    @Query("SELECT * FROM application WHERE applicant_id = ?0")
    Slice<Application> findApplicationsByApplicant(UUID applicantId, Pageable pageable);

    Application insert(Application application);
}