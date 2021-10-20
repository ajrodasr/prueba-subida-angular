package com.example.demo.dto;

public class EmailValuesDTO {
	
	private String mailFrom;
	private String mailTo;
	private String subject;
	private String idUsuario;
	private String token;
	
	public EmailValuesDTO() {}
	
	public EmailValuesDTO(String mailForm, String mailTo, String subject, String idUsusario, String token) {
		this.mailFrom = mailForm;
		this.mailTo = mailTo;
		this.subject = subject;
		this.idUsuario = idUsusario;
		this.token = token;
	}
	
	
	public String getMailFrom() {
		return mailFrom;
	}
	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}
	public String getMailTo() {
		return mailTo;
	}
	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void idUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
