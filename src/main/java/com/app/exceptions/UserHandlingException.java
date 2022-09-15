package com.app.exceptions;

@SuppressWarnings("serial")
public class UserHandlingException extends RuntimeException {
public UserHandlingException(String mesg) {
	super(mesg);
}
}
