package com.bursary.bursary.entities;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.bursary.bursary.enumerator.QUALIFICATION_STATUS;
import com.bursary.bursary.enumerator.SCHOOL_TYPE;
/*
 * Seleta M. Mootwane
 * 2018-08-23
 */
@Entity
public class Qualification  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private SCHOOL_TYPE school_type;
	private String institution;
	private QUALIFICATION_STATUS QUALIFICATION_STATUS;
	
	@ManyToMany
	private Set<Subject> subjects;

	public Qualification() {
		
	}
	
	public Qualification(Long id, String name, String institution, QUALIFICATION_STATUS QUALIFICATION_STATUS, Set<Subject> subjects, SCHOOL_TYPE school_type) {
		this.id = id;
		this.name = name;
		this.institution = institution;
		this.QUALIFICATION_STATUS = QUALIFICATION_STATUS;
		this.subjects = subjects;
		this.school_type = school_type;
	}



	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public Set<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public QUALIFICATION_STATUS getStatus() {
		return QUALIFICATION_STATUS;
	}

	public void setStatus(QUALIFICATION_STATUS QUALIFICATION_STATUS) {
		this.QUALIFICATION_STATUS = QUALIFICATION_STATUS;
	}

	public SCHOOL_TYPE getSchool_type() {
		return school_type;
	}

	public void setSchool_type(SCHOOL_TYPE school_type) {
		this.school_type = school_type;
	}
	
}