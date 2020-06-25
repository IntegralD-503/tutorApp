package com.monsterTutor;

import com.ioHelper.IO_Operations;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MonsterAcademy {
    private Map<String,Student> studentList = new HashMap<>();
    private Student student;
    private MonsterTutor monsterTutor;

    public MonsterAcademy() {
       getStudentsFromCSV();
    }

    public void run() throws IOException {
        IO_Operations.welcomeScreen();
        selectStudent();

        boolean breakGameLoop = false;
        while (!breakGameLoop) {
            IO_Operations.displayStartMenu(student.getName());
            int status = IO_Operations.getUserInteger();
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
        IO_Operations.clearConsole();
        System.out.println("If you are already listed below, enter your name to" +
                "\ncontinue, else type \"new\" to create and register a new student\n");
        listStudents();
        System.out.println();
        String name = IO_Operations.getUserString();
        if (name.equals("new")) {
            System.out.println("Please enter your name to register yourself as a new student");
            name = IO_Operations.getUserString();
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
        IO_Operations.clearConsole();
        System.out.println("\n\n\n\n");
        listStudents();
        System.out.println("\nhit enter to return to the main screen");
        IO_Operations.getUserString();
    }
}
