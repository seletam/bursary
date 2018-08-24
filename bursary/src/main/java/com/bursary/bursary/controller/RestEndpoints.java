package com.bursary.bursary.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bursary.bursary.entities.Course;

/*
 * Seleta M. Mootwane
 * 2018-08-23
 */
@RestController
public class RestEndpoints {
	@Value("${default.course.name}")
	private String cName;

	@Value("${default.course.chapterCount}")
	private Integer chapterCount;

	@RequestMapping("/course")
	public Course getEndPoint(@RequestParam(value = "name", defaultValue = "Spring Boot", required = false) String name,
			@RequestParam(value = "chapterCount", defaultValue = "2", required = false) Integer chapterCount) {
		return new Course(name, chapterCount);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/register/course")
	public String saveCourse(@RequestBody Course course) {
		return "" + course.getName() + " " + course.getChapterCount();
	}
}