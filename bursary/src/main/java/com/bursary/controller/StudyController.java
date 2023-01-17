package com.bursary.controller;

import java.util.List;

import com.bursary.entities.Study;
import com.bursary.services.StudyService;
import com.bursary.utils.ConstantsResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ConstantsResource.SITE_BASE_URI)
public class StudyController {

	@Autowired
    StudyService studyService;

	@GetMapping(value=ConstantsResource.FIELD_OF_STUDY_BASE_URI)
	public List<Study> findAll() {
		return studyService.findAll();
	}

	@GetMapping(value = ConstantsResource.FIELD_OF_STUDY_BASE_URI + "/{id}")
	public ResponseEntity<Study> findOne(@PathVariable final long id) {
		Study study = studyService.findOne(id);
		if (study == null) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.ok().body(study);
	}

	@GetMapping(value = ConstantsResource.FIELD_OF_STUDY_BASE_URI + '/' + ConstantsResource.UPDATE_FIELD_OF_STUDY_URI + "/{id}")
	public ResponseEntity<Study> update(@RequestBody final Study study, @PathVariable(value = "id") final long id) {
		Study studyServ = studyService.findOne(id);
		if (study == null) {
			return ResponseEntity.ok().build();
		}
		studyServ.setId(study.getId());
		studyServ.setName(study.getName());

		return ResponseEntity.ok().body(studyServ);
	}

	@DeleteMapping(value = ConstantsResource.FIELD_OF_STUDY_BASE_URI + '/' + ConstantsResource.DELETE_FIELD_OF_STUDY_URI + "/{id}")
	public ResponseEntity<Study> delete(@RequestBody final Study study, @PathVariable(value = "id") final long id) {
		Study studyServ = studyService.findOne(id);
		if (study == null) {
			return ResponseEntity.ok().build();
		}
		studyService.delete(studyServ);
		return ResponseEntity.ok().body(studyServ);
	}

	@PutMapping(value = ConstantsResource.FIELD_OF_STUDY_BASE_URI + '/' + ConstantsResource.CREATE_FIELD_OF_STUDY_URI)
	public Study save(@RequestBody final Study study) {
		return studyService.create(study);
	}

}