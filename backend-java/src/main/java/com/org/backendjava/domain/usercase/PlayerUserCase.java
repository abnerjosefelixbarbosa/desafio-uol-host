package com.org.backendjava.domain.usercase;

import com.org.backendjava.domain.dto.RegisterDto;
import com.org.backendjava.domain.dto.RegisterView;

public interface PlayerUserCase {
	RegisterView registerPlayer(RegisterDto dto);
}