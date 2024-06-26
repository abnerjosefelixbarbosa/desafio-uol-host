package com.org.backendjava.domain.dto;

import com.org.backendjava.domain.enums.GroupTypeDomain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {
	@NotNull(message = "not should be null")
	@NotEmpty (message = "not should be empty")
	private String name;
	@NotEmpty(message = "not should be empty")
	@NotNull(message = "not should be null")
	@Email(message = "not should be invalid")
	private String email;
	@NotNull(message = "not should be null")
	@NotEmpty(message = "not should be empty")
	private String phone;
	@NotNull(message = "not should be null")
	private GroupTypeDomain type;
}