package com.bursary.services;

import java.util.List;

import com.bursary.entities.Study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bursary.repository.StudyFieldRepository;

@Service
public class StudyService {

	@Autowired
	StudyFieldRepository studyFieldRepository;

	// save
	public Study create(Study study) {
		return this.studyFieldRepository.save(study);
	}
	// get all
	public List<Study> findAll() {
		return this.studyFieldRepository.findAll();
	}
	// get one
	public Study findOne(Long id) {
		return this.studyFieldRepository.getOne(id);
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