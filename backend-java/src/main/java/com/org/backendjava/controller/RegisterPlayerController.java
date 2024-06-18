package com.org.backendjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.backendjava.domain.dto.RegisterPlayerDto;
import com.org.backendjava.domain.dto.RegisterPlayerView;
import com.org.backendjava.domain.interfaces.usercase.IRegisterPlayerUserCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/players")
public class RegisterPlayerController {
	@Autowired
	private IRegisterPlayerUserCase registerPlayerUserCase;

	@PostMapping("/register-player")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<RegisterPlayerView> registerPlayer(@Valid @RequestBody RegisterPlayerDto dto) {
		RegisterPlayerView view = registerPlayerUserCase.registerPlayer(dto);
		return ResponseEntity.status(201).body(view);
	}
}