package com.slokam.healthcaree.Pojo;

public class ErrorInfo {
private Integer errorId;
private String errorMessage;
private Throwable exception;
public ErrorInfo()
{
	
}
public ErrorInfo(Integer errorId, String errorMessage, Throwable exception) {
	super();
	this.errorId = errorId;
	this.errorMessage = errorMessage;
	this.exception = exception;
}
public Integer getErrorId() {
	return errorId;
}
public void setErrorId(Integer errorId) {
	this.errorId = errorId;
}
public String getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}
public Throwable getException() {
	return exception;
}
public void setException(Throwable exception) {
	this.exception = exception;
}

}
