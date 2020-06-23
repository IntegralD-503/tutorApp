package com.question;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class QuestionBank {

    private static List<Question> questionData = Arrays.asList(
            new Question("easy", "Math", "What is 2 + 2?",
                    Arrays.asList("a. 5","b. 4","7", "9"),
                    "b"),

            new Question("hard", "Java", "What is 2 + 2?",
                 Arrays.asList("5","4","7", "9"),
                    "What is 4."),

            new Question("medium", "Science", "What is 2 + 2?",
                    Arrays.asList("5","4","7", "9"),
                    "What is 4."));



    public static List<Question> getQuestions(String difficulty, String topic) {
        List<Question> questions = getQuestionData().stream()
                .filter(q -> q.getDifficulty().equals(difficulty))
                .filter(q -> q.getTopic().equals(topic))
                .collect(Collectors.toList());
        // shuffle questions
        Collections.shuffle(questions);
        return questions;
    }

    public static List<Question> getQuestionData() {
        List<Question> questions = Collections.unmodifiableList(questionData);
        return questions;
    }



}
