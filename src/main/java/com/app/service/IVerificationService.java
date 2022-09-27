package com.app.service;

import javax.mail.MessagingException;

import com.app.entities.User;

public interface IVerificationService {

	void sendVerificationMail(String email) throws MessagingException;
	  User verifyEmail(String email);
	
}
