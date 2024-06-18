package com.org.backendjava.domain.interfaces.usercase;

import com.org.backendjava.domain.dto.RegisterPlayerDto;
import com.org.backendjava.domain.dto.RegisterPlayerView;

public interface IRegisterPlayerUserCase {
	RegisterPlayerView registerPlayer(RegisterPlayerDto dto);
}