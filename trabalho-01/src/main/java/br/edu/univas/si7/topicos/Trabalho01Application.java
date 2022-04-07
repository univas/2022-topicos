package br.edu.univas.si7.topicos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.univas.si7.topicos.domain.Category;
import br.edu.univas.si7.topicos.repositories.CategoryRepository;

@SpringBootApplication
public class Trabalho01Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository catRepo;

	public static void main(String[] args) {
		SpringApplication.run(Trabalho01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category c1 = new Category("Categoria 01");
		Category c2 = new Category("Categoria 02");
		Category c3 = new Category("Categoria 03");
		Category c4 = new Category("Categoria 04");
		Category c5 = new Category("Categoria 05");

		catRepo.saveAll(Arrays.asList(c1, c2, c3, c4, c5));

	}
}
