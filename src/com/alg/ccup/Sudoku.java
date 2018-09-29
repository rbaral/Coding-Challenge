/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ccup;

/**
 *
 * @author rbaral
 */
public class Sudoku {

    public static void Sudoku(int[][] mat) {
        int n = mat.length;
        int col = 0;
        for (int i = 0; i < n; i++) {
            col = 0;
            if (i == 0) {
                while (col < n) {
                    mat[i][col] = col;
                    col++;
                }
            } else {
                while (col < n) {
                    //System.out.println(col);
                    if (col + 1 < n) {
                        mat[i][col] = mat[i - 1][col + 1];
                        col++;
                    } else {
                        mat[i][col] = mat[i - 1][0];
                        break;
                    }
                }
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void main(String args[]){
        int[][] a = new int[3][3];
        a[0][0] = a.length-1;
        a[0][1] = 0;
        Sudoku(a);
    }
}
