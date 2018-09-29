/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics.searching;

/**
 *Given an MX N matrix in which each row and each column is sorted in ascending
order, write a method to find an element
* 
* We can bring these observations together into a solution. The observations are the
following:
• If the start of a column is greater than x, then x is to the left of the column.
• If the end of a column is less than x, then x is to the right of the column.
• If the start of a row is greater than x, then x is above that row.
• If the end of a row is less than x, then x is below that row.
 * @author rbaral
 */
public class SearchinSortedMatrix {
    
    static boolean findElement(int[][] a, int item){
        int rowNum = 0; //start from first row
        int colNum = a[0].length-1; //start from the right most column
        
        //now scan from the rightmost column and scan every possible row
        while(rowNum<a.length && colNum>=0){
            if(a[rowNum][colNum]==item){
                System.out.println("found at index "+rowNum+","+colNum);
                return true;
            }else if(a[rowNum][colNum]>item){ //this column should not contain the item
                //advance the column
                colNum--;
            }else{
                //the entry of this column is less than the element, so this column might have the element
                rowNum++;
            }
        }
        return false;
    }
    
    public static void main(String args[]){
        int[][] matrix = {{15, 30,  50,  70,  73}, 
                        {35, 40, 100, 102, 120},
                        {36, 42, 105, 110, 125},
                        {46, 51, 106, 111, 130},
                        {48, 55, 109, 140, 150}};
        findElement(matrix, 15);
    }
}
