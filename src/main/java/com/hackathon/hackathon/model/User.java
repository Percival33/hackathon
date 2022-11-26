package com.hackathon.hackathon.model;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Builder
@Document(collection = "users")
public record User(
        @Id Long uid,
        String city,
        String date,
        String firstName,
        String lastName,
        Gender gender,
        Map<String, List<String>> userTraits
) { }
