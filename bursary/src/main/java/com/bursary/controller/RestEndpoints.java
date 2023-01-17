package com.bursary.controller;

import com.bursary.entities.Course;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestEndpoints {
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