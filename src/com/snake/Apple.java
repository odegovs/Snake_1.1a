/*
 * Apple.java
 *
 * Version 1.1a
 *
 * 23.12.2020
 */

package com.snake;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Apple {

    public static int appleX;
    public static int appleY;
    public static Image apple;

    /**
     * Import apple image
     */
    public static void appleImage() {
        ImageIcon getApple = new ImageIcon("apple.png");
        apple = getApple.getImage();
    }

    /**
     * Create apple in random position
     */
    public static void createApple() {
        appleX = new Random().nextInt(16) * 32;
        appleY = new Random().nextInt(16) * 32;
    }

    /**
     * Check if apple was eaten
     */
    public static void checkApple() {
        if (Coordinates.snakeX == appleX && Coordinates.snakeY == appleY) {
            Snake.growSnake();
            createApple();
        }
    }
}
