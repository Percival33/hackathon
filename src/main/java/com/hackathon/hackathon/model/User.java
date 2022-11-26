package com.hackathon.hackathon.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Builder
@Getter
@Setter
public class User {
    private Integer uid;
    private String city;
    private String date;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Map<String, List<String>> userTraits;
}
