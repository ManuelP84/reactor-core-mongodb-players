package com.example.demo;

import com.example.demo.collection.Player;
import com.example.demo.model.PlayerDto;
import com.example.demo.service.PlayerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	PlayerService playerService;

	@Test
	void contextLoads() {
		List<Player> players = new ArrayList<>();
		players = CsvUtilFile.getPlayers();
		Flux<Player> fluxPlayers = Flux.fromIterable(players);
		fluxPlayers.map(player -> playerService.savePlayer(playerService.convertEntityToDto(player))).doOnNext(m -> m.block()).subscribe();
	}

	@Test
	@DisplayName("savePlayer")
	void savePlayerTest(){
		PlayerDto playerDto = new PlayerDto();
		playerDto.setId(21);
		playerDto.setName("Juan Manuel");
		playerDto.setClub("Barza");
		playerDto.setWinners(12);
		playerDto.setNational("Col");
		playerDto.setGames(6);
		playerDto.setIcon("jm");
		playerDto.setAge(5);
		Mono<PlayerDto> playerDtoMono = Mono.just(playerDto);

		StepVerifier.create(playerService.savePlayer(playerDto)).expectNext(new PlayerDto()).expectComplete();


	}
}
