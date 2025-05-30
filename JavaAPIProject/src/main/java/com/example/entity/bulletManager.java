package com.example.entity;

import com.example.tutorial.GamePanel;

public class bulletManager {

    public bullet[] bulletList = new bullet[8];

    public bulletManager(GamePanel gp, Player p) {
        for (int i = 0; i < 8; i++) {
            bulletList[i] = new bullet(gp, p);
        }
    }
}
