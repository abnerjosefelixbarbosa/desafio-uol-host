package com.org.backendjava.domain.dto;

import org.hibernate.validator.constraints.Length;

import com.org.backendjava.domain.enums.GroupTypeDomain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PlayerDto(
		String id,
		@NotNull(message = "not should be null")
		@NotEmpty(message = "not should be empty")
		@Length(max = 100, message = "not should be more than 100 characters")
		String name,
		@NotEmpty(message = "not should be empty")
		@NotNull(message = "not should be null")
		@Email(message = "not should be invalid")
		@Length(max = 50, message = "not should be more than 50 characters")
		String email,
		@NotNull(message = "not should be null")
		@NotEmpty(message = "not should be empty")
		@Length(max = 20, message = "not should be more than 20 characters")
		String phone,
		String codeName,
		@NotNull(message = "not should be null")
		GroupTypeDomain type
) {}