package com.org.backendjava.domain.exception;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ExceptionDetails {
	@JsonFormat(pattern = "yyyy-MM-dd HH:ss")
	private Instant instant;
	private Integer status;
	private String details;
	private String path;
	
	public ExceptionDetails() {
	}
	
	public ExceptionDetails(Instant instant, Integer status, String details, String path) {
		this.instant = instant;
		this.status = status;
		this.details = details;
		this.path = path;
	}

	public Instant getDateTime() {
		return instant;
	}

	public void setDateTime(Instant instant) {
		this.instant = instant;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}