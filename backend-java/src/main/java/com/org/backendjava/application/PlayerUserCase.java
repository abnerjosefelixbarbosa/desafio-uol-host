package com.org.backendjava.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.org.backendjava.adapter.IPlayerGateway;
import com.org.backendjava.domain.dto.PlayerDto;
import com.org.backendjava.domain.usercase.IPlayerUserCase;

@Component
public class PlayerUserCase implements IPlayerUserCase {
	@Autowired
	private IPlayerGateway playerGateway;

	public PlayerDto registerPlayer(PlayerDto dto) {
		return playerGateway.registerPlayer(dto);
	}

	public PlayerDto getPlayerById(String id) {
		return playerGateway.getPlayerById(id);
	}

	public Page<PlayerDto> listPlayers(Pageable pageable) {
		return playerGateway.listPlayers(pageable);
	}

	public void deletePlayerById(String id) {
		playerGateway.deletePlayerById(id);
	}

	public PlayerDto updatePlayer(String id, PlayerDto dto) {
		return playerGateway.updatePlayer(id, dto);
	}	
}