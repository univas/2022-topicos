package br.edu.univas.si7.aula01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univas.si7.aula01.model.Message;
import br.edu.univas.si7.aula01.repository.MessageRepository;

@RestController
@RequestMapping("/messages")
public class MessageController {

	@Autowired
	private MessageRepository msgRepo;
	
	@GetMapping()
	public List<Message> getAllMessages() {
		return msgRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Message getMessageById(@PathVariable Integer id) {
		Optional<Message> obj = msgRepo.findById(id);
		if(obj.isEmpty()) {
			return null;
		}
		return obj.get();
	}
}
