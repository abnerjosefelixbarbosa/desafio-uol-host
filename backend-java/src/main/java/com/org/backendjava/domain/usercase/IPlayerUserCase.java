package com.org.backendjava.domain.usercase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.org.backendjava.domain.dto.PlayerDto;

public interface IPlayerUserCase {
	PlayerDto registerPlayer(PlayerDto dto);
	PlayerDto getPlayerById(String id);
	Page<PlayerDto> listPlayers(Pageable pageable);
	void deletePlayerById(String id);
	PlayerDto updatePlayer(String id, PlayerDto dto);
}