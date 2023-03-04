package com.bursary.controller;


import com.bursary.repository.entities.Applicant;
import com.bursary.services.ApplicantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/applicants")
@RequiredArgsConstructor
public class ApplicantController {

	private final ApplicantService applicantService;

	@GetMapping
	public ResponseEntity<List<Applicant>> getAllApplicants() {
		return  ResponseEntity.ok().body(this.applicantService.findAllApplicants().getContent());
	}

	@GetMapping("{id}")
	public ResponseEntity<Applicant> getApplicantById(@PathVariable final UUID id) {
		return new ResponseEntity<>(applicantService.findApplicantById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UUID> createApplicant(@Validated @RequestBody final Applicant applicant) {
		return new ResponseEntity<>(this.applicantService.saveApplicant(applicant), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<UUID> updateApplicant(@Validated @RequestBody final Applicant applicant) {
		return new ResponseEntity<>(applicantService.saveApplicant(applicant), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<UUID> deleteApplicantById(@Validated @RequestBody final Applicant applicant) {
		return new ResponseEntity<>(applicantService.deleteApplicant(applicant.getId()), HttpStatus.ACCEPTED);
	}

}