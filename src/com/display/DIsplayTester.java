package com.display;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class DIsplayTester {
    public static void main(String[] args) throws IOException {

        DisplayAscii.welcomeScreen();
        DisplayAscii.displayMonsterTutor();
        DisplayAscii.displayStartMenu();
    }
}
