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
                    if (Snake.dir != Snake.Direction.DOWN) {
                        Snake.dir = Snake.Direction.UP;
                    }
                    break;

                case KeyEvent.VK_DOWN:
                    if (Snake.dir != Snake.Direction.UP) {
                        Snake.dir = Snake.Direction.DOWN;
                    }
                    break;

                case KeyEvent.VK_RIGHT:
                    if (Snake.dir != Snake.Direction.LEFT) {
                        Snake.dir = Snake.Direction.RIGHT;
                    }
                    break;

                case KeyEvent.VK_LEFT:
                    if (Snake.dir != Snake.Direction.RIGHT) {
                        Snake.dir = Snake.Direction.LEFT;
                    }
                    break;
            }
        }
    }

    /**
     * Game initialization function
     */
    public Game() {
        Apple.appleImage();
        Snake.snakeImage();
        startGame();
        addKeyListener(new KeyListener());
        setFocusable(true);
    }

    /**
     * Create objects
     */
    public void startGame() {
        Apple.createApple();
        Snake.createSnake();

        Timer timer = new Timer(300, this);
        timer.start();
    }

    /**
     * Check if snake was crashed
     */
    public void checkCrashing() {
        if (Coordinates.snakeX == 512 || Coordinates.snakeX < 0 ||
            Coordinates.snakeY == 512 || Coordinates.snakeY < 0) {
            inGame = false;
        }
        for (int i = Snake.snakeX.size() - 1; i > 0; i--) {
            if (Snake.snakeX.get(0).equals(Snake.snakeX.get(i)) && Snake.snakeY.get(0).equals(Snake.snakeY.get(i))) {
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

            for (int i = 0; i < Snake.snakeX.size(); i++) {
                gr.drawImage(Snake.snake, Snake.snakeX.get(i), Snake.snakeY.get(i), this);
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
            Apple.checkApple();
            checkCrashing();
            repaint();
        }
    }
}

