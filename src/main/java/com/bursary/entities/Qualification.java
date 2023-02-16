package com.bursary.entities;

import com.bursary.entities.objects.QUALIFICATION_STATUS;
import com.bursary.entities.objects.SCHOOL_TYPE;
import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Qualification {
	@PrimaryKey
	@Setter(AccessLevel.NONE)
	private UUID id;
	private String name;
	private SCHOOL_TYPE school_type;
	private String institution;
	private QUALIFICATION_STATUS qUALIFICATION_STATUS;
	@Transient
	private List<CourseModule> subjects;
}