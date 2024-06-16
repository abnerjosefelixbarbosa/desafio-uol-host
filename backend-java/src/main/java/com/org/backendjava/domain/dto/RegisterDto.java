package com.org.backendjava.domain.dto;

import com.org.backendjava.enums.GroupType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record RegisterDto(
		@NotNull
		@NotEmpty 
		String name,
		@NotNull
		@Email
		String email,
		@NotNull
		@NotEmpty
		String phone,
		@NotNull
		GroupType type
) {}