package com.bursary.controller;

import java.util.List;


import com.bursary.entities.Applicant;
import com.bursary.services.ApplicantService;
import com.bursary.utils.ConstantsResource;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(ConstantsResource.SITE_BASE_URI)
public class ApplicantController {
	@Autowired
	ApplicantService applicantService;

	// get all
	@GetMapping(value = ConstantsResource.APPLICANTS_BASE_URI)
	@ResponseStatus(HttpStatus.OK)
	public List<Applicant> findAll() {
		return this.applicantService.getAllUser();
	}

	// get 1
	@GetMapping(value = ConstantsResource.APPLICANTS_BASE_URI + "/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Applicant> findOne(@PathVariable final Long id) {
		Applicant applicant = applicantService.getUser(id);
		if (applicant == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(applicant);
	}

	// save
	@PostMapping(value = ConstantsResource.CREATE_APPLICANT_URI)
	public Applicant create(@RequestBody final Applicant applicant) {
		return this.applicantService.add(applicant);
	}

	// update
	@PutMapping(value = ConstantsResource.APPLICANTS_BASE_URI + '/' + ConstantsResource.UPDATE_APPLICANT_URI + "/{id}")
	public ResponseEntity<Applicant> update(@PathVariable(value = "id") final Long id,
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
		app.setQualification(applicant.getQualification());
		app.setAddress(applicant.getAddress());

		Applicant updateApplicant = applicantService.add(app);
		return ResponseEntity.ok().body(updateApplicant);

	}

	// delete
	@DeleteMapping(value = ConstantsResource.APPLICANTS_BASE_URI + '/' + ConstantsResource.DELETE_APPLICANT_URI
			+ "/{id}")
	public ResponseEntity<Applicant> delete(@PathVariable(value = "id") Long id) {
		Applicant app = applicantService.getUser(id);
		if (app == null) {
			return ResponseEntity.notFound().build();
		}

		applicantService.delete(app);
		return ResponseEntity.ok().body(app);
	}

}