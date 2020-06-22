package com.monsterTutor;

import com.question.QuestionBank;

import java.util.Scanner;

public class MonsterAcademy {
    MonsterTutor monsterTutor;

    public MonsterAcademy(String difficulty, String topic, Student student) {
        initMonsterTutor(difficulty,topic,student);
    }


    public void initMonsterTutor(String difficulty, String topic, Student student) {
        monsterTutor = new MonsterTutor(difficulty,topic,student);
    }

    public void startTutorSession() {
        System.out.println("Would you like to begin your tutoring session? [yes/no]");
        Scanner readin = new Scanner(System.in);
        String askQuestion = readin.nextLine();
        if (askQuestion.equals("yes")) {
            monsterTutor.getQuestion();
        }

    }

    public MonsterTutor getMonsterTutor() {
        return monsterTutor;
    }
}
