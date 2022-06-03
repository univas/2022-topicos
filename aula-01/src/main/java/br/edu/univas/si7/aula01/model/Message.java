package br.edu.univas.si7.aula01.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import br.edu.univas.si7.aula01.model.support.MessagePriority;

//@Entity
@Document(collection = "Messages")
public class Message {

	//@Id
	@org.springframework.data.annotation.Id
	private String id;
	private String code;
	private String message;
	
	//@Enumerated(EnumType.ORDINAL) //não funciona junto com o MessagePriorityConverter
	private MessagePriority priority;

	public Message() {
	}

	public Message(String code, String message, MessagePriority priority) {
		super();
		this.code = code;
		this.message = message;
		this.priority = priority;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MessagePriority getPriority() {
		return priority;
	}

	public void setPriority(MessagePriority priority) {
		this.priority = priority;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
