package br.edu.univas.si7.aula01.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univas.si7.aula01.controller.exception.ObjectNotFoundException;
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
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Mensagem não encontrada: " + id));
		
//		if(obj.isPresent()) {
//			return obj.get();
//		}
//		throw new ObjectNotFoundException("Mensagem não encontrada: " + id);
	}
}
