package com.org.backendjava.domain.dto;

import com.org.backendjava.domain.enums.GroupTypeDomain;

public record PlayerView(
		String id,
		String name,
		String email,
		String phone,
		String codeName,
		GroupTypeDomain playerGroup
) {}