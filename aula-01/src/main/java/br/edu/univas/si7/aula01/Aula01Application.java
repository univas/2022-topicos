package br.edu.univas.si7.aula01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.univas.si7.aula01.model.Message;
import br.edu.univas.si7.aula01.repository.MessageRepository;

@SpringBootApplication
public class Aula01Application implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(Aula01Application.class, args);
	}

	@Autowired
	private MessageRepository msgRepo;

	@Override
	public void run(String... args) throws Exception {
		Message msg = new Message(1, "Hello from v4");
		msgRepo.save(msg);
	}
}
