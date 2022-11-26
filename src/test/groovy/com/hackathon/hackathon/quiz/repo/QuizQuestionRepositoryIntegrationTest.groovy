package com.hackathon.hackathon.quiz.repo

import com.hackathon.hackathon.quiz.repo.model.QuizQuestion
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.spock.Testcontainers
import spock.lang.Shared
import spock.lang.Specification

@DataMongoTest
@Testcontainers
class QuizQuestionRepositoryIntegrationTest extends Specification {

    @Shared
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.3")

    @Autowired
    QuizQuestionRepository quizQuestionRepository

    @DynamicPropertySource
    static mongoProps(DynamicPropertyRegistry registry) {
        mongoDBContainer.start()
        registry.add("spring.data.mongodb.uri", () -> mongoDBContainer.replicaSetUrl)
    }

    def setup() {
        quizQuestionRepository.deleteAll()
    }

    def "should save quiz questions"() {
        given:
        def quizQuestion1 = QuizQuestion.builder()
                .question("What color is this?")
                .answers(List.of("black", "red"))
                .build()
        def quizQuestion2 = QuizQuestion.builder()
                .question("How old is Michael Jackson?")
                .answers(List.of("20", "30"))
                .build()

        when:
        quizQuestionRepository.save(quizQuestion1)
        quizQuestionRepository.save(quizQuestion2)
        def result = quizQuestionRepository.findAll()

        then:
        result.get(0) == quizQuestion1
        result.get(1) == quizQuestion2
    }
}
