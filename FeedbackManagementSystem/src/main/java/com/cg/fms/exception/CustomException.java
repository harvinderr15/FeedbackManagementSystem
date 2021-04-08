package com.cg.fms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomException {
 
	@ExceptionHandler(TrainerNotFoundException.class)
	 public ResponseEntity<ErrorMessage> handleProductNotFoundException(TrainerNotFoundException ex)
	 {
		 ErrorMessage errormessage = new ErrorMessage();
		 errormessage.setErrorCode(HttpStatus.NOT_FOUND.value());
		 errormessage.setErrormessage(ex.getMessage());
		 return new ResponseEntity<ErrorMessage>(errormessage, HttpStatus.OK);
	 }
	 @ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleOtherException(Exception ex)
	 {   
		
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setErrormessage(ex.getMessage());
	    return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
	 }
	 
	 @ExceptionHandler(CourseNotFoundException.class)
		public ResponseEntity<ErrorMessage> handleCourseNotFound(CourseNotFoundException ex) {
			ErrorMessage errormessage = new ErrorMessage();
			errormessage.setErrorCode(HttpStatus.NOT_FOUND.value());
			errormessage.setErrormessage(ex.getMessage());
			return new ResponseEntity<ErrorMessage>(errormessage, HttpStatus.OK);
		}
}
