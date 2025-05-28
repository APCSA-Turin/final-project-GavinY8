package com.example.tutorial;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement implements KeyListener {
    public boolean up, down, left, right;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int q = e.getKeyCode();
        if (q==KeyEvent.VK_UP) {
            up = true;
        }
        if (q==KeyEvent.VK_LEFT) {
            left = true;
        }
        if (q==KeyEvent.VK_DOWN) {
            down = true;
        }
        if (q==KeyEvent.VK_RIGHT) {
            right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int q = e.getKeyCode();
        if (q==KeyEvent.VK_UP) {
            up = false;
        }
        if (q==KeyEvent.VK_LEFT) {
            left = false;
        }
        if (q==KeyEvent.VK_DOWN) {
            down = false;
        }
        if (q==KeyEvent.VK_RIGHT) {
            right = false;
        }
    }
}
