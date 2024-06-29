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
import com.org.backendjava.domain.dto.PlayerView;
import com.org.backendjava.domain.interfaces.usercase.IPlayerUserCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins = "*")
public class PlayerController {
	@Autowired
	private IPlayerUserCase playerUserCase;

	@PostMapping("/register-player")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<PlayerView> registerPlayer(@Valid @RequestBody PlayerDto dto) {
		PlayerView view = playerUserCase.registerPlayer(dto);
		return ResponseEntity.status(201).body(view);
	}
	
	@GetMapping("/list-players")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Page<PlayerView>> listPlayers(Pageable pageable) {
		Page<PlayerView> views = playerUserCase.listPlayers(pageable);
		return ResponseEntity.status(200).body(views);
	}
	
	@DeleteMapping("/delete-player-by-id")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deletePlayerById(@RequestParam String id) {
		playerUserCase.deletePlayerById(id);
		return ResponseEntity.status(204).body(null);
	}
	
	@PutMapping("/update-player")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<PlayerView> updatePlayer(@RequestParam String id, @Valid @RequestBody PlayerDto dto) {
		PlayerView view = playerUserCase.updatePlayer(id, dto);
		return ResponseEntity.status(200).body(view);
	}
}