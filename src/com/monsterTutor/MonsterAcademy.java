package com.monsterTutor;

import com.ioHelper.DisplayAscii;
import com.ioHelper.GetUserInput;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class MonsterAcademy {
    private Map<String,Student> studentList = new HashMap<>();
    private Student student;
    private MonsterTutor monsterTutor;

    public MonsterAcademy() {
       getStudentsFromCSV();
    }

    public void run() throws IOException {
        DisplayAscii.welcomeScreen();
        selectStudent();

        boolean breakGameLoop = false;
        while (!breakGameLoop) {
            int status = displayStartMenu();
            switch (status) {
                case 1:
                    menuScreenOptionOne();
                    break;
                case 2:
                    menuScreenOptionTwo();
                    break;
                case 3:
                    breakGameLoop = true;
            }
        }
    }
    // Instantiate monsterTutor
    public void summonMonsterTutor() {
        monsterTutor = new MonsterTutor(student);
    }

    public void listStudents() {
        this.studentList.forEach( (name,student) -> System.out.println(name));
    }

    public void selectStudent() {
        DisplayAscii.clearConsole();
        System.out.println("If you are already listed below, enter your name to" +
                "\ncontinue, else type \"new\" to create and register a new student\n");
        listStudents();
        System.out.println();
        String name = GetUserInput.getUserString();
        if (name.equals("new")) {
            System.out.println("Please enter your name to register yourself as a new student");
            name = GetUserInput.getUserString();
            createStudent(name);
        } else if (studentList.containsKey(name)) { // else if get pre-existent student
            this.student = studentList.get(name);
        } else {
            System.out.println("Please enter a valid input");
            selectStudent();
        }
    }
    // create a new student and write to students.csv
    public void createStudent(String name)  {
        this.student = new Student(name, false);
        writeStudentHelper(student);
    }
    // helper function that writes new student to csv
    private void writeStudentHelper(Student student) {
        String csvFile = "data/students.csv";
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(csvFile, true));
            output.append(student.getName() + "," + student.isInDungeon() + "\n");
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Read in former students from students.csv into studentList private variable
    private void getStudentsFromCSV() {

        try {
            Files.lines(Path.of("data", "students.csv")).forEach(line -> {
                String[] studentArray = line.split(",");
                Student student = new Student(studentArray[0],Boolean.valueOf(studentArray[1]));
                studentList.put(student.getName(),student);
            });
        } catch (IOException e) {
            System.out.println("Error retrieving students from students.csv");
        }
    }
    public void menuScreenOptionOne() {
        summonMonsterTutor();
        monsterTutor.tutor();
    }
    public void menuScreenOptionTwo() {
        DisplayAscii.clearConsole();
        System.out.println("\n\n\n\n");
        listStudents();
        System.out.println("\nhit enter to return to the main screen");
        GetUserInput.getUserString();
    }
    public int displayStartMenu() {
        DisplayAscii.clearConsole();

        DisplayAscii.displayMonsterAcademy();
        String option1 = " ".repeat(11) + "+   1 - Enter TutorMonster Academy";
        String option2 = " ".repeat(11) + "+   2 - List Current Students";
        String option3 = " ".repeat(11) + "+   3 - Exit";
        int padding = option1.length()+5;

        String userWelcome = "Welcome " + student.getName();
        int userWelcomePadding = 32-userWelcome.length()/2;
        System.out.println("\n\n\n");
        System.out.println(" ".repeat(userWelcomePadding) + userWelcome+"\n");
        DisplayAscii.topBorder(padding+1,DisplayAscii.LEFT_INDENT);
        System.out.println(option1 + " ".repeat(padding-option1.length()+10)+"+");
        System.out.println(option2 + " ".repeat(padding-option2.length()+10)+"+");
        System.out.println(option3 + " ".repeat(padding-option3.length()+10)+"+");
        DisplayAscii.bottomBorder(padding+1,DisplayAscii.LEFT_INDENT);
        int result = GetUserInput.getUserInteger();
        return result;
    }

}
