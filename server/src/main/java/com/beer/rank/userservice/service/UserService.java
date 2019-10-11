package com.beer.rank.userservice.service;

import com.beer.rank.userservice.model.Token;
import com.beer.rank.userservice.model.User;

import reactor.core.publisher.Mono;

import org.springframework.http.ResponseEntity;

public interface UserService {

    public ResponseEntity<Mono<Token>> login(User user);

    public ResponseEntity<Mono<Token>> create(User user);

    //TODO make it real
}
