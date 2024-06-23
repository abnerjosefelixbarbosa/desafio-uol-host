package com.org.backendjava.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.org.backendjava.adapter.IPlayerGateway;
import com.org.backendjava.domain.dto.PlayerDto;
import com.org.backendjava.domain.dto.PlayerView;
import com.org.backendjava.domain.interfaces.usercase.IPlayerUserCase;

@Component
public class PlayerUserCase implements IPlayerUserCase {
	@Autowired
	private IPlayerGateway playerGateway;

	public PlayerView registerPlayer(PlayerDto dto) {
		return playerGateway.registerPlayer(dto);
	}

	public Page<PlayerView> listPlayers(Pageable pageable) {
		return playerGateway.listPlayers(pageable);
	}

	public void deletePlayerById(String id) {
		playerGateway.deletePlayerById(id);
	}

	public PlayerView updatePlayer(String id, PlayerDto dto) {
		return playerGateway.updatePlayer(id, dto);
	}	
}