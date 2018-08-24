package com.bursary.bursary.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bursary.bursary.entities.Applicant;
import com.bursary.bursary.services.ApplicantService;
/*
 * Seleta M. Mootwane
 * 2018-08-23
 */
@Scope (value = "session")
@Component (value = "userList")
public class UserListController {
	
	@Autowired
	ApplicantService applicantService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Applicant> getAllUser(){
		return this.applicantService.getAllUser();
	}
	
	@GetMapping(value= "/{id}")
	public Applicant getUser(@PathVariable final Long id){
		return this.applicantService.getUser(id);
	}
	
	@PostMapping(value ="/add")
	public Applicant add(@RequestBody final Applicant applicant) {
		return this.applicantService.add(applicant);	
	}
}