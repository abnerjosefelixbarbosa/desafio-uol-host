package com.org.backendjava.application.usercase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.backendjava.adapter.IExistsByPlayerNameOrEmailOrPhoneGateway;
import com.org.backendjava.adapter.IRegisterPlayerGateway;
import com.org.backendjava.domain.dto.RegisterPlayerDto;
import com.org.backendjava.domain.dto.RegisterPlayerView;
import com.org.backendjava.domain.interfaces.usercase.IRegisterPlayerUserCase;

@Component
public class RegisterPlayerUserCase implements IRegisterPlayerUserCase {
	@Autowired
	private IRegisterPlayerGateway registerPlayerGateway;
	@Autowired
	private IExistsByPlayerNameOrEmailOrPhoneGateway existsByPlayerNameOrEmailOrPhoneGateway; 

	public RegisterPlayerView registerPlayer(RegisterPlayerDto dto) {
		if (existsByPlayerNameOrEmailOrPhoneGateway.existsByPlayerNameOrEmailOrPhone(dto.getName(), dto.getEmail(), dto.getPhone())) 
			throw new RuntimeException("name or email or phone exists");
		return registerPlayerGateway.registerPlayer(dto);
	}	
}