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
    public static Image cell;

    static Direction.D dir;

    static ArrayList<Coordinates> snake = new ArrayList();
    static Coordinates crd = new Coordinates();

    public static void image() {
        ImageIcon getSnake = new ImageIcon("snake.png");
        cell = getSnake.getImage();
    }

    /**
     * Create first three elements of snake
     */
    public static void create() {
        snake.add(new Coordinates(128, 64));
        snake.add(new Coordinates(96, 64));
        snake.add(new Coordinates(64, 64));
        dir = Direction.D.RIGHT;
    }

    public static void grow() {
        snake.add(new Coordinates(crd.getX() - dir.x, crd.getY() - dir.y));
    }

    public static void move() {
        for (int i = snake.size() - 1; i > 0; i--) {
            crd.setX(Integer.parseInt(snake.get(0).xString()) + dir.x); // Change
            crd.setY(Integer.parseInt(snake.get(0).yString()) + dir.y); // direction

            snake.set(i, snake.get(i - 1)); // Move snake for one element
        }
        snake.set(0, new Coordinates(crd.getX(), crd.getY()));
    }
}
