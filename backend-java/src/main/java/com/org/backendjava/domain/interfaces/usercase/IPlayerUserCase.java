package com.org.backendjava.domain.interfaces.usercase;

import com.org.backendjava.domain.dto.PlayerDto;
import com.org.backendjava.domain.dto.PlayerView;

public interface IPlayerUserCase {
	PlayerView registerPlayer(PlayerDto dto);
}