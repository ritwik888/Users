package com.demo.api.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.demo.api.payload.ApiResponse;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value= {UserException.class})
	public ResponseEntity<UserException> handleNullPointerExceptionException(UserException ex, WebRequest request){
		String errorMessage = ex.getMessage();
		UserException ue = new UserException();
		ue.setMessage(errorMessage);
		ue.setTime(new Date());
		return new ResponseEntity<>(ue, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value= {NullPointerException.class})
	public ResponseEntity<UserException> handleNullPointerExceptionException(NullPointerException ex, WebRequest request){
		String errorMessage = ex.getLocalizedMessage();
		if(errorMessage == null) {
			errorMessage = ex.toString();
		}
		UserException ue = new UserException();
		ue.setMessage(errorMessage);
		ue.setTime(new Date());
		return new ResponseEntity<>(ue, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value= {ResourceNotFoundException.class})
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException re, WebRequest request){
		ApiResponse response = new ApiResponse("FAILED",re.getMessage());
		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
	}
	

}
