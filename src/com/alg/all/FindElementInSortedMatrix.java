/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;

/**
 *
 * @author rbaral
 *
 * Ref: CTCI
 */
public class FindElementInSortedMatrix {

    public static boolean findElement(int[][] matrix, int elem) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == elem) {
                System.out.println("\nelem "+elem+" found at:"+row+","+col);
                return true;
            } else if (matrix[row][col] > elem) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int M = 10;
        int N = 5;
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = 10 * i + j;
            }
        }
        for (int i = 0; i < M; i++) {
            System.out.println("");
            for (int j = 0; j < N; j++) {
                System.out.print(" "+matrix[i][j]);
            }
        }
        System.out.println(findElement(matrix, 94));
        /*
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                int v = 10 * i + j;
                System.out.println(v + ": " + findElement(matrix, v));
            }
        }
        */

    }
}
