package com.hackathon.hackathon.controller.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "Hello world!";
    }

    @GetMapping("/testObject")
    public ResponseEntity<TestObjectDto> testObject() {
        var result = TestObjectDto.builder()
                .name("name")
                .number(1)
                .list(List.of("1", "2"))
                .build();

        return ResponseEntity.ok(result);
    }
}
