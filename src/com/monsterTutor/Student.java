package com.monsterTutor;

public class Student {

    private String name;
    private int chances = 3;
    private boolean inDungeon = false;

    public Student(String name, boolean inDungeon) {
        this.name = name;
        this.inDungeon = inDungeon;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  
    public void loseChance() {
        this.chances -= 1;
        if (chances <= 0) {
            inDungeon = true;
        }
    }

    public void addChance() {
        this.chances += 1;
    }

    // Getters/Setters
    public int getHealth() {
        return chances;
    }

    public boolean getIsKnockedOut() {
        return inDungeon;
    }

    public boolean isInDungeon() {
        return inDungeon;
    }

    public int getChances() {
        return chances;
    }
}
