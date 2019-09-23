package com.beer.rank.userservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class User {
    private String id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;
}
