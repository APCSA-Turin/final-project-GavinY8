package com.example.entity;

import com.example.tutorial.GamePanel;

import java.awt.*;

public class bullet1 extends Entity {

    int count = 0;

    public bullet1(GamePanel gp) {
        super(gp);
        solidArea = new Rectangle(24, 24, 24, 24);
        x = 5000;
        y = 5000;
        speed = 6;
    }

    public void location() {
        int row = (int)(Math.random()*5);
        int direct = (int)(Math.random()*4+1);

        if (direct == 1) {
            direction = "up";
            y = 0;
            x = (gp.screenWidth/5) * row;
        }
        else if (direct == 2) {
            direction = "left";
            x = 0;
            y = (gp.screenWidth/5) * row;
        }
        else if (direct == 3) {
            direction = "down";
            y = 0;
            x = (gp.screenWidth/5) * row;
        }
        else if (direct == 4) {
            direction = "right";
            x = 0;
            y = (gp.screenWidth/5) * row;
        }
    }

    public void update() {
        if (direction.equals("up")) {
            y -= speed;
        }
        else if (direction.equals("left")) {
            x -= speed;
        }
        else if (direction.equals("down")) {
            y += speed;
        }
        else if (direction.equals("right")) {
            x += speed;
        }
    }
}
