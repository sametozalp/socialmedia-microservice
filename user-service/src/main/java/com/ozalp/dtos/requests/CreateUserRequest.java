package com.ozalp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
    Long authId;
    String username;
    String email;
}
