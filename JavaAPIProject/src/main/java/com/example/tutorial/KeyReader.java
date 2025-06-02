package com.example.tutorial;

import com.example.API;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyReader implements KeyListener {

    GamePanel gp;
    String firstLetter;
    String input;
    Font f;

    public KeyReader(GamePanel gp) {
        this.gp = gp;
        firstLetter = gp.word.substring(0, 1);
        f = new Font("Arial", Font.BOLD, 64);
    }

    public void draw (Graphics2D g) {
        g.setFont(f);
        g.setColor(Color.white);
        g.drawString(gp.word, gp.screenWidth/2 - 96, gp.screenHeight/2);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        input = e.getKeyChar()+"";

        if (gp.word.isEmpty()) {
            gp.word = API.getWord();
            gp.score++;
        }

        firstLetter = gp.word.substring(0, 1);

        if (firstLetter.equals(input)) {
            gp.word = gp.word.substring(1);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
