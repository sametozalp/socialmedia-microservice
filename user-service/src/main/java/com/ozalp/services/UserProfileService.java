package com.ozalp.services;

import com.ozalp.dtos.requests.CreateUserRequest;
import com.ozalp.entities.UserProfile;
import com.ozalp.repositories.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository repository;

    public void createUser(CreateUserRequest request) {
        repository.save(UserProfile.builder()
                .authId(request.getAuthId())
                .username(request.getUsername())
                .email(request.getEmail())
                .build());
    }

    public List<UserProfile> getAll() {
        return repository.findAll();
    }
}
