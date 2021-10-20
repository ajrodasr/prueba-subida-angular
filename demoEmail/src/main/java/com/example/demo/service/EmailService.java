package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.example.demo.dto.EmailValuesDTO;

@Service
public class EmailService {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@Autowired
	TemplateEngine templateEngine;
	
	@Value("${mail.urlFront}")
	private String urlFront;
	
	public void sendEmail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("er.rodas91@gmail.com");
		message.setTo("antonio.rodasrueda@gmail.com");
		message.setSubject("Email de prueba");
		message.setText("Contenido del email");
		
		javaMailSender.send(message);
	}
	
	public void sendEmailTemplate(EmailValuesDTO dto) {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			Context context = new Context();
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("idUsuario", dto.getIdUsuario());
			model.put("url", urlFront + dto.getToken());
			context.setVariables(model);
			String htmlText = templateEngine.process("email-template", context);
			helper.setFrom(dto.getMailFrom());
			helper.setTo(dto.getMailTo());
			helper.setSubject(dto.getSubject());
			helper.setText(htmlText, true);
			
			javaMailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
