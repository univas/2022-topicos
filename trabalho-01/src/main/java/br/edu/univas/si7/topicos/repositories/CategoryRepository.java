package br.edu.univas.si7.topicos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.univas.si7.topicos.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
