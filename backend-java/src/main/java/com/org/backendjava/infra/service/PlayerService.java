package com.org.backendjava.infra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.org.backendjava.adapter.ICodeNameGateway;
import com.org.backendjava.adapter.IPlayerGateway;
import com.org.backendjava.domain.dto.PlayerDto;
import com.org.backendjava.domain.dto.PlayerView;
import com.org.backendjava.domain.mapper.PlayerMapper;
import com.org.backendjava.infra.entity.PlayerDB;
import com.org.backendjava.infra.interfaces.repository.IPlayerRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PlayerService implements IPlayerGateway {
	@Autowired
	private IPlayerRepository playerRepository;
	@Autowired
	private ICodeNameGateway codeNameGateway;
	@Autowired
	private PlayerMapper playerMapper;

	public PlayerView registerPlayer(PlayerDto dto) {
		PlayerDB player = playerMapper.toPlayerDB(dto);
		String codename = codeNameGateway.getCodenameByGroupType(player.getPlayerGroup());
		
		boolean existsByPlayerNameOrEmailOrPhone = playerRepository
				.existsByNameOrEmailOrPhone(player.getName(), player.getEmail(), player.getPhone());
		
		if (existsByPlayerNameOrEmailOrPhone)
			throw new RuntimeException("name, email or plone exists");
		
		player.setCodeName(codename);
		player = playerRepository.save(player);
		PlayerView view = playerMapper.toPlayerView(player);
		
		return view;
	}

	public Page<PlayerView> listPlayers(Pageable pageable) {
		return playerRepository
				.findAll(pageable)
				.map(playerMapper::toPlayerView);
	}

	public void deletePlayerById(String id) {
		playerRepository.deleteById(id);
	}

	public PlayerView updatePlayer(String id, PlayerDto dto) {
		return playerRepository
				.findById(id)
				.map((val) -> {
					val.setEmail(dto.email());
					val.setPhone(dto.phone());
					val.setName(dto.name());
					return playerMapper.toPlayerView(playerRepository.save(val));
				})
				.orElseThrow(() -> new EntityNotFoundException("id not found"));
	}
}
