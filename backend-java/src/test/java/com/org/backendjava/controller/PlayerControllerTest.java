package com.org.backendjava.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.backendjava.domain.dto.PlayerDto;
import com.org.backendjava.domain.enums.GroupTypeDomain;
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
	private PlayerDto playerDto = null;
	
	@Test
	public void shouldRegisterPlayerAndReturn201Status() throws Exception {
		PlayerDto dto = new PlayerDto(null, "João", "joao@gmail.com", "(81) 99447-4569", null, GroupTypeDomain.AVENGERS);
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
	
	@Test
	public void shouldDeletePlayerByIdAndReturn204Status() throws Exception {
		registerPlayerAvenger();
		
		mockMvc.perform(delete("/api/players/delete-player-by-id?id=" + getPlayerView().id()))
		.andExpect(MockMvcResultMatchers.status().isNoContent())
		.andDo(print());
	}
	
	@Test
	public void shouldUpdatePlayerByIdAndReturn200Status() throws Exception {
		registerPlayerAvenger();
		
		PlayerDto dto = new PlayerDto(null, "João", "joao@gmail.com", "(81) 99447-4569", null, GroupTypeDomain.AVENGERS);
		String json = objectMapper.writeValueAsString(dto);
		
		mockMvc.perform(put("/api/players/update-player?id=" + getPlayerView().id()).contentType(MediaType.APPLICATION_JSON).content(json))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print());
	}
	
	public void registerPlayerAvenger() {
		PlayerDto dto1 = new PlayerDto(null, "Mirela", "mirela@gmail.com", "(81) 99447-4501", null, GroupTypeDomain.AVENGERS);
		PlayerDto dto2 = new PlayerDto(null, "Gabriel", "gabriel@gmail.com", "(81) 99447-4502", null, GroupTypeDomain.AVENGERS);
		PlayerDto dto3 = new PlayerDto(null, "Felipe", "felipe@gmail.com", "(81) 99447-4503", null, GroupTypeDomain.AVENGERS);
		PlayerDto dto4 = new PlayerDto(null, "Dan", "dan@gmail.com", "(81) 99447-4504", null, GroupTypeDomain.AVENGERS);
		PlayerDto dto5 = new PlayerDto(null, "Barbara", "barbara@gmail.com", "(81) 99447-4505", null, GroupTypeDomain.AVENGERS);
		PlayerDto dto6 = new PlayerDto(null, "Luiz", "luiz@gmail.com", "(81) 99447-4506", null, GroupTypeDomain.AVENGERS);
		PlayerDto dto7 = new PlayerDto(null, "Tiago", "tiago@gmail.com", "(81) 99447-4507", null, GroupTypeDomain.AVENGERS);
		PlayerDto response = playerService.registerPlayer(dto1);
		playerService.registerPlayer(dto2);
		playerService.registerPlayer(dto3);
		playerService.registerPlayer(dto4);
		playerService.registerPlayer(dto5);
		playerService.registerPlayer(dto6);
		playerService.registerPlayer(dto7);
		
		setPlayerDto(response);
	}
	
	public void setPlayerDto(PlayerDto dto) {
		this.playerDto = dto;
	}
	
	public PlayerDto getPlayerView() {
		return playerDto;
	}
}