package com.cg.vaccination.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionsHandler {
	@ExceptionHandler(VaccineInventoryNotFoundException.class)
	public ResponseEntity<?>employeeNotFound(VaccineInventoryNotFoundException ex,WebRequest request){
		ErrorDetails errorDetails =new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?>otherExcpetionHandler(Exception ex,WebRequest request){
		ErrorDetails errorDetails =new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	}

