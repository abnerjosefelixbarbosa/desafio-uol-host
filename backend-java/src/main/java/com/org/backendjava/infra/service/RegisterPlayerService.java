package com.org.backendjava.infra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backendjava.adapter.IRegisterPlayerGateway;
import com.org.backendjava.domain.dto.RegisterPlayerDto;
import com.org.backendjava.domain.dto.RegisterPlayerView;
import com.org.backendjava.infra.entity.PlayerDB;
import com.org.backendjava.infra.interfaces.repository.PlayerRepository;

@Service
public class RegisterPlayerService implements IRegisterPlayerGateway {
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private CodenameService codenameService;

	public RegisterPlayerView registerPlayer(RegisterPlayerDto dto) {
		PlayerDB playerDB = new PlayerDB(dto);
		
		return null;
	}
}
