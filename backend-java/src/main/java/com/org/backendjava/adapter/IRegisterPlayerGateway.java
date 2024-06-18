package com.org.backendjava.adapter;

import com.org.backendjava.domain.dto.RegisterPlayerDto;
import com.org.backendjava.domain.dto.RegisterPlayerView;

public interface IRegisterPlayerGateway {
	RegisterPlayerView registerPlayer(RegisterPlayerDto dto);
}