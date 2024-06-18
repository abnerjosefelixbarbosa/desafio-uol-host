package com.org.backendjava.application.usercase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.backendjava.adapter.IRegisterPlayerGateway;
import com.org.backendjava.domain.dto.RegisterPlayerDto;
import com.org.backendjava.domain.dto.RegisterPlayerView;
import com.org.backendjava.domain.interfaces.usercase.IRegisterPlayerUserCase;

@Component
public class RegisterPlayerUserCase implements IRegisterPlayerUserCase {
	@Autowired
	private IRegisterPlayerGateway registerPlayerGateway;

	public RegisterPlayerView registerPlayer(RegisterPlayerDto dto) {
		return registerPlayerGateway.registerPlayer(dto);
	}	
}