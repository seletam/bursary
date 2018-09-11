package com.bursary.bursary.controller;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bursary.bursary.entities.Applicant;
import com.bursary.bursary.enumerator.GENDER;
import com.bursary.bursary.services.ApplicantService;

@Controller
public class ThymeleafController {
	@Autowired
	private ApplicantService applicantService;
	// private final static Logger log = Logger.getLogger(Logger.ROOT_LOGGER_NAME);
	private Map<Long, Applicant> applicantMap = new HashMap<>();

	@RequestMapping(value = "/applications", method = RequestMethod.GET)
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
		System.out.println(applicant);
		return "register";
	}

	/**
	 * @param @Valid @ModelAttribute Applicant applicant
	 * 
	 * @return result
	 */
	@Transactional
	@PostMapping("addApplication")
	public String applicationSubmit(@ModelAttribute Applicant applicant) {

		applicantService.add(applicant);
		
		
		/*
		 * model.addAttribute("fname", applicant.getFirstName());
		 * model.addAttribute("mname", applicant.getMiddleName());
		 * model.addAttribute("id", applicant.getId()); model.addAttribute("lname",
		 * applicant.getLastName()); model.addAttribute("dob", applicant.getDob());
		 * model.addAttribute("gender", applicant.getGender());
		 * model.addAttribute("email", applicant.getEmail());
		 * model.addAttribute("field", applicant.getFieldOfStudy());
		 * model.addAttribute("qualificationid", applicant.getQualification());
		 * model.addAttribute("address", applicant.getAddress());
		 */

		// applicantMap.put(applicant.getId(), applicant);
		//System.out.println(applicant);
		// applicantService.add(applicant);
		applicantService.getUser(applicant.getId());

		return "result";
	}

	@ModelAttribute("multiCheckboxAllValues")
	public String[] getMultiCheckboxAllValues() {
		return new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
	}
}