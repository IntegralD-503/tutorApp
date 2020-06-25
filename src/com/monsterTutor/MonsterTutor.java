package com.monsterTutor;

import com.ioHelper.IO_Operations;
import com.question.Question;
import com.question.QuestionBank;

import java.util.List;
import java.util.stream.Collectors;

public class MonsterTutor {
    private String difficulty;
    private String topic;
    private Student student;
    private List<Question> questions;

    public MonsterTutor(Student student) {
        this.student = student;

        populateQuestions();
    }

    public void tutor() {
        greeting();
        System.out.println("(1) Start a randomized tutoring session");
        System.out.println("(2) Start a tutor session with a topic of your choice");
        System.out.println("(3) Exit to main menu");

        int input = IO_Operations.getUserInteger();

        if (input == 1) {
            playRandomGame();
        } else if (input == 2) {
            playGame();
        } else if (input == 3) {
            // falls through
        }
    }
    private void playRandomGame() {
            // Game logic
            System.out.println("How many questions do you want?");
            int howManyQs = IO_Operations.getUserInteger();
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
        String topic = IO_Operations.getUserString();
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
                //System.out.println("You lose");
                IO_Operations.displayDungeon();
                break;
            }
        }
        // call youWin Function
        if (!student.isInDungeon()) {
            //System.out.println("winner winner chicken dinner");
            IO_Operations.displayWin();
        }
    }
    private void greeting() {
        IO_Operations.clearConsole();
        IO_Operations.displayMonsterTutor();
        System.out.println("Hello I am your Monster Tutor");
        System.out.println("What you you like to do?");
    }

    private void askQuestion(Question q) {
        IO_Operations.clearConsole();
        System.out.println("\n\n\n\n");
        System.out.println("Here is a " + q.getDifficulty() + " question about "+q.getTopic());
        System.out.println(q.getQuestion()+"\n");
        q.getAnswersOptions().forEach(System.out::println);
        System.out.println("\nWhich answer is correct? [a,b,c,d]");
        String answer = IO_Operations.getUserString();
        if (answer.equals(q.getAnswer())) {
            reward();
            System.out.println("Press Enter for next Question");
            String enter = IO_Operations.getUserString();
        } else {
            punish();
            if (!student.isInDungeon()) {
                System.out.println("Press Enter for next Question");
            }
            String enter = IO_Operations.getUserString();
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
