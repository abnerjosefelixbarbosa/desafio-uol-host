package com.org.backendjava.infra.entity;



import java.io.Serializable;

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
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "player_tb")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerDB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(name = "player_name", nullable = false, unique = true)
	private String name;
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	@Column(name = "phone", nullable = false, unique = true)
	private String phone;
	@Column(name = "code_name", nullable = false, unique = true)
	private String codeName;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private GroupTypeDB playerGroup;
}