package com.compulsory.crudrestapi.controler;

import com.compulsory.crudrestapi.model.Game;
import com.compulsory.crudrestapi.model.Player;
import com.compulsory.crudrestapi.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @PostMapping("/addPlayer")
    public String savePlayer(@RequestBody Player player) {
        playerRepository.save(player);
        return "Saved player with ID:" + player.getId();
    }

    @GetMapping("/findPlayers")
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/findPlayers/{id}")
    public Optional<Player> getPlayerByID(@PathVariable String id) {
        return playerRepository.findById(Integer.parseInt(id));
    }

    @DeleteMapping("/deletePlayers/{id}")
    public String deletePlayerByID(@PathVariable String id) {
        if (!playerRepository.existsById(Integer.parseInt(id))) {
            return "No player with this ID to be deleted.";
        } else {
            playerRepository.deleteById(Integer.parseInt(id));
            return "Deleted player with ID:" + id;
        }
    }
}
