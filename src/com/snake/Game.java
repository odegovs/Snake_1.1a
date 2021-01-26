/*
 * Game.java
 *
 * Version 1.1a
 *
 * 23.12.2020
 */

package com.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static com.snake.Snake.crd;

public class Game extends JPanel implements ActionListener {

    private boolean inGame = true;

    /**
     * Key recognition function
     */
    static class KeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if (Snake.dir != Direction.D.DOWN) {
                        Snake.dir = Direction.D.UP;
                    }
                    break;

                case KeyEvent.VK_DOWN:
                    if (Snake.dir != Direction.D.UP) {
                        Snake.dir = Direction.D.DOWN;
                    }
                    break;

                case KeyEvent.VK_RIGHT:
                    if (Snake.dir != Direction.D.LEFT) {
                        Snake.dir = Direction.D.RIGHT;
                    }
                    break;

                case KeyEvent.VK_LEFT:
                    if (Snake.dir != Direction.D.RIGHT) {
                        Snake.dir = Direction.D.LEFT;
                    }
                    break;
            }
        }
    }

    /**
     * Game initialization function
     */
    public Game() {
        Apple.image();
        Snake.image();
        startGame();
        addKeyListener(new KeyListener());
        setFocusable(true);
    }

    /**
     * Create objects
     */
    public void startGame() {
        Apple.create();
        Snake.create();

        Timer timer = new Timer(300, this);
        timer.start();
    }

    /**
     * Check if snake was crashed
     */
    public void checkCrashing() {
        if (crd.getX() == 512 || crd.getX() < 0 ||
            crd.getY() == 512 || crd.getY() < 0) {
            inGame = false;
        }

        for (int i = Snake.snake.size() - 1; i > 0; i--) {
            if (crd.getX() == Integer.parseInt(Snake.snake.get(i).xString()) &&
                    crd.getY() == Integer.parseInt(Snake.snake.get(i).yString())) {
                inGame = false;
                break;
            }
        }
    }

    /**
     * Drawing script
     */
    @Override
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        if (inGame) {
            gr.drawImage(Apple.apple, Apple.appleX, Apple.appleY, this);

            for (int i = 0; i < Snake.snake.size(); i++) {
                gr.drawImage(Snake.cell, Integer.parseInt(Snake.snake.get(i).xString()),
                        Integer.parseInt(Snake.snake.get(i).yString()), this);
            }
        } else {
            String over = "You Lost";
            gr.setColor(Color.BLACK);
            gr.drawString(over, 240, 240);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            Snake.move();
            Apple.check();
            checkCrashing();
            repaint();
        }
    }
}

