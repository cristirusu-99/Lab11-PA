package com.compulsory.crudrestapi.model;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString

@Document(collection = "Game")
public class Game {
    @Id
    @Generated
    private Integer id;
    private List<Player> players;
    private Player winner;
}
