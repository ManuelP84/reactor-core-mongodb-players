package com.example.demo.repository;

import com.example.demo.collection.Player;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IPlayerRepository extends ReactiveMongoRepository<Player, Integer> {
}
