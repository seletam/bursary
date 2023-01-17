package com.bursary.entities;

import java.io.Serializable;
import java.util.List;


import com.bursary.entities.objects.QUALIFICATION_STATUS;
import com.bursary.entities.objects.SCHOOL_TYPE;
import jakarta.persistence.*;

@Entity
public class Qualification implements Serializable {
	private static final long serialVersionUID = -6834848533187766894L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private SCHOOL_TYPE school_type;
	private String institution;
	private QUALIFICATION_STATUS qUALIFICATION_STATUS;
	
	@OneToMany
	private List<CourseModule> subjects;
}