package com.bursary.services;

import com.bursary.repository.repository.ApplicantRepository;
import com.bursary.common.utils.exception.ApplicantNotFoundException;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import com.bursary.repository.entities.Applicant;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class ApplicantService {

	private final ApplicantRepository applicantRepository;
	private final ObservationRegistry observationRegistry;

	@Autowired
	public ApplicantService(ApplicantRepository applicantRepository, ObservationRegistry observationRegistry) {
		this.applicantRepository = applicantRepository;
		this.observationRegistry = observationRegistry;
	}

	@Cacheable(value = "Applicants")
	public Slice<Applicant> findAllApplicants() {
		return Observation
				.createNotStarted("allApplicants", observationRegistry)
				.observe(() -> this.applicantRepository.findAll(Pageable.ofSize(10)));
	}

	@Cacheable(key = "#id", value = "Applicant")
	public Applicant findApplicantById(UUID id) {
		log.info("applicant {} has been requested", id);
		return Observation
				.createNotStarted("getApplicant", observationRegistry)
				.observe(() -> this.applicantRepository.findById(id).orElseThrow(() -> new ApplicantNotFoundException("Applicant not found with id " + id)));
	}

	public UUID saveApplicant(Applicant applicant) {
		return this.applicantRepository.insert(applicant).getId();
	}

	@CachePut(key = "#applicant.id", value = "Applicant")
	public UUID updateApplicant(UUID id, Applicant applicant) {
		Optional<Applicant> existingApplicant = applicantRepository.findById(id);
		existingApplicant.orElseThrow(() -> new ApplicantNotFoundException("Not applicant found with id " + id));
		if (existingApplicant.isPresent()) {
			return applicantRepository.insert(applicant).getId();
		}
		return null;
	}

	@CacheEvict(key = "#applicant.id", value = "Applicant", allEntries = false)
	public UUID deleteApplicant(UUID uuid) {
		Optional<Applicant> existingApplicant = applicantRepository.findById(uuid);
		existingApplicant.orElseThrow(() -> new ApplicantNotFoundException("Not applicant found with id " + uuid));
		if (existingApplicant.isPresent()) {
			return applicantRepository.deleteApplicantById(existingApplicant.get().getId()).getId();
		}
		return null;
	}
}
