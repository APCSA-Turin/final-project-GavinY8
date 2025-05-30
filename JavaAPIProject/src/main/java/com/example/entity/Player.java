package com.example.entity;

import com.example.tutorial.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    Movement m;

    public Player(GamePanel gp, Movement m) {
        super(gp);
        this.m = m;
        setDefaultValues();
        getPlayerImage();

        solidArea = new Rectangle(16, 16, 16, 16);

    }

    public void setDefaultValues() {
        x = 500;
        y = 450;
        speed = 6;
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/sprites/RAH.jpg"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        collisionOn = false;
        gp.cc.checkTile(this);

        //stop movement if collision is on
        if (!collisionOn) {
            if (m.up) {
                y -= speed;
            }
            if (m.left) {
                x -= speed;
            }
            if (m.down) {
                y += speed;
            }
            if (m.right) {
                x += speed;
            }
        }
    }

    public void draw(Graphics2D gg) {
        BufferedImage image = up1;
        gg.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
