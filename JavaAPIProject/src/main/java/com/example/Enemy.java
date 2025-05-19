package com.example;

public class Enemy {
    private int dmg;
    private String word;
    
    public Enemy(int dmg, String word) {
        this.dmg = dmg;
        this.word = API.getWord();
    }
}



