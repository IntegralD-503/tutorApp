package com.monsterTutor;

public class Student {
    private static int MIN_HEALTH = 0;
    private static int MAX_HEALTH = 100;

    private String name;
    private int health;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
