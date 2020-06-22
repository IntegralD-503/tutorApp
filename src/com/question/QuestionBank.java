package com.question;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class QuestionBank {
    // I am a change
    Collection<Question> questions;

    private List<Question> questionData = Arrays.asList(
            new Question("easy", "Math", "What is 2 + 2",
                    Arrays.asList("What is 5.","What is 4.","What is 7.", "What is 9."),
                    "What is 4."),

            new Question("hard", "Java", "What is 2 + 2",
                 Arrays.asList("What is 5.","What is 4.","What is 7.", "What is 9."),
                    "What is 4."),

            new Question("medium", "Science", "What is 2 + 2",
                    Arrays.asList("What is 5.","What is 4.","What is 7.", "What is 9."),
                    "What is 4."));

    public Question getQuestion(String difficulty, String topic) {
        Question question = questionData.stream()
                .filter(q -> q.getDifficulty().equals(difficulty))
                .filter(q -> q.getTopic().equals(topic))
                .collect(Collectors.toList()).get(0);
        return question;
    }



}
