package com.org.backendjava.domain.exception;

import java.time.Instant;

public record ExceptionDetails(
		Instant instant,
		Integer status,
		String details,
		String path
) {}