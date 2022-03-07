package br.edu.univas.si7.aula01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univas.si7.aula01.dto.MessageDTO;
import br.edu.univas.si7.aula01.service.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageController {

	@Autowired
	private MessageService service;

	@GetMapping()
	public List<MessageDTO> getAllMessages() {
		return service.getAllMessages();
	}

	@GetMapping("/{id}")
	public MessageDTO getMessageById(@PathVariable Integer id) {
		return service.getMessageById(id);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void createMessage(@RequestBody MessageDTO dto) {
		service.createMessage(dto);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateMessage(@RequestBody MessageDTO dto, @PathVariable Integer id) {
		service.updateMessage(dto, id);
	}
	
	//implementar o DELETE
	
}
