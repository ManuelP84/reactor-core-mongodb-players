package com.example.demo.controller;

import com.example.demo.model.PlayerDto;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    //GET
    @RequestMapping("/all")
    private Flux<PlayerDto> getAllPlayers(){
        return this.playerService.findAllPlayers();
    }

    @RequestMapping("/player/{id}")
    private Mono<PlayerDto> getPlayerById(@PathVariable("id") Integer id){
        return this.playerService.findPlayerById(id);
    }

    //POST
    @PostMapping("/save/player")
    private Mono<PlayerDto> savePlayer(@RequestBody PlayerDto playerDto){
        return this.playerService.savePlayer(playerDto);
    }

    //PUT
    @PutMapping("/update/player/{id}")
    private Mono<PlayerDto> updatePlayer(@RequestBody PlayerDto playerDto, @PathVariable("id") Integer id){
        return this.playerService.updatePlayer(id, playerDto);
    }

    //DELETE
    @DeleteMapping("/delete/player/{id}")
    private Mono<Void> deletePlayer(@PathVariable("id") Integer id){
        return this.playerService.deletePlayer(id);
    }

    @DeleteMapping("/delete/all/player/")
    private Mono<Void> deletePlayer(){
        return this.playerService.deleteAllPlayer();
    }
}
