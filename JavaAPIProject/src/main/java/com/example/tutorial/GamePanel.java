package com.example.tutorial;

import java.awt.*;
import javax.swing.*;

import com.example.API;
import com.example.entity.*;
import com.example.tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 24; //1152
    public final int maxScreenRow = 16; //768
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    public String word = API.getWord();

    public int score;

    int FPS = 60;

    TileManager tm = new TileManager(this);
    Movement m = new Movement();
    KeyReader kr = new KeyReader(this);
    Thread gameThread;
    public Player player = new Player(this, m);
    bulletSpawner bs = new bulletSpawner(this, player);
    public CollisionChecker cc = new CollisionChecker(this);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(m);
        this.addKeyListener(kr);
    }

    //starts running the game
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    //updates 60 times per second
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {
            update();
            repaint();
            this.requestFocusInWindow();
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

    //updates player and projectile locations
    public void update() {
        player.update();
        for (int i = 0; i < 8; i++) {
            bs.bulletList[i].update();
        }
    }

    //updates visuals
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D)g;
        tm.draw(graphics);
        player.draw(graphics);
        for (int i = 0; i < 8; i++) {
            bs.bulletList[i].draw(graphics);
        }
        kr.draw(graphics);
        graphics.dispose();
    }
}