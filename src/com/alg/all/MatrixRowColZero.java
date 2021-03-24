/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

/**
 * PROBLEM: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0.
* 
 *At first glance, this problem seems easy: just iterate through the matrix and every time
we see a cell with value zero, set its row and column to 0.There's one problem with that
solution though: when we come across other cells in that row or column, we'll see the
zeros and change their row and column to zero. Pretty soon, our entire matrix will be
set to zeros.
 * @author rbaral
 */
public class MatrixRowColZero {
    
    /**
     * check if an element in a matrix is zero and then set the row and column to all zeros
	 and return the changed matrix
     * @param matrix
     * @return 
     */
    static int[][] checkForZeros(int[][] matrix){
        //lets not tamper the original matrix, if we do so, we don't know if the
        //zeros in the matrix are from the original matrix or the one we introduced
        //so we store the rows and columns where we found zeros in different arrays
        List zeroRows = new ArrayList(); 
        List zeroCols = new ArrayList(); 
        //we are saving the loop to initialize the zeroRows and zeroCols where by default all 0s are stored
        //we infact will use exact rows and col values (starting from 1 instead of 0s)
        //now iterate through the elements of matrix and check if there is any element with zero value
        for(int i=0;i<matrix.length;i++){//the row of a matrix
            for(int j =0;j<matrix[i].length;j++){//the column of a row
				//check if the element is zero
				if(matrix[i][j]==0){
					//we can check if the values i and j are already present or not before adding them to the Arraylists
					if(!zeroRows.contains(i)){
						zeroRows.add(i);
					}
					if(!zeroCols.contains(j)){
						zeroCols.add(j);
					}
					
				}
			}
        }
		//now lets see the zero rows and zero cols
		for(int i=0;i<zeroRows.size();i++){
			System.out.println("The matrix has zero at rows:"+zeroRows.get(i));
			//now change every element at this row to zero
			for(int j=0;j<matrix[i].length;j++){
				matrix[(int)zeroRows.get(i)][j] = 0;
			}
		}
		
		System.out.println("now the new matrix is:");
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
			System.out.println("");//for new row
		}
		
		for(int j=0;j<zeroCols.size();j++){
			System.out.println("The matrix has zero at cols:"+zeroCols.get(j));
			for (int i=0;i<matrix.length;i++){
				matrix[i][(int)zeroCols.get(j)] = 0;
		}
	}
		
        return matrix;
    }
    
    public static void main(String args[]){
        //lets create a 5*5 matrix
        int[][] matrix = new int[5][5];
        //initialize the matrix using random number
		int rand = 0;
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				rand = (int)(Math.random()*5000)+1; //get the random number between 0 adn 50
				if(rand%4==0) //for every even number lets assign zero
					matrix[i][j] = 0;
				else
					matrix[i][j] = rand;
					
			}
		}
        System.out.println("original matrix is:");
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
			System.out.println("");//for new row
		}
        matrix = checkForZeros(matrix);
		System.out.println("new matrix is:");
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
			System.out.println("");//for new row
		}
    }
}
