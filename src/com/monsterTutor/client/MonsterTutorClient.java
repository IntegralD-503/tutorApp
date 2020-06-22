package com.monsterTutor.client;

import com.monsterTutor.MonsterAcademy;
import com.monsterTutor.MonsterTutor;
import com.monsterTutor.Student;

public class MonsterTutorClient {
    public static void main(String[] args) {
        Student student1 = new Student();
        //MonsterTutor monsterTutor = new MonsterTutor("easy","Math",student1);
        MonsterAcademy monsterAcademy = new MonsterAcademy("easy","Math",student1);
        MonsterTutor monsterTutor = monsterAcademy.getMonsterTutor();
        //monsterTutor.punish();

        //monsterTutor.getQuestion();
        monsterAcademy.startTutorSession();


    }
}
