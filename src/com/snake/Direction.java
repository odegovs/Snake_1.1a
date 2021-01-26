/*
 * Direction.java
 *
 * Version 1.1a
 *
 * 29.12.2020
 */

package com.snake;

public class Direction {
    enum D {
        RIGHT(32, 0),
        LEFT(-32, 0),
        UP(0, -32),
        DOWN(0, 32);

        public int x;
        public int y;

        D(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
