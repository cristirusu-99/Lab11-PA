package com.compulsory.crudrestapi.controler;

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
        if (player.getId() != null && playerRepository.existsById(player.getId())) {
            return "A player with this ID already exists. Try modifying it instead.";
        } else {
            playerRepository.insert(player);
            return "Added player with ID: " + player.getId();
        }
    }

    @PutMapping("/modifyPlayer/")
    public String editPlayer(@RequestBody Player player) {
        if (!playerRepository.existsById(player.getId())) {
            return "No player with this ID to be modified. Try adding it instead.";
        } else {
            playerRepository.save(player);
            return "Altered player with ID: " + player.getId();
        }
    }

    @GetMapping("/findPlayers")
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/findPlayers/{id}")
    public Optional<Player> getPlayerByID(@PathVariable String id) {
        return playerRepository.findById(id);
    }

    @DeleteMapping("/deletePlayers/{id}")
    public String deletePlayerByID(@PathVariable String id) {
        if (!playerRepository.existsById(id)) {
            return "No player with this ID to be deleted.";
        } else {
            playerRepository.deleteById(id);
            return "Deleted player with ID:" + id;
        }
    }
}
