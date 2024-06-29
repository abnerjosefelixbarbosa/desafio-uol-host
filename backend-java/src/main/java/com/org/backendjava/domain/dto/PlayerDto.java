package com.org.backendjava.domain.dto;

import com.org.backendjava.domain.enums.GroupTypeDomain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PlayerDto(
		@NotNull(message = "not should be null")
		@NotEmpty(message = "not should be empty")
		String name,
		@NotEmpty(message = "not should be empty")
		@NotNull(message = "not should be null")
		@Email(message = "not should be invalid")
		 String email,
		@NotNull(message = "not should be null")
		@NotEmpty(message = "not should be empty")
		String phone,
		@NotNull(message = "not should be null")
		GroupTypeDomain type
) {}