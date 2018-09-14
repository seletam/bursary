package com.bursary.bursary.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bursary.bursary.entities.Qualification;
import com.bursary.bursary.repository.QualificationRepository;

@Service
public class QualificationService {

	@Autowired
	QualificationRepository qualificationRepository;
	
	public List<Qualification> findAll() {
		return qualificationRepository.findAll();
	}
	
	public Optional<Qualification> findOne(Long id){
		return qualificationRepository.findById(id);
	}
	
	public void save(Qualification qualification) {
		qualificationRepository.save(qualification);
	}
}
