
package com.ioHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IO_Operations {
    //Gameface
    public static final int LEFT_INDENT = 10;

    public static void welcomeScreen() {
        clearConsole();
        String output = getAsciiArt("banner.txt");
        output += getAsciiArt("minotaur.txt");

        slowPrint(output, output.length());

        System.out.println("      Press Enter to Continue...");
        String enter = getUserString();
    }

    public static void displayStartMenu(String name) {
        clearConsole();

        displayMonsterAcademy();
        String option1 = " ".repeat(11) + "+   1 - Enter TutorMonster Academy";
        String option2 = " ".repeat(11) + "+   2 - List Current Students";
        String option3 = " ".repeat(11) + "+   3 - Exit";
        int padding = option1.length()+5;

        String userWelcome = "Welcome " + name;
        int userWelcomePadding = 32-userWelcome.length()/2;
        System.out.println("\n\n\n");
        System.out.println(" ".repeat(userWelcomePadding) + userWelcome+"\n");
        topBorder(padding+1, LEFT_INDENT);
        System.out.println(option1 + " ".repeat(padding-option1.length()+10)+"+");
        System.out.println(option2 + " ".repeat(padding-option2.length()+10)+"+");
        System.out.println(option3 + " ".repeat(padding-option3.length()+10)+"+");
        bottomBorder(padding+1, LEFT_INDENT);
    }

    public  static void displayMonsterAcademy() {
        String monsterAcademy = getAsciiArt("hauntedCastle.txt");
        slowPrint(monsterAcademy, monsterAcademy.length());
    }
    public static void displayMonsterTutor() {
        System.out.println("\n\n\n\n");
        String monsterTutor = getAsciiArt("cyclops.txt");
        slowPrint(monsterTutor, monsterTutor.length());
    }

    public static void displayDungeon() {
        clearConsole();
        String dungeon = getAsciiArt("dungeon.txt");
        System.out.println("\n\n\n\n\n");
        slowPrint(dungeon, dungeon.length());
        System.out.println("\nPress Enter to return to the main menu");
        getUserString();
    }

    public static void displayWin() {
        clearConsole();
        String victory = getAsciiArt("victory.txt");
        String victoryBanner = getAsciiArt("victoryBanner.txt");
        slowPrint(victory, victory.length());
        slowPrint(victoryBanner, victoryBanner.length());

        System.out.println("\nPress Enter to return to main screen");
        getUserString();
    }


    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else
            {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        }
        catch (final Exception e)
        {
            System.out.println("didn't work");
        }
    }

    public static void topBorder(int count, int leftIndent) {
        System.out.println(" ".repeat(leftIndent)  + "=".repeat(count));
    }

    public static void bottomBorder(int count, int leftIndent) {
        System.out.println(" ".repeat(leftIndent) + "=".repeat(count));
    }

    public static int getUserInteger() {
        Scanner readin = new Scanner(System.in);
        int input = Integer.valueOf(readin.nextLine());
        return input;
    }

    public static String getUserString() {
        Scanner readin = new Scanner(System.in);
        String input = readin.nextLine();
        return input;
    }

    private static String getAsciiArt(String filename) {
        try {
            return Files.lines(Path.of("data", filename))
                    .collect(Collectors.joining("\n"));
        } catch (IOException e) {
            return "getAsciiArt() failed to retrieve String";
        }
    }

    private static void slowPrint(String output, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(output.charAt(i));
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Failed to start new thread");
            }
        }
    }
}
