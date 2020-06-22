package com.monsterTutor;

import com.display.DisplayAscii;
import com.question.Question;
import com.question.QuestionBank;

import java.util.List;
import java.util.Scanner;

public class MonsterTutor {
    String difficulty;
    String topic;
    Student student;
    List<Question> questions;

    public MonsterTutor(String difficulty,String topic, Student student) {
        this.difficulty = difficulty;
        this.topic = topic;
        this.student = student;
        getQuestions();
    }

    public void tutor() {
        greeting();
        askQuestion();

    }
    private void greeting() {
        DisplayAscii.clearConsole();
        System.out.println("Hello I am your Monster Tutor");
        DisplayAscii.displayMonsterTutor();
        System.out.println("Hit Enter when you are ready to begin");
        Scanner readin = new Scanner(System.in);
        String input = readin.nextLine();
        if (input.equals("")) {
            DisplayAscii.clearConsole();
        }
    }

    private void askQuestion() {
        Question q = questions.get(0);
        System.out.println("Here is a " + q.getDifficulty() + " question about "+q.getTopic());
        System.out.println(q.getQuestion()+"\n");
        q.getAnswersOptions().forEach(System.out::println);
        System.out.println("\nWhich answer is correct? [a,b,c,d]");
        Scanner readin = new Scanner(System.in);
        String answer = readin.nextLine();
        if (answer.equals(q.getAnswer())) {
            reward();
        } else {
            punish();
        }

    }
    public void getQuestions() {
        this.questions = QuestionBank.getQuestions(difficulty, topic);
    }

    public void getAnswer(String answer) {


    public void punish() {
        DisplayAscii.clearConsole();
        //DisplayAscii.displayMonsterTutor();
        System.out.println("Wrong answer");
    }

    public void praise() {
        System.out.println("You live to see another round");
    }

    public void reward() {
        System.out.println("Tonight you will have a feast fit for the gods");
    }

}
