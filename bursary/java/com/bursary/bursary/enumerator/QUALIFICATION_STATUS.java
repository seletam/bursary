package com.bursary.bursary.enumerator;

public enum QUALIFICATION_STATUS {
	COMPLETED("Completed"), ON_PROGRESS("On progress");

	private final String status;

	private QUALIFICATION_STATUS(final String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
