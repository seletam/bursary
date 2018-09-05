package com.bursary.bursary.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bursary.bursary.entities.Applicant;
import com.bursary.bursary.entities.Study;
import com.bursary.bursary.repository.ApplicantRepository;

@Service
public class ApplicantService {
	
	@Autowired
	ApplicantRepository applicantRepository;

	public List<Applicant> getAllUser() {
		return this.applicantRepository.findAll();
	}

	public Applicant getUser(Long id) {
		return this.applicantRepository.getOne(id);
	}

	public Applicant add(Applicant applicant) {
		return this.applicantRepository.save(applicant);
	}
	public void delete(Applicant applicant) {
		applicantRepository.deleteById(applicant.getId());
	}
	
	public List<Applicant> findByStudies(Long studyId) {
		return applicantRepository.findByStudy(new Study(studyId));
	}
	
	public Applicant deleteByStudies(Long studyId) {
		return applicantRepository.deleteByStudy(new Study(studyId));
	}
	
	public HashMap<String, Applicant> getApplicantions() {
		HashMap<String, Applicant> noOfApplications = new HashMap<>();
		List<Applicant> applicantionList = applicantRepository.findAll();
		for (Applicant applicant : applicantionList) {
			//getTotalApplicants
			//get
		}
		return noOfApplications;
		
	}
}
