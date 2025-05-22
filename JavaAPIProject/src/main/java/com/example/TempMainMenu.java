package com.example;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.example.tutorial.GamePanel;

public class TempMainMenu{
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("The Keyboard Warrior");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        JLabel titleLabel = new JLabel("The Keyboard Warrior", SwingConstants.CENTER);
        JButton fetchButton = new JButton("Start");//a button fetches data when pressed

        // Layout setup
        JPanel panel = new JPanel(new GridLayout(4, 1)); //create the JPanel object
        //Jpanel is like a tray that you put things on and then you put the whole tray into your window
        //this panel holds a title, input field, button, and output area
        panel.add(titleLabel);
        panel.add(fetchButton);

        //We have added components to our panel, then we add the PANEL to our FRAME
        frame.add(panel);

        // Button behavior
        fetchButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              JFrame frame = new JFrame("The Keyboard Warrior");
              GamePanel game = new GamePanel();

              frame.add(game);
              frame.setSize(500, 500);
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              frame.setVisible(true);
          }
        });
        frame.setVisible(true);
    }
}