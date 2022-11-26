package com.hackathon.hackathon.quiz.repo;

import com.hackathon.hackathon.quiz.repo.model.QuizQuestion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizQuestionRepository extends MongoRepository<QuizQuestion, Long> {
}
