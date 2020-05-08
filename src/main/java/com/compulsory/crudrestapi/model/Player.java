package com.compulsory.crudrestapi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection = "Player")
public class Player {
    @Id
    private Integer id;
    private String name;
}
