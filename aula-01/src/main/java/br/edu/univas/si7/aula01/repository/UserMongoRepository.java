package br.edu.univas.si7.aula01.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.edu.univas.si7.aula01.model.User;

@Repository
public interface UserMongoRepository extends MongoRepository<User, String> {

}
