package com.org.backendjava.domain.entity;



import com.org.backendjava.domain.enums.GroupType;

public class Player {
	private String id;
	private String playerName;
	private String email;
	private String phone;
	private String codeName;
	private GroupType playerGroup;
	
	public Player() {
	}

	public Player(String id, String playerName, String email, String phone, String codeName, GroupType playerGroup) {
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

	public GroupType getPlayerGroup() {
		return playerGroup;
	}

	public void setPlayerGroup(GroupType playerGroup) {
		this.playerGroup = playerGroup;
	}
}