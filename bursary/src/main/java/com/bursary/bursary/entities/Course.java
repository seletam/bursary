package com.bursary.bursary.entities;
/*
 * Seleta M. Mootwane
 * 2018-08-23
 */
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