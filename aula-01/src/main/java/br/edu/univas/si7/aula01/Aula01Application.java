package br.edu.univas.si7.aula01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Aula01Application implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(Aula01Application.class, args);
	}

//	@Autowired
//	private MessageRepository msgRepo;

	@Override
	public void run(String... args) throws Exception {
//		Message msg = new Message(1, "Hello from v4", MessagePriority.MEDIUN);
//		msgRepo.save(msg);
//		Message m2 = new Message(0, "Segunda mensagem", MessagePriority.HIGH);
//		msgRepo.save(m2);
	}
}
