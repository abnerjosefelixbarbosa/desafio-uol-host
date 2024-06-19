package com.org.backendjava.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.backendjava.domain.dto.RegisterPlayerDto;
import com.org.backendjava.domain.enums.GroupTypeDomain;

@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void shouldRegisterPlayerAndReturn201Status() throws Exception {
		RegisterPlayerDto dto = new RegisterPlayerDto("João", "joao@gmail.com", "(81) 99447-4569", GroupTypeDomain.AVENGERS);
		String json = objectMapper.writeValueAsString(dto);
		
		mockMvc.perform(post("/api/players/register-player").contentType(MediaType.APPLICATION_JSON).content(json))
		.andExpect(MockMvcResultMatchers.status().isCreated())
		.andDo(print());
	}
}