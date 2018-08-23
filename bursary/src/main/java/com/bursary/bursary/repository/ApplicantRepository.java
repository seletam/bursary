package com.bursary.bursary.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bursary.bursary.entities.Applicant;
import com.bursary.bursary.entities.Study;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
	public List<Applicant> findByStudy(Study study);
	public Applicant deleteByStudy(Study study);
}