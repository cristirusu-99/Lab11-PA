package com.compulsory.crudrestapi.controler;


import com.compulsory.crudrestapi.model.Game;
import com.compulsory.crudrestapi.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @PostMapping("/addGame")
    public String saveGame(Game game) {
        gameRepository.save(game);
        return "Saved game with ID:" + game.getId();
    }

    @GetMapping("/findGames")
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/findGames/{id}")
    public Optional<Game> getGameByID(@PathVariable String id) {
        return gameRepository.findById(Integer.parseInt(id));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteGameByID(@PathVariable String id) {
        gameRepository.deleteById(Integer.parseInt(id));
        return "Deleted game with ID:" + id;
    }
}
