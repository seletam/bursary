package com.bursary.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.bursary.entities.Study;
import com.bursary.services.StudyService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("study")
@RequiredArgsConstructor
public class StudyController {

    private final StudyService studyService;

	@GetMapping
	public List<Study> findAll() {
		return studyService.findAll();
	}

	@GetMapping(value =  "/{id}")
	public ResponseEntity<Study> findOne(@PathVariable final UUID id) {
		Optional<Study> study = Optional.ofNullable(studyService.findOne(id)
				.orElseThrow(() -> new IllegalStateException("Not found")));
		return ResponseEntity.ok().body(study.get());
	}

	@PutMapping(value =  "/{id}")
	public ResponseEntity<Study> update(@RequestBody final Study study, @PathParam(value = "id") final UUID id) {
		Optional<Study> studyServ = Optional.ofNullable(studyService.findOne(id)
				.orElseThrow(() -> new IllegalStateException("Not found")));
		studyServ.get().setName(study.getName());

		return ResponseEntity.ok().body(studyServ.get());
	}

	@DeleteMapping(value ="/{id}")
	public ResponseEntity<Study> delete(@PathVariable(value = "id") final UUID id) {
		Optional<Study> studyServ = Optional.ofNullable(studyService.findOne(id)
				.orElseThrow(() -> new IllegalStateException("Not found")));
		studyService.delete(studyServ.get());
		return ResponseEntity.ok().body(studyServ.get());
	}

	@PostMapping(value = "{id}")
	public ResponseEntity<Study> save(@RequestBody final Study study) {
		return ResponseEntity.ok(studyService.create(study));
	}

}