package com.monsterTutor;

import com.ioHelper.DisplayAscii;
import com.ioHelper.GetUserInput;
import com.question.Question;
import com.question.QuestionBank;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MonsterTutor {
    String difficulty;
    String topic;
    Student student;
    List<Question> questions;
    GetUserInput userInput = new GetUserInput();

    public MonsterTutor(Student student) {
        this.student = student;

        populateQuestions();
    }

    public void tutor() {
        greeting();
        // TODO - make display of options
        System.out.println("(1) Play a random game");
        System.out.println("(2) Play a game with specified topic");
        System.out.println("(3) Exit to main menu");

        int input = GetUserInput.getUserInteger();

        if (input == 1) {
            playRandomGame();
        } else if (input == 2) {
            playGame();
        } else if (input == 3) {
            System.out.println("bye");
        }
    }
    private void playRandomGame() {
        // TODO: 6/24/2020 do game logic
            // Game logic
            System.out.println("How many questions do you want?");
            int howManyQs = GetUserInput.getUserInteger();
            List<Question> randomQuestions = questions.stream()
                    .limit(howManyQs)
                    .collect(Collectors.toList());
            //randomQuestions.forEach(System.out::println);
            playGameHelper(randomQuestions);
    }

    private void playGame() {
        // Game logic
        System.out.println("What topic would you like to be quizzed on?");
        System.out.println("Topics: [math,literature,java]");
        String topic = GetUserInput.getUserString();
        List<Question> specificQuestions = questions.stream()
                .filter(question -> question.getTopic().equals(topic))
                .collect(Collectors.toList());
        //randomQuestions.forEach(System.out::println);
        playGameHelper(specificQuestions);
    }

    private void playGameHelper(List<Question> questions) {
        //randomQuestions.forEach(System.out::println);
        for (Question q : questions) {
            askQuestion(q);
            if (!student.isInDungeon()) {
                continue;
            } else {
                System.out.println("You lose");
                DisplayAscii.displayDungeon();
                break;
            }
        }
        // call youWin Function
        if (!student.isInDungeon()) {
            System.out.println("winner winner chicken dinner");
            DisplayAscii.displayWin();
        }
    }
    private void greeting() {
        DisplayAscii.clearConsole();
        System.out.println("Hello I am your Monster Tutor");
        DisplayAscii.displayMonsterTutor();
        System.out.println("Hit Enter when you are ready to begin");
        String input = GetUserInput.getUserString();
        if (input.equals("")) {
            DisplayAscii.clearConsole();
        }
    }

    private void askQuestion(Question q) {
        DisplayAscii.clearConsole();
        System.out.println("Here is a " + q.getDifficulty() + " question about "+q.getTopic());
        System.out.println(q.getQuestion()+"\n");
        q.getAnswersOptions().forEach(System.out::println);
        System.out.println("\nWhich answer is correct? [a,b,c,d]");
        String answer = GetUserInput.getUserString();
        if (answer.equals(q.getAnswer())) {
            reward();
            System.out.println("Press Enter for next Question");
            String enter = GetUserInput.getUserString();
        } else {
            punish();
            if (!student.isInDungeon()) {
                System.out.println("Press Enter for next Question");
            }
            String enter = GetUserInput.getUserString();
        }

    }

    public void punish() {
        //DisplayAscii.displayMonsterTutor();
        student.loseChance();
        if (student.getChances() > 1) {
            System.out.println("Wrong answer, watch out you only have "
                    + student.getChances() + " chances left");
        } else if (student.getChances() == 1) {
            System.out.println("Wrong answer, watch out you only have "
                    + student.getChances() + " chance left");
        } else {
            System.out.println("Off to the dungeon you go!!");
        }
    }

    public void praise() {
        System.out.println("You live to see another round");
        student.addChance();
    }

    public void reward() {
        System.out.println("Correct");
    }

    // Getter/Setter
    public void populateQuestions() {
        this.questions = QuestionBank.getQuestionData();
        //Collections.shuffle(this.questions);
    }
}
