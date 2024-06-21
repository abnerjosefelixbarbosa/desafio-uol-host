package com.org.backendjava.adapter;

import com.org.backendjava.domain.dto.PlayerDto;
import com.org.backendjava.domain.dto.PlayerView;

public interface IPlayerGateway {
	PlayerView registerPlayer(PlayerDto dto);
}