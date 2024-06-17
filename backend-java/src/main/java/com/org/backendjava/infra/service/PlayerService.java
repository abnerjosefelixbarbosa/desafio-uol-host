package com.org.backendjava.infra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backendjava.adapter.PlayerServiceGateway;
import com.org.backendjava.domain.dto.RegisterDto;
import com.org.backendjava.domain.dto.RegisterView;
import com.org.backendjava.infra.entity.Player;
import com.org.backendjava.infra.mapper.PlayerMapper;
import com.org.backendjava.infra.repository.PlayerRepository;

@Service
public class PlayerService implements PlayerServiceGateway {
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private GroupService groupService;

	@Override
	public RegisterView registerPlayer(RegisterDto dto) {
		Player player = PlayerMapper.toPlayer(dto);
		
		String codeName = groupService.getCodenameByGroupType(player.getPlayerGroup());
		
		System.out.println(codeName);
		
		//player = playerRepository.save(player);
		RegisterView view = PlayerMapper.toRegisterView(player);
		return view;
	}
}
