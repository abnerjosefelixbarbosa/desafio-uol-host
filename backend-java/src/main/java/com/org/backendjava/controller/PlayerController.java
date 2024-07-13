package com.org.backendjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.org.backendjava.domain.dto.PlayerDto;
import com.org.backendjava.domain.usercase.IPlayerUserCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins = "http://localhost:4200/")
public class PlayerController {
	@Autowired
	private IPlayerUserCase playerUserCase;

	@PostMapping("/register-player")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<PlayerDto> registerPlayer(@Valid @RequestBody PlayerDto dto) {
		PlayerDto response = playerUserCase.registerPlayer(dto);
		return ResponseEntity.status(201).body(response);
	}
	
	@GetMapping("/get-player-by-id")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<PlayerDto> getPlayerById(@RequestParam String id) {
		PlayerDto response = playerUserCase.getPlayerById(id);
		return ResponseEntity.status(200).body(response);
	}
	
	@GetMapping("/list-players")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Page<PlayerDto>> listPlayers(Pageable pageable) {
		Page<PlayerDto> response = playerUserCase.listPlayers(pageable);
		return ResponseEntity.status(200).body(response);
	}
	
	@DeleteMapping("/delete-player-by-id")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deletePlayerById(@RequestParam String id) {
		playerUserCase.deletePlayerById(id);
		return ResponseEntity.status(204).body(null);
	}
	
	@PutMapping("/update-player")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<PlayerDto> updatePlayer(@RequestParam String id, @Valid @RequestBody PlayerDto dto) {
		PlayerDto response = playerUserCase.updatePlayer(id, dto);
		return ResponseEntity.status(200).body(response);
	}
}