package com.beer.rank.userservice.service.impl;

import java.util.Base64;
import java.util.Optional;

import com.beer.rank.userservice.model.Token;
import com.beer.rank.userservice.model.User;
import com.beer.rank.userservice.repository.UserRepository;
import com.beer.rank.userservice.service.UserService;

import reactor.core.publisher.Mono;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<Mono<Token>> login(User user) {
        Optional<User> localUser = repository.findById(user.getUsername());

        return localUser
                .filter(u -> u.getPassword().equals(user.getPassword()))
                .map(u -> ResponseEntity
                        .status(HttpStatus.OK)
                        .body(Mono.just(generateToken(u))))
                .orElse(ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .header("X-Reason", "user-invalid")
                        .body(Mono.empty()));
    }

    private Token generateToken(User user) {
        return new Token(Base64.getEncoder()
                .encodeToString(String.format("%s:%s",
                        user.getUsername(),
                        user.getPassword())
                        .getBytes()
                ));
    }

    @Override
    public ResponseEntity<Mono<Token>> create(User user) {
        boolean exists = repository.existsById(user.getUsername());

        if (exists) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(Mono.empty());
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(Mono.just(generateToken(user)));
        }
    }
}
