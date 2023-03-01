package com.bursary.entities;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Getter
@Table
public class Course extends BaseModal {
	private Integer chapterCount;

	@Builder
	public Course(UUID id, String name, Integer chapterCount) {
		super(id, name);
		this.chapterCount = chapterCount;
	}
}