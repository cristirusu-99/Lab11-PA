package com.compulsory.crudrestapi.repository;

import com.compulsory.crudrestapi.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, String> {

}
