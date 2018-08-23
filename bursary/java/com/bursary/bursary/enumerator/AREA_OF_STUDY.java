package com.bursary.bursary.enumerator;

public enum AREA_OF_STUDY {
	ELECTRONIC_ENGINEERING("ELECTRONIC ENGINEERING"), COMPUTER_ENGINEERING("COMPUTER ENGINEERING"),
	SOFTWARE_ENGINEERING("SOFTWARE ENGINEERING"), CIVIL_ENGINEERING("CIVIL ENGINEERING");

	private final String field;

	private AREA_OF_STUDY(final String field) {
		this.field = field;
	}

	public String getStudyField() {
		return field;
	}
}
