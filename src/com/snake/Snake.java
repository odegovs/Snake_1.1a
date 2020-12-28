/*
 * Snake.java
 *
 * Version 1.1a
 *
 * 23.12.2020
 */

package com.snake;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Snake {

    //  TODO: name snake may be confusing further in the code. Rename to image
    public static Image snake;

    public static ArrayList<Integer> snakeX = new ArrayList<Integer>();
    public static ArrayList<Integer> snakeY = new ArrayList<Integer>();

    static Direction dir;

    //  TODO: move to separate file to improve readability
    enum Direction {
        RIGHT(32, 0),
        LEFT(-32, 0),
        UP(0, -32),
        DOWN(0, 32);

        //  TODO: read https://www.oracle.com/java/technologies/javase/codeconventions-declarations.html#2992
        private int x, y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //  TODO: read https://medium.com/better-programming/comments-in-your-code-730cfd1dde02
    /**
     * Import snake image
     */
    // TODO: class name is Snake, so it's alreacy clear that everything here is about Snake.
    // so it's unnecessary to put word snake everywhere
    public static void snakeImage() {
        ImageIcon getSnake = new ImageIcon("snake.png");
        snake = getSnake.getImage();
    }

    /**
     * Create first three elements of snake
     */
    public static void createSnake() {
        for (int i = 3; i > 0; i--) {
            snakeX.add(64 + i * 32);
            snakeY.add(64);
        }
        dir = Direction.RIGHT;
    }

    /**
     * Snake growing function
     */
    public static void growSnake() {
        snakeX.add(snakeX.get(snakeX.size() - 1) - dir.x);
        snakeY.add(snakeY.get(snakeY.size() - 1) - dir.y);
    }

    /**
     * Snake moving function
     */
    public static void move() {
        for (int i = snakeX.size() - 1; i > 0; i--) {
            Coordinates.snakeX = snakeX.get(0) + dir.x;
            Coordinates.snakeY = snakeY.get(0) + dir.y;

            snakeX.set(i, snakeX.get(i - 1));
            snakeY.set(i, snakeY.get(i - 1));
        }
        snakeX.set(0, Coordinates.snakeX);
        snakeY.set(0, Coordinates.snakeY);
    }
}
