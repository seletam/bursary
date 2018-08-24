package com.bursary.bursary.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.bursary.bursary.entities.Applicant;
import com.bursary.bursary.services.ApplicantService;
import com.bursary.bursary.utils.ConstantsResource;
/*
 * Seleta M. Mootwane
 * 2018-08-23
 */
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

	// get users by field of study
	@GetMapping(value = ConstantsResource.APPLICANTS_BASE_URI + '/' + ConstantsResource.FIELD_OF_STUDY_BASE_URI + "/{id}")
	public List<Applicant> getApplicantsByStudyField(@PathVariable final Long id) {
		return applicantService.findByStudies(id);
	}

	// save
	@PostMapping(value = ConstantsResource.CREATE_APPLICANT_URI)
	public Applicant create(@Valid @RequestBody final Applicant applicant) {
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
		app.setFieldOfStudy(applicant.getFieldOfStudy());
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