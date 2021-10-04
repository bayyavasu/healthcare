package com.slokam.healthcaree;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.slokam.healthcaree.Pojo.ErrorInfo;
import com.slokam.healthcaree.exception.HealthCareException;

@RestControllerAdvice
public class HealthcareExceptionHandler {
	@ExceptionHandler(Exception.class)
public ResponseEntity<ErrorInfo> handleException(Exception e)
{
		ErrorInfo errorinfo=new ErrorInfo();
		errorinfo.setErrorId(1234);
		errorinfo.setErrorMessage("Application went wrong");
		errorinfo.setException(e);
		return new ResponseEntity<ErrorInfo>(errorinfo,HttpStatus.INTERNAL_SERVER_ERROR);
}
	 @ExceptionHandler(HealthCareException.class) 
	 public ResponseEntity<ErrorInfo> handleHealthCareException( HealthCareException e){
		 ErrorInfo errorinfo = new ErrorInfo();
		 errorinfo.setErrorId(e.getErrorCode());
		 errorinfo.setErrorMessage(e.getMessage());
		 errorinfo.setException(e);
		 return new ResponseEntity<ErrorInfo>(errorinfo,HttpStatus.INTERNAL_SERVER_ERROR);
	 }
}
