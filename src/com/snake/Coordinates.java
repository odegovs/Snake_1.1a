/*
 * Coordinates.java
 *
 * Version 1.1a
 *
 * 23.12.2020
 */

package com.snake;

import java.util.ArrayList;

public class Coordinates {
    private int x;
    private int y;

    Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Coordinates() {}

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String xString() {
        return "" + x;
    }

    public String yString() {
        return "" + y;
    }
}
