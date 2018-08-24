package com.bursary.bursary.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("course")
public class CourseConfiguration {
	private String name;
	private Integer chapterCount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getChapterCount() {
		return chapterCount;
	}

	public void setChapterCount(Integer chapterCount) {
		this.chapterCount = chapterCount;
	}

}