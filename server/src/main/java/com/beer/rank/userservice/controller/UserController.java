package com.beer.rank.userservice.controller;

import com.beer.rank.userservice.model.Token;
import com.beer.rank.userservice.model.User;
import com.beer.rank.userservice.service.UserService;

import reactor.core.publisher.Mono;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Mono<Token>> login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Mono<Token>> create(@RequestBody User user) {
        return userService.create(user);
    }
}
