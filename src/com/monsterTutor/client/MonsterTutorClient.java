package com.monsterTutor.client;

import com.monsterTutor.MonsterAcademy;
import com.monsterTutor.MonsterTutor;
import com.monsterTutor.Student;

import java.io.IOException;

public class MonsterTutorClient {
    public static void main(String[] args) throws IOException {
        MonsterAcademy monsterAcademy = new MonsterAcademy();

        monsterAcademy.run();

 /*       Student s = new Student("danny",false);
        MonsterTutor m = new MonsterTutor(s);
        m.tutor();*/
    }

}
