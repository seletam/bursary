package com.bursary.entities;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

@Table
@Data
public class CourseModule {
	@PrimaryKey
	@Setter(AccessLevel.NONE)
	@PrimaryKeyColumn(
			name = "id")
	private UUID id;
	private String name;
	private double score;
}