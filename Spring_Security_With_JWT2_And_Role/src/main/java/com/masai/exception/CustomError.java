package com.masai.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

/*
 * HERE WE CREATED OUR OWN CUSTOME EXCEPTION OR ERROR IN SIMPLE BODY OF OUR
 * ERROR
 */
public class CustomError {

	private LocalDateTime time;
	private String message;
	private String details;

}
