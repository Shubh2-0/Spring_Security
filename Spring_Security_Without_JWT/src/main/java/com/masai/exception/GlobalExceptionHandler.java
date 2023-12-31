package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	/*
	 * HERE WE CREATE OUR OWN CUSTOME ERROR SO WHEN ANY EEXCEPTION ACCUR SO THAT
	 * EXCEPTION HANDLER HANDLE THAT SITUATION
	 * 
	 */
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<CustomError> customerExceptionHandler(CustomerException e, WebRequest req) {

		CustomError error = new CustomError();
		error.setTime(LocalDateTime.now());
		error.setMessage(e.getMessage());
		error.setDetails(req.getDescription(false));

		return new ResponseEntity<CustomError>(error, HttpStatus.BAD_REQUEST);

	}

}
