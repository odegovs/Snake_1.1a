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

import static com.snake.Snake.crd;

public class Apple {

    public static int appleX;
    public static int appleY;
    public static Image apple;

    public static void image() {
        ImageIcon getApple = new ImageIcon("apple.png");
        apple = getApple.getImage();
    }

    public static void create() {
        appleX = new Random().nextInt(16) * 32;
        appleY = new Random().nextInt(16) * 32;
    }

    public static void check() {
        if (crd.getX() == appleX && crd.getY() == appleY) {
            Snake.grow();
            create();
        }
    }
}
