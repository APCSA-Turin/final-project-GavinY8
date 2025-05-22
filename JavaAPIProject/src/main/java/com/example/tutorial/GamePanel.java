package com.example.tutorial;

import java.awt.*;
import javax.swing.*;
import com.example.entity.*;
import com.example.monster.monster1;

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

    int FPS = 60;

    Thread gameThread;

    JTextField inputField = new JTextField();

    monster1 mon1 = new monster1(this);
    Movement m = new Movement();
    //Player player = new Player(this, m);

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
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {
            update();
            repaint();
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        if (m.up) {
            playery -= speed;
        }
        if (m.left) {
            playerx -= speed;
        }
        if (m.down) {
            playery += speed;
        }
        if (m.right) {
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