package com.org.backendjava.infra.mapper;

import com.org.backendjava.domain.dto.RegisterDto;
import com.org.backendjava.domain.dto.RegisterView;
import com.org.backendjava.infra.entity.Player;

public class PlayerMapper {
	public static RegisterView toRegisterView(Player player) {
		RegisterView view = new RegisterView();
		return view;
	}
	
	public static Player toPlayer(RegisterDto dto) {
		Player player = new Player();
		player.setPlayerName(dto.getName());
		player.setEmail(dto.getEmail());
		player.setPhone(dto.getPhone());
		player.setPlayerGroup(dto.getType());
		return player;
	}
}
