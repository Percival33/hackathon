package com.hackathon.hackathon.controller;

import com.hackathon.hackathon.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/generateUid")
    public ResponseEntity<Long> generateUid() {
        Long uid = userService.generateUid();

        return ResponseEntity.ok(uid);
    }
}
