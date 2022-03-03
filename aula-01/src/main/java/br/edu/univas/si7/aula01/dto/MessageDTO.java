package br.edu.univas.si7.aula01.dto;

import br.edu.univas.si7.aula01.model.Message;

public class MessageDTO {

	private String message;
		
	public MessageDTO(Message msg) {
		this.message = msg.getMessage();
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
