package com.compulsory.crudrestapi.repository;

import com.compulsory.crudrestapi.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameRepository extends MongoRepository<Game, String> {
}
