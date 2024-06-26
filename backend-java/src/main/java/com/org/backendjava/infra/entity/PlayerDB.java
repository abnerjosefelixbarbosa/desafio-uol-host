package com.org.backendjava.infra.entity;



import com.org.backendjava.domain.dto.PlayerDto;
import com.org.backendjava.infra.enums.GroupTypeDB;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "player_tb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDB {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(name = "player_name", nullable = false, unique = true)
	private String playerName;
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	@Column(name = "phone", nullable = false, unique = true)
	private String phone;
	@Column(name = "code_name", nullable = false, unique = true)
	private String codeName;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private GroupTypeDB playerGroup;

	public PlayerDB(PlayerDto dto) {
		this.playerName = dto.getName();
		this.email = dto.getEmail();
		this.phone = dto.getPhone();
		this.playerGroup = GroupTypeDB.valueOf(dto.getType().getType());
	}
}