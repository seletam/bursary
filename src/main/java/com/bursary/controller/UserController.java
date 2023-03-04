package com.bursary.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope (value = "session")
@Component (value = "userList")
@RequiredArgsConstructor
public class UserController {

//    private final ApplicantService applicantService;
//
//	@RequestMapping(method = RequestMethod.GET)
//	public Iterable<Applicant> getAllUser(){
//		return this.applicantService.getAllUser();
//	}
//
//	@GetMapping(value= "/{id}")
//	public Applicant getUser(@PathVariable final UUID id){
//		return this.applicantService.getUser(id);
//	}
//
//	@PostMapping(value ="/add")
//	public Applicant add(@RequestBody final Applicant applicant) {
//		return this.applicantService.add(applicant);
//	}
}