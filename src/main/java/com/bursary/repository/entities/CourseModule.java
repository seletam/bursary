package com.bursary.repository.entities;

import lombok.Getter;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType
@Getter
public class CourseModule extends BaseModal {
	private double score;

	public CourseModule(String name, double score) {
		super(name);
		this.score = score;
	}
}