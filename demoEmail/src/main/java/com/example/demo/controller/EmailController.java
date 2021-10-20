package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmailValuesDTO;
import com.example.demo.service.EmailService;

@RestController
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@GetMapping("/email/send")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<?> sendEmail() {
		emailService.sendEmail();
		return new ResponseEntity("Correo enviado correctamente", HttpStatus.OK);
	}
	
	@PostMapping("/email/send-html")
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<?> sendEmailTemplate(@RequestBody EmailValuesDTO dto) {
		emailService.sendEmailTemplate(dto);
		return new ResponseEntity("Correo con plantilla enviado correctamente", HttpStatus.OK);
	}
}
