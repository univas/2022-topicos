package br.edu.univas.si7.aula01.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.univas.si7.aula01.controller.exception.ObjectNotFoundException;
import br.edu.univas.si7.aula01.dto.MessageDTO;
import br.edu.univas.si7.aula01.model.Message;
import br.edu.univas.si7.aula01.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository msgRepo;
	
	public List<MessageDTO> getAllMessages() {
		List<Message> listMSG = msgRepo.findAll();
		
//		List<MessageDTO> listDTO = new ArrayList<MessageDTO>();
//		for (Message msg : listMSG) {
//			MessageDTO dto = new MessageDTO(msg);
//			listDTO.add(dto);
//		}
//		return listDTO;
		
		//outra opção no lugar do loop, usando Stream do Java 8
		return listMSG.stream()
				.map(msg -> new MessageDTO(msg))
				.collect(Collectors.toList());
	}
	
	public MessageDTO getMessageById(@PathVariable Integer id) {
		Optional<Message> obj = msgRepo.findById(id);
		
//		Message msg = obj.orElseThrow(() -> new ObjectNotFoundException("Mensagem não encontrada: " + id));
//		MessageDTO dto = new MessageDTO(msg);
//		return dto;
		
		return obj.map(msg -> new MessageDTO(msg))
				.orElseThrow(() -> new ObjectNotFoundException("Mensagem não encontrada: " + id));
	}
	
	public void createMessage(MessageDTO dto) {
		Message msg = toMessage(dto);
		msgRepo.save(msg);
	}

	private Message toMessage(MessageDTO dto) {
		Message msg = new Message();
		msg.setMessage(dto.getMessage());
		return msg;
	}

	public void updateMessage(MessageDTO dto, Integer id) {
		Optional<Message> opt = msgRepo.findById(id);
		//Fazer outras validações
		
		if(!opt.isPresent()) {
			//erro
			throw new ObjectNotFoundException("Mensagem não encontrada: " + id);
		}
		Message msg = opt.get();
		updateData(dto, msg);
		msgRepo.save(msg);
	}

	private void updateData(MessageDTO dto, Message msg) {
		msg.setMessage(dto.getMessage());
	}
}
