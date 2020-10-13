package org.jio.krishi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.jio.krishi.pojo.RequestResponsePojo;
import org.jio.krishi.validation.FatalValidationException;
import org.jio.krishi.validation.ValidationFatalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
@RestController
public class CustomizedResponseExceptionHandler {
	
	
	@ExceptionHandler(ValidationFatalException.class)
	public final ResponseEntity<List<RequestResponsePojo>> NotFoundException(ValidationFatalException ex,WebRequest request)
	{
		List<RequestResponsePojo> listOfRequest=new ArrayList<RequestResponsePojo>();
		RequestResponsePojo requestResponsePojo=new RequestResponsePojo();
		requestResponsePojo.setErrorCode(HttpStatus.BAD_REQUEST.toString());
		requestResponsePojo.setErrorMessage(ex.getMessage());
		requestResponsePojo.setErrorDetails(ex.getDetails());
		listOfRequest.add(requestResponsePojo);
		return new ResponseEntity<List<RequestResponsePojo>>(listOfRequest,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(FatalValidationException.class)
	public final ResponseEntity<RequestResponsePojo> HandlerNotFoundException(FatalValidationException ex,WebRequest request)
	{
		
		RequestResponsePojo requestResponsePojo=new RequestResponsePojo();
		requestResponsePojo.setErrorCode(HttpStatus.BAD_REQUEST.toString());
		requestResponsePojo.setErrorMessage(ex.getMessage());
		requestResponsePojo.setErrorDetails(ex.getDetails());
		return new ResponseEntity<RequestResponsePojo>(requestResponsePojo,HttpStatus.BAD_REQUEST);
	}
}
