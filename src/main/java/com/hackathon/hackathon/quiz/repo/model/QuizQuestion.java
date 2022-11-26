package com.hackathon.hackathon.quiz.repo.model;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@Document(collection = "quizQuestions")
public record QuizQuestion(
        String question,
        List<String> answers
) { }
