package com.example;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Player extends JFrame implements KeyListener{

    public int speed=5;
    public int up=1;
    public int left=2;
    public int down=3;
    public int right=4;
    public int direction=0;

    Rectangle p1 = new Rectangle (0,0,20,40);

    public Player() {


        addKeyListener(this);
        while(true)
        {
            try
            {
                repaint();

                if(direction==up)
                {
                    p1.y-=(int)speed;
                }
                if(direction==down)
                {
                    p1.y+=(int)speed;
                }
                if(direction==right)
                {
                    p1.x+=(int)speed;
                }
                if(direction==left)
                {
                    p1.x-=(int)speed;
                }
                Thread.sleep(75);
            }
            catch (Exception e)
            {
                break;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent event) {
        // TODO Auto-generated method stub
        if(event.getKeyChar()=='w')
        {
            direction = up;
        }
        if(event.getKeyChar()=='d')
        {
            direction = left;
        }
        if(event.getKeyChar()=='s')
        {
            direction = down;
        }
        if(event.getKeyChar()=='a')
        {
            direction = left;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
