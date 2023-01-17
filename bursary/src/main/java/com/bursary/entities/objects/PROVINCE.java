package com.bursary.entities.objects;

public enum PROVINCE {
	LIMPOPO("LIMPOPO"), NORTH_WEST("NORTH WEST"), MPUMALANGA("MPUMALANGA"), GAUTENG("GAUTENG"), NORTHERN_CAPE("NORTHERN CAPE"), KWA_ZULU_NATAL("KWA ZULU NATAL"), WESTERN_CAPE("WESTERN CAPE"), FREE_STATE("FREE STATE"), EASTERN_CAPE("EASTERN CAPE");
	
	private final String provinceName;
	
	private PROVINCE(final String provinceName) {
		this.provinceName = provinceName;
	}
	
	public String getProvinceName() {
		return provinceName;
	}
}
