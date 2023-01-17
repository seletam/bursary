package com.bursary.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bursary.entities.Applicant;
import com.bursary.repository.ApplicantRepository;

@Service
public class ApplicantDAO {

	@Autowired
	ApplicantRepository applicantRepository;
	
	public Applicant save(Applicant app) {
		return applicantRepository.save(app);
	}
	
	public List<Applicant> findAll(){
		return applicantRepository.findAll();
	}
	
	public Applicant findOne(Long applicant_id) {
		return applicantRepository.getOne(applicant_id);
	}
	
	public void delete(Applicant app) {
		applicantRepository.delete(app);
	}
}
