package com.org.backendjava.domain.enums;

public enum GroupTypeDomain {
	AVENGER("AVENGER"), JUSTICE_LEAGUE("JUSTICE_LEAGUE");
	
	private String type;

	private GroupTypeDomain(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}