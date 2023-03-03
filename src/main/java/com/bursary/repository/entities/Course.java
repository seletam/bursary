package com.bursary.repository.entities;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@Getter
@UserDefinedType
public class Course extends BaseModal {
	private Integer chapterCount;

	@Builder
	public Course(String name, Integer chapterCount) {
		super(name);
		this.chapterCount = chapterCount;
	}
}