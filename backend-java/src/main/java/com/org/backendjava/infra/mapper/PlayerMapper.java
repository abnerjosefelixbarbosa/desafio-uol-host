package com.org.backendjava.domain.mapper;

import org.springframework.stereotype.Component;

import com.org.backendjava.domain.dto.PlayerDto;
import com.org.backendjava.domain.dto.PlayerView;
import com.org.backendjava.domain.enums.GroupTypeDomain;
import com.org.backendjava.infra.entity.PlayerDB;
import com.org.backendjava.infra.enums.GroupTypeDB;

@Component
public class PlayerMapper {
	public PlayerView toPlayerView(PlayerDB playerDB) {
		return new PlayerView(playerDB.getId(),playerDB.getName(),playerDB.getEmail(),playerDB.getPhone(),playerDB.getCodeName(),
				GroupTypeDomain.valueOf(playerDB.getPlayerGroup().getType()));
	}
	
	public PlayerDB toPlayerDB(PlayerDto dto) {
		PlayerDB playerDB = PlayerDB
				.builder()
				.name(dto.name())
				.email(dto.email())
				.phone(dto.phone())
				.playerGroup(GroupTypeDB.valueOf(dto.type().getType().toString()))
				.build();
		return playerDB;
	}
}
