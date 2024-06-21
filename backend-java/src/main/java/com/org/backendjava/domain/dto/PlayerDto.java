package com.org.backendjava.domain.dto;

import com.org.backendjava.domain.enums.GroupTypeDomain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

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
	
	public PlayerDto() {
	}
	
	public PlayerDto(String name, String email, String phone, GroupTypeDomain type) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.type = type;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public GroupTypeDomain getType() {
		return type;
	}
	
	public void setType(GroupTypeDomain type) {
		this.type = type;
	}
}