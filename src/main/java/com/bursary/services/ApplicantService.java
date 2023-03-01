package com.bursary.services;

import com.bursary.repository.ApplicantRepository;
import com.bursary.utils.exception.ApplicantNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.bursary.entities.Applicant;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicantService {

	private final ApplicantRepository applicantRepository;

	@Cacheable(value = "Applicants")
	public List<Applicant> getAllUser() {
		return this.applicantRepository.findAll();
	}

	@Cacheable(key = "#id", value = "Applicant")
	public Applicant getUser(UUID id) {
		log.info("applicant {} has been requested", id);
		Optional<Applicant> applicant = this.applicantRepository.findById(id);
		return applicant
				.orElseThrow(() -> new ApplicantNotFoundException("Applicant # " + id + " does not exist"));
	}

	public Applicant add(Applicant applicant) {
		return this.applicantRepository.insert(applicant);
	}

	@CachePut(key = "#applicant.id", value = "Applicant")
	public void update(Applicant applicant) {
		applicantRepository.deleteById(applicant.getId());
	}

	@CacheEvict(key = "#applicant.id", value = "Applicant", allEntries = false)
	public void delete(Applicant applicant) {
		applicantRepository.deleteById(applicant.getId());
	}
}
