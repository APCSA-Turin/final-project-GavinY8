package com.example.tutorial;
import org.json.JSONObject;

import javax.swing.JFrame;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        JFrame window = new JFrame();
        window.setSize(1920, 1080);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        

        GamePanel game = new GamePanel();
        window.add(game);
        window.pack();
    }
}