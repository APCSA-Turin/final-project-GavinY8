package com.example.entity;
import com.example.*;
import com.example.tutorial.GamePanel;

import java.awt.Rectangle;

public class Entity {
    GamePanel gp;
    public int x, y;
    public int speed;
    //public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    public int spriteCounter;
    public int spriteNum;
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }
}
