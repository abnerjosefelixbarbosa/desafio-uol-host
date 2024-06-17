package com.org.backendjava.adapter;

import com.org.backendjava.domain.dto.RegisterDto;
import com.org.backendjava.domain.dto.RegisterView;

public interface PlayerServiceGateway {
	RegisterView registerPlayer(RegisterDto dto);
}