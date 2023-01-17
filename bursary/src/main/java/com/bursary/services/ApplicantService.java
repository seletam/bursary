package com.bursary.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bursary.entities.Applicant;
import com.bursary.repository.ApplicantRepository;

@Service
public class ApplicantService {
	
	@Autowired
	ApplicantRepository applicantRepository;

	public List<Applicant> getAllUser() {
		return this.applicantRepository.findAll();
	}

	public Applicant getUser(Long id) {
		return this.applicantRepository.getOne(id);
	}

	public Applicant add(Applicant applicant) {
		return this.applicantRepository.save(applicant);
	}
	public void delete(Applicant applicant) {
		applicantRepository.deleteById(applicant.getId());
	}
}
