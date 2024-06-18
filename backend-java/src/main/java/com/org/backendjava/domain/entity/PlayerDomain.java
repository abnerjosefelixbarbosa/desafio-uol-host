package com.org.backendjava.domain.entity;



import com.org.backendjava.domain.enums.GroupTypeDomain;

public class PlayerDomain {
	private String id;
	private String playerName;
	private String email;
	private String phone;
	private String codeName;
	private GroupTypeDomain playerGroup;
	
	public PlayerDomain() {
	}

	public PlayerDomain(String id, String playerName, String email, String phone, String codeName, GroupTypeDomain playerGroup) {
		this.id = id;
		this.playerName = playerName;
		this.email = email;
		this.phone = phone;
		this.codeName = codeName;
		this.playerGroup = playerGroup;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public GroupTypeDomain getPlayerGroup() {
		return playerGroup;
	}

	public void setPlayerGroup(GroupTypeDomain playerGroup) {
		this.playerGroup = playerGroup;
	}
}