/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write an algorithm to prim all ways of arranging eight queens on an 8x8 chess
board so that none of them share the same row, column or diagonal. In this case,
"diagonal" means all diagonals, not just the two that bisect the board
* 
 *
 * @author rbaral
 */
public class ChessBoard {
    
    static int GRID_SIZE = 8;
    
    static boolean isValid(int row1, int col1, Integer[] cols){
        for(int row2 = 0;row2<row1;row2++){
            int col2 = cols[row2];
            if(col1==col2) //check if the queens fall in the same col
                return false;
            //if the distance between cols is equal to the dist between rows, they are in same diagonal
            int colDist = Math.abs(col2 -col1);
            int rowDist = row1 - row2; //row1 is the new row so it is always greter than row2
            if(colDist == rowDist)
                return false;
        }
        return true;
    }
    
    public static void putQueen(int row, Integer[] cols, ArrayList<Integer[]> res){
        if(row == GRID_SIZE){
            res.add(cols.clone());
        }else{
            for(int col = 0; col<GRID_SIZE;col++){
                if(isValid(row, col, cols)){
                    cols[row] = col; //put the queen in this col
                    //now recurse for other rows
                    putQueen(row+1, cols, res);
                }
            }
        }
    }
    
    public static void main(String args[]){
        Integer[] a = new Integer[8];
        ArrayList<Integer[]> l = new ArrayList<Integer[]>();
        putQueen(0, a, l);
        for(Integer[] aa: l){
            System.out.println(" "+Arrays.toString(aa));
        }
    }
    
}
