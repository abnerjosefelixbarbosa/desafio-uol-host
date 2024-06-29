package com.org.backendjava.domain.dto;

import com.org.backendjava.domain.enums.GroupTypeDomain;
import com.org.backendjava.infra.entity.PlayerDB;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerView {
	private String id;
	private String name;
	private String email;
	private String phone;
	private String codeName;
	private GroupTypeDomain playerGroup;

	public PlayerView(PlayerDB playerDB) {
		this.id = playerDB.getId();
		this.name = playerDB.getName();
		this.email = playerDB.getEmail();
		this.phone = playerDB.getPhone();
		this.codeName = playerDB.getCodeName();
		this.playerGroup = GroupTypeDomain.valueOf(playerDB.getPlayerGroup().getType());
	}
}