package com.practice.leetcode.ds_design;

import java.util.Deque;
import java.util.LinkedList;

public class SnakeGame {

    Deque<Pixel> snake;
    int[][] food;
    int foodLoc;
    int rows;
    int cols;

    /**
     * Initialize your data structure here.
     *
     * @param width  - screen width
     * @param height - screen height
     * @param food   - A list of food positions
     *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    public SnakeGame(int width, int height, int[][] food) {
        this.food = food;
        snake = new LinkedList<>();
        snake.add(new Pixel(0, 0));
        foodLoc = 0;
        rows = height;
        cols = width;
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {

        Pixel head = snake.peek();
        int newX = head.x;
        int newY = head.y;
        switch (direction) {
            case "U": {
                newX--;
                break;
            }
            case "L": {
                newY--;
                break;
            }
            case "R": {
                newY++;
                break;
            }
            case "D": {
                newX++;
                break;
            }
        }
        //if snake has touched boundaries
        if (newX < 0 || newX == rows || newY < 0 || newY == cols) {
            return -1;
        }
        //if snake beaten itself
        for (Pixel p : snake) {
            if (p.x == newX && p.y == newY) {
                return -1;
            }
        }
        snake.addFirst(new Pixel(newX, newY));
        //if not a food location
        if (!iFoodPosition(newX, newY)) {
            snake.removeLast();
        } else {
            // means it is a food position
            // and remove dummy node after first food taken
            if(foodLoc == 0){
                snake.removeLast();
            }
            foodLoc++;
        }
        System.out.println(snake.size()-1);
        return foodLoc;
    }

    private boolean iFoodPosition(int newX, int newY) {
        return foodLoc < food.length && newX == food[foodLoc][0] && newY == food[foodLoc][1];
    }

    class Pixel {
        int x;
        int y;

        Pixel(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
