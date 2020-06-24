package com.monsterTutor;

import com.display.DisplayAscii;
import com.question.Question;
import com.question.QuestionBank;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.ToDoubleBiFunction;
import java.util.stream.Collectors;

public class MonsterTutor {
    String difficulty;
    String topic;
    Student student;
    List<Question> questions;

    public MonsterTutor(Student student) {
        this.student = student;

        populateQuestions();
    }

    public void tutor() {
        greeting();
        // TODO - make display of options
        System.out.println("(1) Play a random game");
        System.out.println("(2) Exit to main menu");
        Scanner readin = new Scanner(System.in);
        // 1. PLay a random game
        // 2. Exit
        int input = Integer.valueOf(readin.nextLine());
        if (input == 1) {
            playRandomGame();
        } else if (input == 2) {
            System.out.println("bye");
        }

    }
    private void playRandomGame() {
        // TODO: 6/24/2020 do game logic
        if(!student.isInDungeon()) {
            // Game logic
            List<Question> randomQuestions = questions.stream()
                    .limit(5)
                    .collect(Collectors.toList());
            System.out.println(randomQuestions);
        } else {
            System.out.println("You lose");
            // DisplayAscii.displayDungeon();
        }
    }

    private void greeting() {
        DisplayAscii.clearConsole();
        System.out.println("Hello I am your Monster Tutor");
        DisplayAscii.displayMonsterTutor();
        System.out.println("Hit Enter when you are ready to begin");
        Scanner readin = new Scanner(System.in);
        String input = readin.nextLine();
        if (input.equals("")) {
            DisplayAscii.clearConsole();
        }
    }

    public void askQuestion() {
        Question q = questions.get(0);
        System.out.println("Here is a " + q.getDifficulty() + " question about "+q.getTopic());
        System.out.println(q.getQuestion()+"\n");
        q.getAnswersOptions().forEach(System.out::println);
        System.out.println("\nWhich answer is correct? [a,b,c,d]");
        Scanner readin = new Scanner(System.in);
        String answer = readin.nextLine();
        if (answer.equals(q.getAnswer())) {
            reward();
        } else {
            punish();
        }

    }

    public void punish() {
        DisplayAscii.clearConsole();
        //DisplayAscii.displayMonsterTutor();
        student.loseChance();
        System.out.println("Wrong answer, watch out you only have "
                +student.getChances() + " chances left");
    }

    public void praise() {
        System.out.println("You live to see another round");
        student.addChance();
    }

    public void reward() {
        System.out.println("Tonight you will have a feast fit for the gods");
    }

    // Getter/Setter
    public void populateQuestions() {
        this.questions = QuestionBank.getQuestionData();
        //Collections.shuffle(this.questions);
    }

}
