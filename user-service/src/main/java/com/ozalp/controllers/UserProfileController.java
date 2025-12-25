package com.ozalp.controllers;

import com.ozalp.dtos.requests.CreateUserRequest;
import com.ozalp.services.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/userProfile")
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest request) {
        userProfileService.createUser(request);
        return ResponseEntity.ok(true);
    }

    @PostMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userProfileService.getAll());
    }
}
