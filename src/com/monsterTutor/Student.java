package com.monsterTutor;

public class Student {
    private String name;
    private int health = 100;
    boolean isKnockedOut = false;



    public void damageHealth(int damage) {
        this.health -= damage;
        if (health <= 0) {
            isKnockedOut = true;
        }
    }

    public void restoreHealth(int health) {
        this.health += health;
    }

    // Getters/Setters
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean getIsKnockedOut() {
        return isKnockedOut;
    }
}
