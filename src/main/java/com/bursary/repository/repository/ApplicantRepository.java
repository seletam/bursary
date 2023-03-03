package com.bursary.repository.repository;

import com.bursary.repository.entities.Applicant;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApplicantRepository extends CassandraRepository<Applicant, UUID> {
    public Slice<Applicant> findAll(Pageable pageable);
    public Applicant deleteApplicantById(UUID id);
}