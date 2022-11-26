package com.hackathon.hackathon.controller.test;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class TestObjectDto {
    private String name;
    private int number;
    private List<String> list;
}
