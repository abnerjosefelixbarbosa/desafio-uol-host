package com.org.backendjava.domain.interfaces.usercase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.org.backendjava.domain.dto.PlayerDto;
import com.org.backendjava.domain.dto.PlayerView;

public interface IPlayerUserCase {
	PlayerView registerPlayer(PlayerDto dto);
	Page<PlayerView> listPlayers(Pageable pageable);
}