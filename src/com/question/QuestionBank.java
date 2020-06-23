package com.question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class QuestionBank {

/*
    private static List<Question> questionData = Arrays.asList(
            new Question("easy", "math", "What is 2 + 2?",
                    Arrays.asList("a. 5","b. 4","7", "9"),
                    "b"),

            new Question("hard", "Java", "What is 2 + 2?",
                 Arrays.asList("5","4","7", "9"),
                    "What is 4."),

            new Question("medium", "Science", "What is 2 + 2?",
                    Arrays.asList("5","4","7", "9"),
                    "What is 4."));
*/

    private static List<Question> questionData = readCSV();

    public static List<Question> getQuestions(String difficulty) {
        List<Question> questions = getQuestionData().stream()
                .filter(q -> q.getDifficulty().equals(difficulty))
                //.filter(q -> q.getTopic().equals(topic))
                .collect(Collectors.toList());

        // shuffle questions
        Collections.shuffle(questions);

        return questions;
    }

    public static List<Question> getQuestionData() {
        List<Question> questions = Collections.unmodifiableList(questionData);
        return questions;
    }

    public static List<Question> readCSV() {
        String csvFile = "C:\\IntmJ\\workspace2\\tutorApp\\src\\questions.csv";
        String line = "";
        String cvsSplitBy = ",";
        List<Question> questions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] questionArray = line.split(cvsSplitBy);

                Question question = parseQuestionString(questionArray);

                //System.out.println(question);
                //question.forEach(System.out::println);
                questions.add(question);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(questions);
        return questions;
    }

    private static Question parseQuestionString(String[] rawQuestion) {
        String difficulty = rawQuestion[0];
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
//        for (Question q : questionData) {
//            System.out.println(q);
//        }
        System.out.println(questionData.get(0));
    }

}
