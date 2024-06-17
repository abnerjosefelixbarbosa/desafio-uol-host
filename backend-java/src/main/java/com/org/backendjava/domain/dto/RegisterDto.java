package com.org.backendjava.domain.dto;

import com.org.backendjava.domain.enums.GroupType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class RegisterDto {
	@NotNull
	@NotEmpty 
	private String name;
	@NotNull
	@Email
	private String email;
	@NotNull
	@NotEmpty
	private String phone;
	@NotNull
	private GroupType type;
	
	public RegisterDto() {
	}
	
	public RegisterDto(String name, String email, String phone, GroupType type) {
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
	
	public GroupType getType() {
		return type;
	}
	
	public void setType(GroupType type) {
		this.type = type;
	}
}