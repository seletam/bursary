package com.bursary.bursary.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*
 * Seleta M. Mootwane
 * 2018-08-23
 */
@Entity
public class Study implements Serializable {
	private static final long serialVersionUID = 8431202895362832156L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	public Study() {
		
	}
	public Study(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	public Study(final Long id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Study [getId()=" + getId() + ", getName()=" + getName() + "]";
	}
}