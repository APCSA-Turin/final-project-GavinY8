package com.example.tutorial;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        JFrame window = new JFrame();
        window.setSize(1152, 768);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(false);

        JButton fetchButton = new JButton("Press to start! (please for the love of god only click it once)");
        fetchButton.setSize(461, 307);
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        window.add(fetchButton);


        fetchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.remove(fetchButton);

                GamePanel game = new GamePanel();
                window.add(game);

                window.pack();

                game.startGameThread();
            }
        });
        window.setVisible(true);

    }
}