package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
//it will handel multiple exception globally througout this project
public class CustomerExceptionHandler {
	
	  @ExceptionHandler(value = {CustomerNotFoundException.class}) 
//here we handel our specific excpetion class , if there is multiple class then we can add here by ,              
	public ResponseEntity<Object> HandelCustomerNotFoundException
	                   (CustomerNotFoundException cnfException)
	{
		
		CustomerException customerException = new CustomerException(
				cnfException.getMessage(),
				cnfException.getCause(),
				HttpStatus.NOT_FOUND
				
				
				);
		
		return new ResponseEntity<>(customerException ,HttpStatus.NOT_FOUND);
		
	  }

}
