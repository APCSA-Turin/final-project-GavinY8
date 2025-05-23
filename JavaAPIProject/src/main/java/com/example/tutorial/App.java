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
        JPanel panel = new JPanel();
        window.setSize(1920, 1080);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        GamePanel game = new GamePanel();
        JTextField inputField = new JTextField();
        panel.add(inputField);
        window.add(game);

        window.pack();

        game.startGameThread();
    }
}