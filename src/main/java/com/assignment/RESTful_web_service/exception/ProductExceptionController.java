package com.assignment.RESTful_web_service.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class ProductExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> handlerNoSuchElementException(NoSuchElementException ex)
	{
	    return new ResponseEntity<Object>("No product found with mentioned id", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyList.class)
	public ResponseEntity<Object> handlerEmptyList(EmptyList ex)
	{
		return new ResponseEntity<Object>("No products found",HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
	    return new ResponseEntity<Object>("Please change method type", HttpStatus.METHOD_NOT_ALLOWED);

	}
	
}
