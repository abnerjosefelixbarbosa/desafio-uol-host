package com.org.backendjava.domain.dto;

import com.org.backendjava.domain.enums.GroupTypeDomain;
import com.org.backendjava.infra.entity.PlayerDB;

public class RegisterPlayerView {
	private String id;
	private String playerName;
	private String email;
	private String phone;
	private String codeName;
	private GroupTypeDomain playerGroup;
	
	public RegisterPlayerView() {
	}
	
	public RegisterPlayerView(String id, String playerName, String email, String phone, String codeName,
			GroupTypeDomain playerGroup) {
		this.id = id;
		this.playerName = playerName;
		this.email = email;
		this.phone = phone;
		this.codeName = codeName;
		this.playerGroup = playerGroup;
	}

	public RegisterPlayerView(PlayerDB playerDB) {
		this.id = playerDB.getId();
		this.playerName = playerDB.getPlayerName();
		this.email = playerDB.getEmail();
		this.phone = playerDB.getPhone();
		this.codeName = playerDB.getCodeName();
		this.playerGroup = GroupTypeDomain.valueOf(playerDB.getPlayerGroup().getType());
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