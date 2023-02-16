package com.bursary.entities;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@Table
@Builder
public class Course {
	@PrimaryKey
	@Setter(AccessLevel.NONE)
	private UUID id;
	private String name;
	private Integer chapterCount;
}