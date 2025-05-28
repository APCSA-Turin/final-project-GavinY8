package com.example;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.example.tutorial.GamePanel;

public class MVP {
    public static void main(String[] args) {
        final String[] word = {API.getWord()};
        final int[] score = {0};
        final int[] lives = {1};
        double timerShorten = 1.0;

        JFrame frame = new JFrame("Typing Game");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        final JLabel[] titleLabel = {new JLabel(word[0], SwingConstants.CENTER)};
        JTextField inputField = new JTextField(); //input text
        JTextArea outputArea = new JTextArea();//where the fetched data will output
        JTextArea instructions = new JTextArea();
        outputArea.setEditable(false);

        // Layout setup
        JPanel panel = new JPanel(new GridLayout(4, 1)); //create the JPanel object
        //Jpanel is like a tray that you put things on and then you put the whole tray into your window
        //this panel holds a title, input field, button, and output area
        panel.add(titleLabel[0]);
        panel.add(inputField);
        panel.add(outputArea);
        panel.add(instructions);
        instructions.setEditable(false);
        instructions.setText("Instructions: Type out the word above before the time limit. \nEach attempt reduces your allotted time. Good luck.");

        //We have added components to our panel, then we add the PANEL to our FRAME
        frame.add(panel);

        // Button behavior
        Timer timer = new Timer((int)((word[0].length() * 500)*(timerShorten - (0.25*score[0]))) , new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String w = inputField.getText().trim();

                if (w.equals(word[0])) {
                    // Placeholder for data — replace with real API call
                    inputField.setText("");
                    word[0] = API.getWord();
                    titleLabel[0].setText(word[0]);
                    lives[0]++;
                    score[0]++;
                    outputArea.setText("Score: " + score[0] + "\nLives: " + lives[0]);
                } else {
                    inputField.setText("");
                    lives[0]--;
                    outputArea.setText("Score: " + score[0] + "\nLives: " + lives[0]);
                    if (lives[0] <= 0) {
                        JOptionPane.showMessageDialog(frame, "yuoer lievr is now mine!!!1!11!!! \nhar har har har", "You Lost!", JOptionPane.ERROR_MESSAGE);
                        score[0] = 0;
                        lives[0] = 0;
                    }
                }
            }
        });
        timer.start();
        frame.setVisible(true);
    }
}