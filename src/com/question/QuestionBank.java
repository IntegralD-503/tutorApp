package com.question;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class QuestionBank {

    private static List<Question> questionData = readCSV();

    public static List<Question> getQuestionData() {
        shuffle();
        List<Question> questions = Collections.unmodifiableList(questionData);
        return questions;
    }

    public static List<Question> readCSV() {
//        String csvFile = "C:\\IntmJ\\workspace2\\tutorApp\\data\\questions.csv";
        String csvFile = "data/questions.csv";
//        String line = "";
//        String cvsSplitBy = ",";
        List<Question> questions = new ArrayList<>();

        try {
            Files.lines(Path.of("data", "questions.csv")).forEach(line -> {
                String[] questionArray = line.split(",");
                Question question = parseQuestionString(questionArray);
                questions.add(question);
            });
        } catch (IOException e) {
            System.out.println("not working");
        }
        //System.out.println(questions);
        return questions;
    }

    private static Question parseQuestionString(String[] rawQuestion) {
        DifficultySetting difficulty = DifficultySetting.valueOf(rawQuestion[0].toUpperCase());
        //System.out.println(rawQuestion[0]);
        String topic = rawQuestion[1];
        String questionToAsk = rawQuestion[2];
        List<String> answerOptions = new ArrayList<>();
        answerOptions.add(rawQuestion[3]);
        answerOptions.add(rawQuestion[4]);
        answerOptions.add(rawQuestion[5]);
        answerOptions.add(rawQuestion[6]);


        Question question = new Question(difficulty,topic,questionToAsk,
                answerOptions, rawQuestion[7]);

        return question;
    }

    public static void printQuestions(){
        for (Question q : questionData) {
            System.out.println(q);
        }
    }

    private static void shuffle() {
        Collections.shuffle(questionData);
    }

}
