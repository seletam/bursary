package com.bursary.repository;

import com.bursary.entities.Applicant;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ApplicantRepository extends BursaryRepository<Applicant, UUID> {
    @AllowFiltering
    public Optional<Applicant> findById(UUID id);

    public Applicant insert(Applicant applicant);

    public void deleteById(UUID id);
}