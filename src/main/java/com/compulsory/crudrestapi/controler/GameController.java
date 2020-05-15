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
    public String saveGame(@RequestBody Game game) {
        if (game.getId() != null && gameRepository.existsById(game.getId())) {
            return "A game with this ID already exists. Try modifying it instead.";
        } else {
            gameRepository.insert(game);
            return "Added game with ID: " + game.getId();
        }
    }

    @PutMapping("/modifyGame/")
    public String editGame(@RequestBody Game game) {
        if (!gameRepository.existsById(game.getId())) {
            return "No game with this ID to be modified. Try adding it instead.";
        } else {
            gameRepository.save(game);
            return "Altered game with ID: " + game.getId();
        }
    }

    @GetMapping("/findGames")
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/findGames/{id}")
    public Optional<Game> getGameByID(@PathVariable String id) {
        return gameRepository.findById(id);
    }

    @DeleteMapping("/deleteGames/{id}")
    public String deleteGameByID(@PathVariable String id) {
        if (!gameRepository.existsById(id)) {
            return "No game with this ID to be deleted.";
        } else {
            gameRepository.deleteById(id);
            return "Deleted game with ID:" + id;
        }
    }
}
