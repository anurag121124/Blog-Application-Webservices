package com.cms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cms.config.AppConstants;
import com.cms.entities.EmailDetails;
import com.cms.payload.ApiResponse;
import com.cms.services.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;

	// Sending a simple Email
	@PostMapping("/sendMail")
	public ResponseEntity<ApiResponse> sendMail(@RequestBody EmailDetails details) {
		String status = emailService.sendSimpleMail(details);
		boolean flag;

		if (status.equals(AppConstants.EMAIL_SUCCESS)) {
			flag = true;
		} else {
			flag = false;
		}

		return new ResponseEntity<ApiResponse>(new ApiResponse(status, flag), HttpStatus.OK);
	}

	// Sending email with attachment
	@PostMapping("/sendMailWithAttachment")
	public ResponseEntity<ApiResponse> sendMailWithAttachment(@RequestBody EmailDetails details) {
		String status = emailService.sendMailWithAttachment(details);
		boolean flag;

		if (status.equals(AppConstants.EMAIL_SUCCESS)) {
			flag = true;
		} else {
			flag = false;
		}

		return new ResponseEntity<ApiResponse>(new ApiResponse(status, flag), HttpStatus.OK);
	}

}
