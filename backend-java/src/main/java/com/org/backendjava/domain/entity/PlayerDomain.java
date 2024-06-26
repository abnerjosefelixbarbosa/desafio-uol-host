package com.org.backendjava.domain.entity;



import com.org.backendjava.domain.enums.GroupTypeDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDomain {
	private String id;
	private String playerName;
	private String email;
	private String phone;
	private String codeName;
	private GroupTypeDomain playerGroup;
}