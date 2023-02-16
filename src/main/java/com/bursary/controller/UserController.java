package com.bursary.controller;

import java.util.UUID;

import com.bursary.entities.Applicant;
import com.bursary.services.ApplicantService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Scope (value = "session")
@Component (value = "userList")
@RequiredArgsConstructor
public class UserController {

    private final ApplicantService applicantService;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Applicant> getAllUser(){
		return this.applicantService.getAllUser();
	}
	
	@GetMapping(value= "/{id}")
	public Applicant getUser(@PathVariable final UUID id){
		return this.applicantService.getUser(id);
	}
	
	@PostMapping(value ="/add")
	public Applicant add(@RequestBody final Applicant applicant) {
		return this.applicantService.add(applicant);	
	}
}