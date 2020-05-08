package com.compulsory.crudrestapi.controler;

import com.compulsory.crudrestapi.model.Game;
import com.compulsory.crudrestapi.model.Player;
import com.compulsory.crudrestapi.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @PostMapping("/addPlayer")
    public String saveGame(Player player) {
        playerRepository.save(player);
        return "Saved player with ID:" + player.getId();
    }

    @GetMapping("/findPlayers")
    public List<Player> getAllGames() {
        return playerRepository.findAll();
    }

    @GetMapping("/findPlayers/{id}")
    public Optional<Player> getGameByID(@PathVariable String id) {
        return playerRepository.findById(Integer.parseInt(id));
    }

    @DeleteMapping("/deletePlayers/{id}")
    public String deleteGameByID(@PathVariable String id) {
        playerRepository.deleteById(Integer.parseInt(id));
        return "Deleted player with ID:" + id;
    }
}
