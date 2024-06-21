package com.org.backendjava.infra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backendjava.adapter.ICodeNameGateway;
import com.org.backendjava.adapter.IPlayerGateway;
import com.org.backendjava.domain.dto.PlayerDto;
import com.org.backendjava.domain.dto.PlayerView;
import com.org.backendjava.infra.entity.PlayerDB;
import com.org.backendjava.infra.interfaces.repository.IPlayerRepository;

@Service
public class PlayerService implements IPlayerGateway {
	@Autowired
	private IPlayerRepository playerRepository;
	@Autowired
	private ICodeNameGateway codeNameGateway;

	public PlayerView registerPlayer(PlayerDto dto) {
		PlayerDB playerDB = new PlayerDB(dto);
		String codename = codeNameGateway.getCodenameByGroupType(playerDB.getPlayerGroup());
		
		boolean existsByPlayerNameOrEmailOrPhone = playerRepository
				.existsByPlayerNameOrEmailOrPhone(playerDB.getPlayerName(), playerDB.getEmail(), playerDB.getPhone());
		
		if (existsByPlayerNameOrEmailOrPhone)
			throw new RuntimeException("name, email or plone exists");
		
		playerDB.setCodeName(codename);
		playerDB = playerRepository.save(playerDB);
		PlayerView registerPlayerView = new PlayerView(playerDB);
		
		return registerPlayerView;
	}
}
