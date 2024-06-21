package com.org.backendjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.backendjava.domain.dto.PlayerDto;
import com.org.backendjava.domain.dto.PlayerView;
import com.org.backendjava.domain.interfaces.usercase.IPlayerUserCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
	@Autowired
	private IPlayerUserCase playerUserCase;

	@PostMapping("/register-player")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<PlayerView> registerPlayer(@Valid @RequestBody PlayerDto dto) {
		PlayerView view = playerUserCase.registerPlayer(dto);
		return ResponseEntity.status(201).body(view);
	}
}