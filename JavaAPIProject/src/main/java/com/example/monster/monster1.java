package com.example.monster;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.example.API;
import com.example.entity.Entity;
import com.example.tutorial.*;

public class monster1 extends Entity {
    String word;

    public monster1(GamePanel gp) {
        super(gp);
        word = API.getWord();
    }

    

}