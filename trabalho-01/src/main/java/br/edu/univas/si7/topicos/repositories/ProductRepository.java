package br.edu.univas.si7.topicos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.univas.si7.topicos.domain.Category;
import br.edu.univas.si7.topicos.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select distinct p from Product p join p.categories cat" 
                 + " where p.name like %:name% and cat in :categories")
    @Transactional(readOnly = true)
    List<Product> search(@Param("name") String productName, 
                         @Param("categories") List<Category> categories);

    //same result as the method search
    @Transactional(readOnly = true)
    List<Product> findDistinctByNameContainingAndCategoriesIn(
        String productName, List<Category> categories);

}
