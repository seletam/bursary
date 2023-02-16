package com.bursary.services;

import java.util.Optional;
import java.util.UUID;

import com.bursary.utils.exception.ApplicantNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.bursary.entities.Applicant;
import com.bursary.repository.ApplicantRepository;

@Service
@RequiredArgsConstructor
public class ApplicantService {

	private final ApplicantRepository applicantRepository;

	public Iterable<Applicant> getAllUser() {
		return this.applicantRepository.findAll();
	}

	public Applicant getUser(UUID id) {
		Optional<Applicant> applicant = this.applicantRepository.findById(id);
		return applicant
				.orElseThrow(() -> new ApplicantNotFoundException("Applicant # " + id + " does not exist"));
	}

	public Applicant add(Applicant applicant) {
		return this.applicantRepository.insert(applicant);
	}
	public void delete(Applicant applicant) {
		applicantRepository.deleteById(applicant.getId());
	}
}
