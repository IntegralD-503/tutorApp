package com.monsterTutor.client;

import com.display.DisplayAscii;
import com.monsterTutor.MonsterAcademy;
import com.monsterTutor.MonsterTutor;
import com.monsterTutor.Student;

import java.util.Scanner;

public class MonsterTutorClient {
    public static void main(String[] args) {
        Student student1 = new Student();
        //MonsterTutor monsterTutor = new MonsterTutor("easy","Math",student1);
        MonsterAcademy monsterAcademy = new MonsterAcademy("easy","Math",student1);
        //MonsterTutor monsterTutor = monsterAcademy.getMonsterTutor();
        //monsterTutor.punish();

        //monsterTutor.getQuestion();


        Scanner readin = new Scanner(System.in);
        DisplayAscii.displayBanner();
        System.out.println("Welcome to the MonsterTutor Application");
        boolean keepRunning = true;
        while (keepRunning) {
            DisplayAscii.displayStartMenu();
            int userInput = Integer.valueOf(readin.nextLine());
            switch (userInput) {
                case 1:
                    monsterAcademy.startTutorSession();
                    break;
                case 2:
                    break;
                case 3:
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Please Enter a number 1-3");
            }
        }

    }
}
