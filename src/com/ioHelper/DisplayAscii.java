
package com.ioHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DisplayAscii {
    //Gameface


    public static int displayStartMenu() {
        clearConsole();

        String option1 = "+   1 - Enter TutorMonster Academy";
        String option2 = "+   2 - View Student Statistics";
        String option3 = "+   3 - Exit";
        int padding = option1.length()+5;
        topBorder(padding+1);
        System.out.println(option1 + " ".repeat(padding-option1.length())+"+");
        System.out.println(option2 + " ".repeat(padding-option2.length())+"+");
        System.out.println(option3 + " ".repeat(padding-option3.length())+"+");
        bottomBorder(padding+1);
        int result = GetUserInput.getUserInteger();
        return result;
    }

    public static void welcomeScreen() {
        clearConsole();
        String output = getAsciiArt("banner.txt");
        output += getAsciiArt("minotaur.txt");

        slowPrint(output, output.length());

        System.out.println("      Press Enter to Continue...");
        String enter = GetUserInput.getUserString();
    }

    public static void displayMonsterTutor() {
        String monsterTutor = getAsciiArt("cyclops.txt");
        slowPrint(monsterTutor, monsterTutor.length());
    }

    public static void displayDungeon() {
        clearConsole();
        String dungeon = getAsciiArt("dungeon.txt");
        slowPrint(dungeon, dungeon.length());
    }

    public static void displayWin() {
        clearConsole();
        String victory = getAsciiArt("victory.txt");
        String victoryBanner = getAsciiArt("victoryBanner.txt");
        slowPrint(victory, victory.length());
        slowPrint(victoryBanner, victoryBanner.length());
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

    private static void topBorder(int count) {
        System.out.println("=".repeat(count));
    }

    private static void bottomBorder(int count) {
        System.out.println("=".repeat(count));
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
