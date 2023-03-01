package com.bursary.entities;

import lombok.Getter;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
@Getter
public class CourseModule extends BaseModal {
	private double score;

	public CourseModule(UUID id, String name, double score) {
		super(id, name);
		this.score = score;
	}
}