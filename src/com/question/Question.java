package com.question;

import java.util.List;

public class Question {
    private String difficulty;
    private String topic;
    private String question;
    List<String> answersOptions;
    private String answer;

    Question(String difficulty, String topic,
             String question, List<String> answerOptions,
             String correctAnswer) {
        this.difficulty = difficulty;
        this.topic = topic;
        this.question = question;
        this.answersOptions = answerOptions;
        this.answer = correctAnswer;
    }

    public String getTopic() {
        return topic;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public List<String> getAnswersOptions() {
        return answersOptions;
    }
}
