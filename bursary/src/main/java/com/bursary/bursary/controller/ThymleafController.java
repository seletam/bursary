package com.bursary.bursary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.bursary.bursary.services.ApplicantService;

public class ThymleafController {
	@Autowired
	private ApplicantService applicantService;

	@GetMapping
	public String getDashDetail(Model model) {
		model.addAttribute("applications", applicantService.getAllUser());
		
		System.out.println(model);
		return "/index";
	}
}
