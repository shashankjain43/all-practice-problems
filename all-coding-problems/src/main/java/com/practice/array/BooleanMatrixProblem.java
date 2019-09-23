package com.practice.array;

public class BooleanMatrixProblem {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int row = fr.nextInt();
            int col = fr.nextInt();
            int arr[][] = new int[row][col];
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    arr[j][k] = fr.nextInt();
                }
            }
            fillBooleanMatrixProblem(arr, row, col);
        }
    }

    private static void fillBooleanMatrixProblem(int[][] arr, int row, int col) {
        int rows[] = new int[row];
        int cols[] = new int[col];
        for (int j = 0; j < row; j++) {
            for (int k = 0; k < col; k++) {
                if(arr[j][k] == 1){
                    rows[j] = 1;
                    cols[k] = 1;
                }
            }
        }
        //fill rows
        for (int j = 0; j < row; j++) {
            for (int k = 0; k < col; k++) {
                if(rows[j] == 1 || cols[k] == 1){
                    arr[j][k] = 1;
                }
                System.out.print(arr[j][k]+" ");
            }
            System.out.println();
        }
    }
}
