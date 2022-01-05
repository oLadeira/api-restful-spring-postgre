package com.lucasladeira.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lucasladeira.services.exceptions.EntityNotFound;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(EntityNotFound.class)
	public ResponseEntity<ErrorBody> entityNotFoundException(EntityNotFound e, HttpServletRequest request){
		ErrorBody err = new ErrorBody();
		err.setTimestamp(Instant.now());
		err.setError("Entity Not Found");
		err.setMessage(e.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setPath(request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
