package com.org.backendjava.enums;

public enum GroupType {
	AVENGER("AVENGER"), JUSTICE_LEAGUE("JUSTICE_LEAGUE");
	
	private String type;

	private GroupType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}