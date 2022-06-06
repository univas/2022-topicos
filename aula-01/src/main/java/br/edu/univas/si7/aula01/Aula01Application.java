package br.edu.univas.si7.aula01;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.univas.si7.aula01.model.User;
import br.edu.univas.si7.aula01.repository.UserMongoRepository;

@SpringBootApplication
public class Aula01Application implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(Aula01Application.class, args);
	}

//	@Autowired
//	private MessageRepository msgRepo;
	
	@Autowired
	private UserMongoRepository userRepo;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User("User 001");
		User u2 = new User("User 002");
		User u3 = new User("User 003");
		
		userRepo.deleteAll();
		userRepo.saveAll(Arrays.asList(u1, u2, u3));
		
//		Message msg = new Message(1, "Hello from v4", MessagePriority.MEDIUN);
//		msgRepo.save(msg);
//		Message m2 = new Message(0, "Segunda mensagem", MessagePriority.HIGH);
//		msgRepo.save(m2);
	}
}
