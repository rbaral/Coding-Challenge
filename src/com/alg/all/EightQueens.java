/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

/**
 * 8 queens problem, given a 8*8 grid, place the 8 queens in a way that they do
 * not attack each other
 */
/**
 * Sol: we solve it recursively, by first placing a queen on the first row,
 * first column, and then checking the safe place on the next column. If putting
 * a queen in the current place is unsafe, we backtrack and try with other
 * possibilities
 */
public class EightQueens {

    //place the queens starting from the first column, and update the grid
    public static boolean placeQueens(int[][] grid, int col) {
        //if we reached the end
        if (col >= grid[0].length) {
            return true;
        }

        //check for the safe place in any row of this col and place the queen
        for (int i = 0; i < grid.length; i++) {
            if (isSafeMove(grid, i, col)) {
                grid[i][col] = 1;
                //check if having a queen in this place affects the next position or not
                if (placeQueens(grid, col + 1)) {
                    return true;
                } else {
                    grid[i][col] = 0;//reset the reserved position
                }
            }
        }
        return false;//the grid or the next col was not safe

    }

    /*
	check if placing a queen in (row,col) of grid is safe or not.
	We can only check for the leftmost entries because, there are no queens
	on the right of the current (row,col) values
     */
    public static boolean isSafeMove(int[][] grid, int row, int col) {
        //check if the row has any queen on the columns left to col
        for (int i = 0; i < col; i++) {
            if (grid[row][i] == 1) {
                return false;
            }
        }
        //check the upper diagonal entries, i.e. on left side (row and col both reduces)
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (grid[i][j] == 1) {
                return false;
            }
        }

        //check the lower diagonal entries, i.e. on the left side (row increases, col decreases)
        for (int i = row, j = col; i < grid.length && j >= 0; i++, j--) {
            if (grid[i][j] == 1) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        //create a N*N grid and pass to the helper methods
        int[][] grid = new int[8][8];
        placeQueens(grid, 0);
        //print the returned grid to observe if the placement is safe
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + "     ");
            }
            System.out.print("\n");
        }
    }
}
