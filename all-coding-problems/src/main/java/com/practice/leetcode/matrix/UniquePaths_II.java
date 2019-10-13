package com.practice.leetcode.matrix;

import com.practice.gfg.FastReader;

public class UniquePaths_II {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int testCases = fr.nextInt();
        for (int i = 0; i < testCases; i++) {
            int rows = fr.nextInt();
            int columns = fr.nextInt();
            int[][] table = new int[rows][columns];
            System.out.println(uniquePathsWithObstacles(table));
        }

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        int[][] result = new int[rows][columns];
        if(obstacleGrid[0][0] != 1){
            result[0][0] = 1;
        }
        for (int i = 1; i < rows; i++) {
            if(obstacleGrid[i][0] == 1){
                result[i][0] = 0;
            } else {
                result[i][0] = result[i-1][0];
            }
        }
        for (int i = 1; i < columns; i++) {
            if(obstacleGrid[0][i] == 1){
                result[0][i] = 0;
            } else {
                result[0][i] = result[0][i-1];
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if(obstacleGrid[i][j] == 1){
                    result[i][j] = 0;
                } else {
                    result[i][j] = result[i - 1][j] + result[i][j - 1];
                }
            }
        }
        return result[rows - 1][columns - 1];
    }
}