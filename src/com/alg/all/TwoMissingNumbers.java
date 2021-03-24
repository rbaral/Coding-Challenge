/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics;

/**
 *
 * @author rbaral
 */
public class TwoMissingNumbers {
    
    /**
     * finds the two missing numbers in an array, given the array without the two numbers
     * and the size of the original array (where all elements from 1 to n were present)
     * 
     * Solution 1:
     * 1)find the sum of numbers in the original array
     * 2) find the sum of numbers in the small array and subtract it from (1)
     * 3) find the product of numbers in original array
     * 4)find the product of numbers in the small array and divide the (3) by it
     * 5)we have the sum of the two missing numbers and also their product
     * i.e. we have a+b = x, and a*b = y, so this can be solved for the values of a and b
     * 
     * Sum of the original array: n(n+1)/2 ; if it is an array of numbers from 1 to n
     * 
     * Complexity: O(n)
     * we can use two pointers one at the beginning of the array and one at the end of the array to reduce the time to get the sum
     * and product of the smaller array
     * 
     * @param arr
     * @param n
     * @return 
     */
    public static double[] findTwoMissingNumbers(int[] arr, int size){
        double[] n = new double[2];
        //find the sum of n numbers in the range 1 to n
        double sum1 = size*(size+1)/2.0;
        double prod1 = 1;
        for(int i=1;i<=size;i++)
            prod1*=i;
        
        //now for the smaller array
        double sum2 = 0;
        double prod2 = 1;
        for(int i=0;i<arr.length;i++){
            sum2+=arr[i];
            prod2*=arr[i];
        }
        //diff of the sum of org and new array
        double sumOfTwo = sum1 - sum2;
        double prodOfTwo = prod1/prod2;
        //from these two equations, find the two numbers
        double num1, num2, diffOfTwo;
        //System.out.println("sumof two:"+sumOfTwo+"...prod of two:"+prodOfTwo);
        diffOfTwo = Math.sqrt(sumOfTwo*sumOfTwo  - 4*prodOfTwo);
        num2 = (sumOfTwo - diffOfTwo)/2.0;
        num1 = sumOfTwo - num2;
        n[0] = num1; n[1] = num2;
        return n;
    }
    
    public static void main(String args[]){
        int[] a = {1,2,3,4,6,7,9,10};
        double [] missingNums = findTwoMissingNumbers(a, a.length+2);
        for(Double aa:missingNums){
            System.out.println("missing number is:"+aa);
        }
    }
    
}
