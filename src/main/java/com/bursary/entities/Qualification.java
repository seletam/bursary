package com.bursary.entities;

import com.bursary.entities.objects.QUALIFICATION_STATUS;
import com.bursary.entities.objects.SCHOOL_TYPE;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Table
public class Qualification extends BaseModal {

	private SCHOOL_TYPE school_type;
	private String institution;
	private QUALIFICATION_STATUS qUALIFICATION_STATUS;
	@Transient
	private List<BaseModal> subjects;

	public Qualification(UUID id, String name) {
		super(id, name);
	}
}