package com.org.backendjava.infra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.org.backendjava.adapter.ICodeNameGateway;
import com.org.backendjava.adapter.IPlayerGateway;
import com.org.backendjava.domain.dto.PlayerDto;
import com.org.backendjava.infra.entity.PlayerDB;
import com.org.backendjava.infra.mapper.PlayerMapper;
import com.org.backendjava.infra.repository.IPlayerRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PlayerService implements IPlayerGateway {
	@Autowired
	private IPlayerRepository playerRepository;
	@Autowired
	private ICodeNameGateway codeNameGateway;
	@Autowired
	private PlayerMapper playerMapper;

	public PlayerDto registerPlayer(PlayerDto dto) {
		boolean existsByPlayerNameOrEmailOrPhone = playerRepository
				.existsByNameOrEmailOrPhone(dto.name(), dto.email(), dto.phone());
		
		if (existsByPlayerNameOrEmailOrPhone) {
			throw new RuntimeException("name, email or plone exists");
		}
		
		PlayerDB player = playerMapper.toPlayerDB(dto);
		String codename = codeNameGateway.getCodenameByGroupType(player.getPlayerGroup());
		
		player.setCodeName(codename);
		player = playerRepository.save(player);
		
		return playerMapper.toPlayerDto(player);
	}

	public Page<PlayerDto> listPlayers(Pageable pageable) {
		return playerRepository
				.findAll(pageable)
				.map(playerMapper::toPlayerDto);
	}

	public void deletePlayerById(String id) {
		playerRepository.deleteById(id);
	}

	public PlayerDto updatePlayer(String id, PlayerDto dto) {
		boolean existsByPlayerNameOrEmailOrPhone = playerRepository
				.existsByNameOrEmailOrPhone(dto.name(), dto.email(), dto.phone());
		
		if (existsByPlayerNameOrEmailOrPhone) {
			throw new RuntimeException("name, email or plone exists");
		}
		
		return playerRepository
				.findById(id)
				.map((val) -> {
					val.setEmail(dto.email());
					val.setPhone(dto.phone());
					val.setName(dto.name());
					
					return playerMapper.toPlayerDto(playerRepository.save(val));
				})
				.orElseThrow(() -> new EntityNotFoundException("id not found"));
	}
}
