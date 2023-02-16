package com.bursary.controller;

import java.util.UUID;


import com.bursary.entities.Applicant;
import com.bursary.services.ApplicantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/applicant")
@RequiredArgsConstructor
public class ApplicantController {

	private final ApplicantService applicantService;

	@GetMapping
	public ResponseEntity<Iterable<Applicant>> findAll() {
		return  ResponseEntity.ok().body(this.applicantService.getAllUser());
	}

	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Applicant> findOne(@PathVariable final UUID id) {
		Applicant applicant = applicantService.getUser(id);
		if (applicant == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(applicant);
	}

	@PostMapping
	public Applicant create(@RequestBody final Applicant applicant) {
		return this.applicantService.add(applicant);
	}

	@PutMapping("{id}")
	public ResponseEntity<Applicant> update(@PathVariable(value = "id") final UUID id,
			@RequestBody Applicant applicant) {
		Applicant app = applicantService.getUser(id);
		if (app == null) {
			return ResponseEntity.notFound().build();
		}

		app.setFirstName(applicant.getFirstName());
		app.setLastName(applicant.getLastName());
		app.setMiddleName(applicant.getMiddleName());
		app.setDob(applicant.getDob());
		app.setGender(applicant.getGender());
		app.setEmail(applicant.getEmail());
		app.setQualifications(applicant.getQualifications());
		app.setAddresses(applicant.getAddresses());

		Applicant updateApplicant = applicantService.add(app);
		return ResponseEntity.ok().body(updateApplicant);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<Applicant> delete(@PathVariable(value = "id") UUID id) {
		Applicant app = applicantService.getUser(id);
		if (app == null) {
			return ResponseEntity.notFound().build();
		}

		applicantService.delete(app);
		return ResponseEntity.ok().body(app);
	}

}