/*
 * Main.java
 *
 * Version 1.1a
 *
 * 23.12.2020
 */

package com.snake;

import javax.swing.*;

public class Main extends JFrame {

    /**
     * Initialize game window
     */
    public Main() {
        this.add(new Game());
        this.setTitle("Snake");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setSize(528, 550);
        this.setVisible(true);

        /* Background Image
        try {
            this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("background.png")))));
        } catch (IOException e) {};
        */
    }

    public static void main(String[] args) {
        new Main();
    }
}
