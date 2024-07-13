package com.org.backendjava.infra.mapper;

import org.springframework.stereotype.Component;

import com.org.backendjava.domain.dto.PlayerDto;
import com.org.backendjava.domain.enums.GroupTypeDomain;
import com.org.backendjava.infra.entity.PlayerDB;
import com.org.backendjava.infra.enums.GroupTypeDB;

@Component
public class PlayerMapper {
	public PlayerDto toPlayerDto(PlayerDB player) {
		return new PlayerDto(
				player.getId(),
				player.getName(),
				player.getEmail(),
				player.getPhone(),
				player.getCodeName(),
				GroupTypeDomain.valueOf(player.getPlayerGroup().getType())
		);
	}
	
	public PlayerDB toPlayerDB(PlayerDto dto) {
		return PlayerDB
				.builder()
				.name(dto.name())
				.email(dto.email())
				.phone(dto.phone())
				.playerGroup(GroupTypeDB.valueOf(dto.playerGroup().getType().toString()))
				.build();
	}
}
