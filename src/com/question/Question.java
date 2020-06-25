package com.question;

import java.util.List;

public class Question {
    private Difficulty difficulty;
    private String topic;
    private String question;
    private List<String> answersOptions;
    private String answer;

    Question(Difficulty difficulty, String topic,
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

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public List<String> getAnswersOptions() {
        return answersOptions;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "difficulty='" + difficulty + '\'' +
                ", topic='" + topic + '\'' +
                ", question='" + question + '\'' +
                ", answersOptions=" + answersOptions +
                ", answer='" + answer + '\'' +
                '}';
    }
}
