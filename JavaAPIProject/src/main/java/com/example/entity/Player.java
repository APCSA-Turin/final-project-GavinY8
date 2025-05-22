package com.example.entity;

import com.example.tutorial.*;

public class Player extends Entity{
    GamePanel gp;
    Movement m;

    public Player(GamePanel gp, Movement m) {
        super(gp);
        this.m = m;
    }
}
