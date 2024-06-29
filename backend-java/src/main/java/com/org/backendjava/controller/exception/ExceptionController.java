package com.org.backendjava.controller.exception;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.org.backendjava.domain.exception.ExceptionDetails;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionController {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ExceptionDetails> handleEntityNotFoundException(EntityNotFoundException e, HttpServletRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(Instant.now(), 404, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(404).body(exceptionDetails);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionDetails> handleRuntimeException(RuntimeException e, HttpServletRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(Instant.now(), 400, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(400).body(exceptionDetails);
	}
}