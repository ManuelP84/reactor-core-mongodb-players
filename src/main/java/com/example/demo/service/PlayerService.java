package com.example.demo.service;

import com.example.demo.collection.Player;
import com.example.demo.model.PlayerDto;
import com.example.demo.repository.IPlayerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlayerService {

    @Autowired
    private IPlayerRepository repository;

    //@Autowired
    //private ModelMapper modelMapper;

    public Flux<PlayerDto> findAllPlayers(){
        return this
                .repository
                .findAll()
                .map(player -> convertEntityToDto(player));


    }

    public Mono<PlayerDto> findPlayerById(Integer playerId){
        return this
                .repository
                .findById(playerId)
                .map(player -> convertEntityToDto(player));
    }

    public Mono<PlayerDto> savePlayer(PlayerDto playerDto){
        return this
                .repository
                .save(convertDtoToEntity(playerDto))
                .map(player -> convertEntityToDto(player));
    }

    public Mono<PlayerDto> updatePlayer(Integer playerId, PlayerDto playerDto){
        return  this
                .findPlayerById(playerId)
                .flatMap(p -> {
                    playerDto.setId(playerId);
                    return this.savePlayer(playerDto);
                })
                .switchIfEmpty(Mono.empty());
    }

    public Mono<Void> deletePlayer(Integer playerId){
        return this
                .findPlayerById(playerId)
                .flatMap(playerDto -> this.repository.deleteById(playerId))
                .switchIfEmpty(Mono.empty());
    }

    public Mono<Void> deleteAllPlayer(){
        return this
                .repository.deleteAll()
                .switchIfEmpty(Mono.empty());
    }

    //Converters
    public PlayerDto convertEntityToDto(Player player){
        //return modelMapper.map(player, PlayerDto.class);
        PlayerDto playerDto = new PlayerDto();
        playerDto.setId(player.getId());
        playerDto.setAge(player.getAge());
        playerDto.setClub(player.getClub());
        playerDto.setGames(player.getGames());
        playerDto.setIcon(player.getIcon());
        playerDto.setName(player.getName());
        playerDto.setNational(player.getNational());
        playerDto.setWinners(player.getWinners());
        return playerDto;
    }

    public Player convertDtoToEntity(PlayerDto playerDto){
        //return modelMapper.map(playerDto, Player.class);
        Player player = new Player();
        player.setId(playerDto.getId());
        player.setAge(playerDto.getAge());
        player.setClub(playerDto.getClub());
        player.setGames(playerDto.getGames());
        player.setIcon(playerDto.getIcon());
        player.setName(playerDto.getName());
        player.setNational(playerDto.getNational());
        player.setWinners(playerDto.getWinners());
        return player;
    }
}
