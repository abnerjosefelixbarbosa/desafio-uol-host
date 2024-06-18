package com.org.backendjava.infra.enums;

public enum GroupTypeDB {
    AVENGER("AVENGER"), JUSTICE_LEAGUE("JUSTICE_LEAGUE");
	
	private String type;

	private GroupTypeDB(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
