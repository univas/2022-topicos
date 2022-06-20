package br.edu.univas.si7.aula01;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.univas.si7.aula01.model.Message;
import br.edu.univas.si7.aula01.model.User;
import br.edu.univas.si7.aula01.model.support.MessagePriority;
import br.edu.univas.si7.aula01.repository.MessageMongoRepository;
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
	
	@Autowired
	private MessageMongoRepository msgMongoRepo;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User("User 001");
		User u2 = new User("User 002");
		User u3 = new User("User 003");
		
		userRepo.deleteAll();
		userRepo.saveAll(Arrays.asList(u1, u2, u3));
		
		Message m1 = new Message("1", "Primeira mensagem", MessagePriority.MEDIUN);
		Message m2 = new Message("2", "Segunda mensagem", MessagePriority.HIGH);
		
		m1.setUser(u2);
		m2.setUser(u3);
		
		msgMongoRepo.deleteAll();
		msgMongoRepo.saveAll(Arrays.asList(m1, m2));

//		msgRepo.save(msg);
//		msgRepo.save(m2);
	}
}
