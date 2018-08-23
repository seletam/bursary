package com.bursary.bursary.entities;

public class Course {
	private String name;
	private Integer chapterCount;

	public Course(String name, Integer chapterCount) {
		this.name = name;
		this.chapterCount = chapterCount;
	}

	public Integer getChapterCount() {
		return chapterCount;
	}

	public String getName() {
		return name;
	}
}