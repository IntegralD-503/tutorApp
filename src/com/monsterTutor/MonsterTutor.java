package com.monsterTutor;

import com.display.DisplayAscii;
import com.question.Question;
import com.question.QuestionBank;

public class MonsterTutor {
    QuestionBank questionBank;
    String difficulty;
    String topic;
    Student student;

    public MonsterTutor(String difficulty,String topic, Student student) {
        this.difficulty = difficulty;
        this.topic = topic;
        this.student = student;
        this.questionBank = new QuestionBank();
    }


    public void getQuestion() {
        Question question = questionBank.getQuestion(difficulty, topic);
        System.out.println("Which of the following is correct?");
        question.getAnswersOptions().forEach(System.out::println);

    }
    public void punish() {
        DisplayAscii.displayMonsterTutor();
        System.out.println("Wrong answer");
    }

    public void praise() {
        System.out.println("You live to see another round");
    }

    public void reward() {
        System.out.println("Tonight you will have a feast fit for the gods");
    }

}
