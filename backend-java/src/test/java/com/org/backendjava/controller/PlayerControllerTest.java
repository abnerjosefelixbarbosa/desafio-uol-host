package com.org.backendjava.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.backendjava.domain.dto.PlayerDto;
import com.org.backendjava.domain.dto.PlayerView;
import com.org.backendjava.domain.enums.GroupTypeDomain;
import com.org.backendjava.infra.interfaces.repository.IPlayerRepository;
import com.org.backendjava.infra.service.PlayerService;

@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private PlayerService playerService;
	
	@Test
	public void shouldRegisterPlayerAndReturn201Status() throws Exception {
		PlayerDto dto = new PlayerDto("João", "joao@gmail.com", "(81) 99447-4569", GroupTypeDomain.AVENGERS);
		String json = objectMapper.writeValueAsString(dto);
		
		mockMvc.perform(post("/api/players/register-player").contentType(MediaType.APPLICATION_JSON).content(json))
		.andExpect(MockMvcResultMatchers.status().isCreated())
		.andDo(print());
	}
	
	@Test
	public void shouldListPlayersAndReturn200Status() throws Exception {
		registerPlayerAvenger();
		
		mockMvc.perform(get("/api/players/list-players"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print());
	}
	
	private void registerPlayerAvenger() {
		PlayerDto dto1 = new PlayerDto("Mirela", "mirela@gmail.com", "(81) 99447-4501", GroupTypeDomain.AVENGERS);
		PlayerDto dto2 = new PlayerDto("Gabriel", "gabriel@gmail.com", "(81) 99447-4502", GroupTypeDomain.AVENGERS);
		PlayerDto dto3 = new PlayerDto("Felipe", "felipe@gmail.com", "(81) 99447-4503", GroupTypeDomain.AVENGERS);
		PlayerDto dto4 = new PlayerDto("Dan", "dan@gmail.com", "(81) 99447-4504", GroupTypeDomain.AVENGERS);
		PlayerDto dto5 = new PlayerDto("Barbara", "barbara@gmail.com", "(81) 99447-4505", GroupTypeDomain.AVENGERS);
		PlayerDto dto6 = new PlayerDto("Luiz", "luiz@gmail.com", "(81) 99447-4506", GroupTypeDomain.AVENGERS);
		PlayerDto dto7 = new PlayerDto("Tiago", "tiago@gmail.com", "(81) 99447-4507", GroupTypeDomain.AVENGERS);
		PlayerView view = playerService.registerPlayer(dto1);
		playerService.registerPlayer(dto2);
		playerService.registerPlayer(dto3);
		playerService.registerPlayer(dto4);
		playerService.registerPlayer(dto5);
		playerService.registerPlayer(dto6);
		playerService.registerPlayer(dto7);
	}
}