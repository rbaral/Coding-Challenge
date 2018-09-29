/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

import java.util.Arrays;

public class SortedMatrixFinder {

    /**
     * check if val is present in the matrix which has sorted rows and sorted
     * columns
     */
    public static int[] findItem(int[][] arr, int row, int col, int val) {
        //lets check from the end of a row and col and advance them accordingly
        //if the val is greater than the last item at row, then increase row
        //if the val is smaller than the first item at row, then decrease row
        //if the val is greater than the last item at col, then increase col
        //if the val is smaller than the first item at col, then decrease col
        int[] pos = new int[2];
        pos[0] = -1;
        pos[1] = -1;
        while (row >= 0 && col >= 0 && row < arr.length && col < arr[0].length) {
            System.out.println("row is:"+row+" col is:"+col);
            //check if we found the item
            if (arr[row][col] == val) {
                pos[0] = row;
                pos[1] = col;
                return pos;
            }
            //check for the tentative row
            if (val > arr[row][arr[row].length - 1]) {
                row++;
            } else if (val <= arr[row][0]) {
                row--;
            }
            //now check for the tentative column
            if (val > arr[arr.length - 1][col]) {
                col++;
            } else if (val < arr[0][col]) {
                col--;
            }
        }
        return pos;
    }

    public static void main(String args[]) {
        //create a matrix
        int[][] mat = new int[3][5];
        mat[0] = new int[]{1, 4, 7, 9, 11};
        mat[1] = new int[]{2, 6, 8, 10, 14};
        mat[2] = new int[]{5, 12, 15, 17, 18};
        int[] pos = findItem(mat, 0, mat[0].length-1, 7);
        System.out.println(Arrays.toString(pos));
    }

}
