
package com.display;

import java.util.Scanner;

public class DisplayAscii {
    //Gameface


    public static int displayStartMenu() {
        clearConsole();
        topBorder();

        String option1 = "+   1 - Enter TutorMonster Academy";
        String option2 = "+   2 - View Student Statistics";
        String option3 = "+   3 - Exit";
        int padding = option1.length()+5;
        System.out.println(option1 + " ".repeat(padding-option1.length())+"+");
        System.out.println(option2 + " ".repeat(padding-option2.length())+"+");
        System.out.println(option3 + " ".repeat(padding-option3.length())+"+");
        bottomBorder();
        Scanner readin = new Scanner(System.in);
        int result = Integer.valueOf(readin.nextLine());
        return result;
    }

        public static void welcomeScreen() {
            clearConsole();
            String banner = "\n" +
                    "\n" +
                    "                        _           _____       _             \n" +
                    "     /\\/\\   ___  _ __  ___| |_ ___ _ _/__   \\_   _| |_ ___  _ __ \n" +
                    "    /    \\ / _ \\| '_ \\/ __| __/ _ \\ '__|/ /\\/ | | | __/ _ \\| '__|\n" +
                    "   / /\\/\\ \\ (_) | | | \\__ \\ ||  __/ |  / /  | |_| | || (_) | |   \n" +
                    "   \\/    \\/\\___/|_| |_|___/\\__\\___|_|  \\/    \\__,_|\\__\\___/|_|   \n" +
                    "                                                              \n" +
                    "\n";

            banner += "                                             ,--,  ,.-.\n" +
                    "               ,                   \\,       '-,-`,'-.' | ._\n" +
                    "              /|           \\    ,   |\\         }  )/  / `-,',\n" +
                    "              [ ,          |\\  /|   | |        /  \\|  |/`  ,`\n" +
                    "              | |       ,.`  `,` `, | |  _,...(   (      .',\n" +
                    "              \\  \\  __ ,-` `  ,  , `/ |,'      Y     (   /_L\\\n" +
                    "               \\  \\_\\,``,   ` , ,  /  |         )         _,/\n" +
                    "                \\  '  `  ,_ _`_,-,<._.<        /         /\n" +
                    "                 ', `>.,`  `  `   ,., |_      |         /\n" +
                    "                   \\/`  `,   `   ,`  | /__,.-`    _,   `\\\n" +
                    "               -,-..\\  _  \\  `  /  ,  / `._) _,-\\`       \\\n" +
                    "                \\_,,.) /\\    ` /  / ) (-,, ``    ,        |\n" +
                    "               ,` )  | \\_\\       '-`  |  `(               \\\n" +
                    "              /  /```(   , --, ,' \\   |`<`    ,            |\n" +
                    "             /  /_,--`\\   <\\  V /> ,` )<_/)  | \\      _____)\n" +
                    "       ,-, ,`   `   (_,\\ \\    |   /) / __/  /   `----`\n" +
                    "      (-, \\           ) \\ ('_.-._)/ /,`    /\n" +
                    "      | /  `          `/ \\\\ V   V, /`     /\n" +
                    "   ,--\\(        ,     <_/`\\\\     ||      /\n" +
                    "  (   ,``-     \\/|         \\-A.A-`|     /\n" +
                    " ,>,_ )_,..(    )\\          -,,_-`  _--`\n" +
                    "(_ \\|`   _,/_  /  \\_            ,--`\n" +
                    " \\( `   <.,../`     `-.._   _,-`\n";

            for (int i = 0; i < banner.length(); i++) {
                System.out.print(banner.charAt(i));
                try {
                    Thread.sleep(0,10000);
                } catch (InterruptedException e) {

                }
            }
            System.out.println("Press Enter to Continue...");
            Scanner readin = new Scanner(System.in);
            String enter = readin.nextLine();
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

    private static void topBorder() {
        System.out.println("==================================================================");
    }

    private static void bottomBorder() {
        System.out.println("==================================================================");
    }
}
