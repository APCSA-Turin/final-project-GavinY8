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
        //getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/sprites/RAH.jpg"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
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

    public void draw(Graphics2D gg) {
        //BufferedImage image = up1;
        //gg.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
        gg.setColor(Color.BLUE);
        gg.fillRect(x, y, gp.tileSize, gp.tileSize);
    }
}
