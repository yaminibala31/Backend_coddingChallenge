package com.hexaware.Employer_rest_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class PlayerExceptionHandler { 
	
			
			@ExceptionHandler({PlayerNotFoundException.class})
			public ResponseEntity<String>  handlePlayerNotFound(PlayerNotFoundException playNot) {
				
				return new ResponseEntity<String>("player not found",HttpStatus.NOT_FOUND);
			}

}