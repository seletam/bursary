package com.bursary.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.bursary.entities.Study;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bursary.repository.StudyFieldRepository;

@Service
@RequiredArgsConstructor
public class StudyService {

	private final StudyFieldRepository studyFieldRepository;

	// save
	public Study create(Study study) {
		return this.studyFieldRepository.save(study);
	}
	// get all
	public List<Study> findAll() {
		return this.studyFieldRepository.findAll();
	}
	// get one
	public Optional<Study> findOne(UUID id) {
		return this.studyFieldRepository.findById(id);
	}
	// get one
	public Study update(Study study) {
		return this.studyFieldRepository.save(study);
	}
	// delete one
	public void delete(Study study) {
		this.studyFieldRepository.delete(study);
	}
}