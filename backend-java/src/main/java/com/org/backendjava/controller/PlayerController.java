package com.org.backendjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.backendjava.adapter.PlayerServiceAdapter;
import com.org.backendjava.domain.dto.RegisterDto;
import com.org.backendjava.domain.dto.RegisterView;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
	@Autowired
	private PlayerServiceAdapter playerService;

	@PostMapping("/register-player")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<RegisterView> registerPlayer(@Valid @RequestBody RegisterDto dto) {
		return ResponseEntity.status(201).body(null);
	}
}