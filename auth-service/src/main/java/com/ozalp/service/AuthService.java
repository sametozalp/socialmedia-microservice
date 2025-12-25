package com.ozalp.service;

import com.ozalp.dtos.requests.CreateUserRequest;
import com.ozalp.dtos.requests.LoginRequest;
import com.ozalp.dtos.requests.RegisterRequest;
import com.ozalp.entities.Auth;
import com.ozalp.managers.UserProfileManager;
import com.ozalp.repositories.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository repository;
    private final UserProfileManager userProfileManager;

    @Transactional
    public Auth register(RegisterRequest request) {
        Auth auth = repository.save(Auth.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .build());

        userProfileManager.createUser(CreateUserRequest.builder()
                .authId(auth.getId())
                .email(auth.getEmail())
                .username(auth.getUsername())
                .build());

        return auth;
    }

    public Boolean login(LoginRequest request) {
        return repository.existsByUsernameAndPassword(request.getUsername(), request.getPassword());
    }
}
