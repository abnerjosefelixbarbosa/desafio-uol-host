package com.org.backendjava.infra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backendjava.adapter.IRegisterPlayerGateway;
import com.org.backendjava.domain.dto.RegisterPlayerDto;
import com.org.backendjava.domain.dto.RegisterPlayerView;
import com.org.backendjava.infra.entity.PlayerDB;
import com.org.backendjava.infra.interfaces.repository.IPlayerRepository;

@Service
public class RegisterPlayerService implements IRegisterPlayerGateway {
	@Autowired
	private IPlayerRepository playerRepository;
	@Autowired
	private CodenameService codenameService;

	public RegisterPlayerView registerPlayer(RegisterPlayerDto dto) {
		PlayerDB playerDB = new PlayerDB(dto);
		String codename = codenameService.getCodenameByGroupType(playerDB.getPlayerGroup());
		playerDB.setCodeName(codename);
		playerDB = playerRepository.save(playerDB);
		RegisterPlayerView registerPlayerView = new RegisterPlayerView(playerDB);
		
		return registerPlayerView;
	}
}
