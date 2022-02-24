package br.edu.univas.si7.aula01.controller.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> handleObjectNotFound(
						ObjectNotFoundException ex, HttpServletRequest req) {
		
		StandardError error = new StandardError(
				ex.getMessage(),
				HttpStatus.NOT_FOUND.value(), 
				new Date());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
