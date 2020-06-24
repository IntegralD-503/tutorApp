package com.monsterTutor;

import com.display.DisplayAscii;
import com.question.Question;
import com.question.QuestionBank;

import java.io.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MonsterAcademy {
    List<Student> studentList = new ArrayList<>();
    Student student;
    MonsterTutor monsterTutor;

    public MonsterAcademy() {
       getStudents();
    }

    public void run() throws IOException {
        DisplayAscii.welcomeScreen();
        if (studentList.isEmpty()) {
            createStudent();
        } else {
            this.student = getStudent();
        }
        boolean breakGameLoop = false;
        while (!breakGameLoop) {
            int status = DisplayAscii.displayStartMenu();
            switch (status) {
                case 1:
                    summonMonsterTutor();
                    monsterTutor.tutor();
                    break;
                case 2:
                    break;
                case 3:
                    breakGameLoop = true;

            }
        }

    }

    public void summonMonsterTutor() {
        monsterTutor = new MonsterTutor(student);
    }


/*    public void startTutorSession() {
        System.out.println("Would you like to begin your tutoring session? [yes/no]");
        Scanner readin = new Scanner(System.in);
        String askQuestion = readin.nextLine();
        if (askQuestion.equals("yes")) {
            monsterTutor.tutor();
        }

    }*/

    public void createStudent() throws IOException {
        System.out.println("What is your name?");
        Scanner readin = new Scanner(System.in);
        String name = readin.nextLine();
        this.student = new Student(name, false);
        writeStudent(student);

    }

    public void writeStudent(Student student) throws IOException {
        BufferedWriter output = new BufferedWriter(new FileWriter("C:\\IntmJ\\workspace2\\tutorApp\\data\\students.csv", true));
        output.append(student.getName()+","+student.isInDungeon()+"\n");
        output.close();
    }
    // Getters / Setters
    public void getStudents() {
        String csvFile = "C:\\IntmJ\\workspace2\\tutorApp\\data\\students.csv";
//        String csvFile = "data/questions.csv";
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] studentArray = line.split(",");
                Student student = new Student(studentArray[0],Boolean.valueOf(studentArray[1]));
                studentList.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Student getStudent() {
        System.out.println("What is your name?");
        Scanner readin = new Scanner(System.in);
        String name = readin.nextLine();
        Student student = studentList.stream()
                .filter(s -> s.getName().equals(name))
                .collect(Collectors.toList()).get(0);
        return student;
    }

    public MonsterTutor getMonsterTutor() {
        return monsterTutor;
    }
}
