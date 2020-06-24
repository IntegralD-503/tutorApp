package com.ioHelper;

import java.util.Scanner;

public class GetUserInput {

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
}
