package com.org.backendjava.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backendjava.adapter.PlayerServiceGateway;
import com.org.backendjava.application.interfaces.IPlayerService;
import com.org.backendjava.domain.dto.RegisterDto;
import com.org.backendjava.domain.dto.RegisterView;

@Service
public class PlayerServiceImp implements IPlayerService {
	@Autowired
	private PlayerServiceGateway playerServiceGateway;

	@Override
	public RegisterView registerPlayer(RegisterDto dto) {
		return playerServiceGateway.registerPlayer(dto);
	}
}