package com.bursary.bursary.controller;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bursary.bursary.entities.Applicant;
import com.bursary.bursary.entities.Qualification;
import com.bursary.bursary.entities.Study;
import com.bursary.bursary.services.ApplicantService;
import com.bursary.bursary.services.QualificationService;

@Controller
public class ThymeleafController {
	@Autowired
	private ApplicantService applicantService;

	@Autowired
	private QualificationService qualificationService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getApplications(ModelMap model) {
		model.addAttribute("cp", applicantService.getAllUser());

		model.addAttribute("pageTitle", "Bursary");

		return "index";
	}

	/**
	 * @param Model model
	 * 
	 * @return register
	 */
	@GetMapping("registration")
	public String applicationForm(Model model, Applicant applicant) {
		model.addAttribute("applicant", new Applicant());

		model.addAttribute("study", new Study());
		model.addAttribute("qualification", new Qualification());

		return "register";
	}

	/**
	 * @param @Valid @ModelAttribute Applicant applicant
	 * 
	 * @return result
	 */
	@Transactional
	@PostMapping("save")
	public String applicationSubmit(Applicant applicant, Model model, Qualification qualification) {
		qualificationService.save(qualification);

		applicantService.add(applicant);

		model.addAttribute("applicantDetails", applicantService.getUser(applicant.getId()));

		return "result";
	}

	@GetMapping(value = "view/{id}")
	public String getApplicant(Model model, @PathVariable(value = "id") final Long id) {
		model.addAttribute("applicantDetails", applicantService.getUser(id));

		return "result";
	}

	@ModelAttribute("multiCheckboxAllValues")
	public String[] getMultiCheckboxAllValues() {
		return new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
	}
}