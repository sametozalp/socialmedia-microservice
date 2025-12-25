package com.ozalp.service;

import com.ozalp.dtos.requests.LoginRequest;
import com.ozalp.dtos.requests.RegisterRequest;
import com.ozalp.entities.Auth;
import com.ozalp.repositories.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository repository;

    public Auth register(RegisterRequest request) {
        return repository.save(Auth.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .build());
    }

    public Boolean login(LoginRequest request) {
        return repository.existsByUsernameAndPassword(request.getUsername(), request.getPassword());
    }
}
