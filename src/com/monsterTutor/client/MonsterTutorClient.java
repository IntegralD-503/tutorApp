package com.monsterTutor.client;

import com.display.DisplayAscii;
import com.monsterTutor.MonsterAcademy;
import com.monsterTutor.MonsterTutor;
import com.monsterTutor.Student;
import com.question.QuestionBank;

import java.io.IOException;
import java.util.Scanner;

public class MonsterTutorClient {
    public static void main(String[] args) throws IOException {
        MonsterAcademy monsterAcademy = new MonsterAcademy();

        monsterAcademy.run();

 /*       Student s = new Student("danny",false);
        MonsterTutor m = new MonsterTutor(s);
        m.tutor();*/
    }
}
