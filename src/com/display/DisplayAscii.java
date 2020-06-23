
package com.display;

public class DisplayAscii {
    //Gameface


    public static void displayStartMenu() {
        System.out.println("1 - Enter TutorMonster Academy");
        System.out.println("2 - View Student Statistics");
        System.out.println("3 - Exit");
    }

        public static void displayBanner() {
            clearConsole();
            System.out.println("\n" +
                    "\n" +
                    " _____       _                                   _            \n" +
                    "/__   \\_   _| |_ ___  _ __ /\\/\\   ___  _ __  ___| |_ ___ _ __ \n" +
                    "  / /\\/ | | | __/ _ \\| '__/    \\ / _ \\| '_ \\/ __| __/ _ \\ '__|\n" +
                    " / /  | |_| | || (_) | | / /\\/\\ \\ (_) | | | \\__ \\ ||  __/ |   \n" +
                    " \\/    \\__,_|\\__\\___/|_| \\/    \\/\\___/|_| |_|___/\\__\\___|_|   \n" +
                    "                                                              \n" +
                    "\n");
        }
    public static void displayMonsterTutor() {
        String monsterTutor = "           _......._\n" +
                "       .-'.'.'.'.'.'.`-.\n" +
                "     .'.'.'.'.'.'.'.'.'.`.\n" +
                "    /.'.'               '.\\\n" +
                "    |.'    _.--...--._     |\n" +
                "    \\    `._.-.....-._.'   /\n" +
                "    |     _..- .-. -.._   |\n" +
                " .-.'    `.   ((@))  .'   '.-.\n" +
                "( ^ \\      `--.   .-'     / ^ )\n" +
                " \\  /         .   .       \\  /\n" +
                " /          .'     '.  .-    \\\n" +
                "( _.\\    \\ (_`-._.-'_)    /._\\)\n" +
                " `-' \\   ' .--.          / `-'\n" +
                "     |  / /|_| `-._.'\\   |\n" +
                "     |   |       |_| |   /-.._\n" +
                " _..-\\   `.--.______.'  |\n" +
                "      \\       .....     |\n" +
                "       `.  .'      `.  /\n" +
                "         \\           .'\n" +
                "          `-..___..-`";

        for (int i = 0; i < monsterTutor.length(); i++) {
            System.out.print(monsterTutor.charAt(i));
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {

            }
        }
        System.out.println();
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
}
