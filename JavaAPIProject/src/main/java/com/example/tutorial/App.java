package com.example.tutorial;
import org.json.JSONObject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        JFrame window = new JFrame();
        JPanel panel = new JPanel();//dont delete this you bumcrack
        window.setSize(500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        GamePanel game = new GamePanel();
        window.add(game);

        window.pack();

        game.startGameThread();
    }
}