package com.example.entity;

import com.example.tutorial.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    Font font = new Font("Arial", Font.PLAIN, 30);
    Movement m;
    public int hp = 5;

    public Player(GamePanel gp, Movement m) {
        super(gp);
        this.m = m;
        setDefaultValues();
        getPlayerImage();

        solidArea = new Rectangle(16, 16, 16, 16);
    }

    public void setDefaultValues() {
        x = 560;
        y = 350;
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
        gp.cc.tpBack(this);

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
        gg.setFont(font);
        gg.setColor(Color.WHITE);
        gg.drawString("Score: " + gp.score , 60, gp.screenHeight-60);
        gg.drawString("HP: " + hp , 60, gp.screenHeight-100);
    }
}
