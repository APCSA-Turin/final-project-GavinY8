package com.example.entity;

import com.example.tutorial.GamePanel;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class bullet extends Entity {

    int count = 0;
    Player p;
    boolean touchedPlayer;

    public bullet(GamePanel gp, Player p) {
        super(gp);
        this.p = p;
        x = 500;
        y = 500;
        solidArea = new Rectangle(x, y, 32, 32);
        speed = 6;
        getImage();
        setLocation();
    }

    public void setLocation() {
        int row = (int)(Math.random()*10);
        int direct = (int)(Math.random()*4+1);
        int plusOrMinus = (int)(Math.random()*2);

        if (plusOrMinus == 0) {
            row *= -1;
        }

        count++;
        if (count > 6) {
            count = 0;
            speed++;
        }

        if (direct == 1) {
            direction = "up";
            y = gp.screenHeight-1;
            x = p.x + gp.tileSize * row;
        }
        else if (direct == 2) {
            direction = "left";
            x = gp.screenWidth-1;
            y = p.y + gp.tileSize * row;
        }
        else if (direct == 3) {
            direction = "down";
            y = 1;
            x = p.x + gp.tileSize * row;
        }
        else if (direct == 4) {
            direction = "right";
            x = 1;
            y = p.y + gp.tileSize * row;
        }
    }

    public void update() {
        touchedPlayer = false;

        if (x > gp.screenWidth || x < 0 || y < 0 || y > gp.screenHeight) {
            setLocation();
        }

        switch (direction) {
            case "up":
                y -= speed;
                break;
            case "left":
                x -= speed;
                break;
            case "down":
                y += speed;
                break;
            case "right":
                x += speed;
                break;
        }

        if (gp.cc.collisionCheck(this, gp.player) && !touchedPlayer) {
            gp.player.hp--;
            touchedPlayer = true;
        }
    }

    public void getImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/sprites/ball.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g) {
        BufferedImage image = up1;
        g.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

    public void collision() {

    }
}
