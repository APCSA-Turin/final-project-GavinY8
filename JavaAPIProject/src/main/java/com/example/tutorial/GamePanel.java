package com.example.tutorial;

import java.awt.*;
import javax.swing.*;


public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16;
    final int scale = 3;
    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    int playerx = 50;
    int playery = 50;
    int speed = 5;

    Movement m = new Movement();
    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.addKeyListener(m);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (gameThread != null) {
            update();
            repaint();
        }
    }

    public void update() {
        if (m.up == true) {
            playery -= speed;
        }
        if (m.left == true) {
            playerx -= speed;
        }
        if (m.down == true) {
            playery += speed;
        }
        if (m.right == true) {
            playerx += speed;
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics = (Graphics2D)g;
        graphics.setColor(Color.BLUE);
        graphics.fillRect(playerx, playery, tileSize, tileSize);
        graphics.dispose();
    }
}