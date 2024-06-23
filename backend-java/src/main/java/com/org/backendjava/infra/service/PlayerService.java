package com.org.backendjava.infra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.org.backendjava.adapter.ICodeNameGateway;
import com.org.backendjava.adapter.IPlayerGateway;
import com.org.backendjava.domain.dto.PlayerDto;
import com.org.backendjava.domain.dto.PlayerView;
import com.org.backendjava.infra.entity.PlayerDB;
import com.org.backendjava.infra.interfaces.repository.IPlayerRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PlayerService implements IPlayerGateway {
	@Autowired
	private IPlayerRepository playerRepository;
	@Autowired
	private ICodeNameGateway codeNameGateway;

	public PlayerView registerPlayer(PlayerDto dto) {
		PlayerDB player = new PlayerDB(dto);
		String codename = codeNameGateway.getCodenameByGroupType(player.getPlayerGroup());
		
		boolean existsByPlayerNameOrEmailOrPhone = playerRepository
				.existsByPlayerNameOrEmailOrPhone(player.getPlayerName(), player.getEmail(), player.getPhone());
		
		if (existsByPlayerNameOrEmailOrPhone)
			throw new RuntimeException("name, email or plone exists");
		
		player.setCodeName(codename);
		player = playerRepository.save(player);
		PlayerView view = new PlayerView(player);
		
		return view;
	}

	public Page<PlayerView> listPlayers(Pageable pageable) {
		return playerRepository
				.findAll(pageable)
				.map(PlayerView::new);
	}

	public void deletePlayerById(String id) {
		playerRepository.deleteById(id);
	}

	public PlayerView updatePlayer(String id, PlayerDto dto) {
		PlayerDB player = playerRepository
				.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("id not found"));
		
		player.setEmail(dto.getEmail());
		player.setPhone(dto.getPhone());
		player.setPlayerName(dto.getName());
		
		player = playerRepository.save(player);
		
		return new PlayerView(player);
	}
}
