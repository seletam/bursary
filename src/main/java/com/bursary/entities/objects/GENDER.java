package com.bursary.entities.objects;

public enum GENDER {
	MALE("Male"), FEMALE("Female");

	private final String name;

	private GENDER(final String name) {
		this.name = name;
	}

	public String getGender() {
		return name;
	}
}