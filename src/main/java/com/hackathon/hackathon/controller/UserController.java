package com.hackathon.hackathon.controller;

import com.hackathon.hackathon.model.Gender;
import com.hackathon.hackathon.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/generateUid")
    public ResponseEntity<Integer> generateUid() {
        Integer uid = userService.generateUid();

        return ResponseEntity.ok(uid);
    }

    @PostMapping("/updateInfo")
    public ResponseEntity<Void> updateInfo(@RequestHeader Integer uid, @RequestParam String firstName,
                                           @RequestParam String lastName, @RequestParam Gender gender) {
        userService.updatePersonalData(uid, firstName, lastName, gender);

        return ResponseEntity.ok(null);
    }
}
