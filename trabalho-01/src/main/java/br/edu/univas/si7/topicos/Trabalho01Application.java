package br.edu.univas.si7.topicos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.univas.si7.topicos.domain.Address;
import br.edu.univas.si7.topicos.domain.Category;
import br.edu.univas.si7.topicos.domain.Customer;
import br.edu.univas.si7.topicos.domain.enums.CustomerType;
import br.edu.univas.si7.topicos.repositories.AddressRepository;
import br.edu.univas.si7.topicos.repositories.CategoryRepository;
import br.edu.univas.si7.topicos.repositories.CustomerRepository;

@SpringBootApplication
public class Trabalho01Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository catRepo;

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private AddressRepository addressRepo;

	public static void main(String[] args) {
		SpringApplication.run(Trabalho01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category("Categoria 01");
		Category cat2 = new Category("Categoria 02");
		Category cat3 = new Category("Categoria 03");
		Category cat4 = new Category("Categoria 04");
		Category cat5 = new Category("Categoria 05");

		catRepo.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));

		Customer c1 = new Customer("11.111.111-11", "C1", "c1@gmail.com", "1111-1111", CustomerType.NATURAL_PERSON);
		Customer c2 = new Customer("22.222.222-22", "C2", "c2@gmail.com", "2222-2222", CustomerType.LEGAL_PERSON);

		Address a1 = new Address("R1", 1, "111", "B1", "11111", c1, "cidade01", "MG");
		Address a2 = new Address("R2", 2, "222", "B2", "22222", c1, "cidade02", "MG");
		Address a3 = new Address("R3", 3, "333", "B3", "33333", c2, "cidade03", "SP");

		c1.addAddress(a1, a2);
		c2.addAddress(a3);

		customerRepo.saveAll(Arrays.asList(c1, c2));
		addressRepo.saveAll(Arrays.asList(a1, a2, a3));
	}
}
