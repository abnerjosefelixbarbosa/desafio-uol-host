package com.org.backendjava.infra.entity;

import com.org.backendjava.enums.GroupType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_tb")
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(name = "player_name", nullable = false, unique = true)
	private String playerName;
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	@Column(name = "phone", nullable = false, unique = true)
	private String phone;
	@Column(name = "code_name", nullable = false, unique = true)
	private String codeName;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
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