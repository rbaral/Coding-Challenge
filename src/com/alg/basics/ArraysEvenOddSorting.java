/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics;

/**
 * Given an array of integers, order the entries so that the even entries
 * appear first and the odd entries appear.However, you are required to solve it without
allocating additional storage.
 *
 * @author rbaral
 */
public class ArraysEvenOddSorting {
    
    /**
     * Have one index pointing at start of array as the even index and another
     * at the end of the array as the odd index.
     * 1)repeat while evenindex < oddindex
     * 1 a) If a[evenindex] is even advance the evenindex(evenindex++)
     * 1 b) if a[oddindex] is odd advance the odd index (oddindex--)
     * 1 c) If a[evenindex] is odd, swap a[evenindex] with a[oddindex]
     * 1 d) if a[oddindex] is even, swap a[oddindex] with a[evenindex]
     * 
     * Complexity: O(n)
     * Space: O(1)
     * 
     * @param x
     * @return 
     */
    public static int[] sortEvenOdd(int[] a){
        int oddIndex = a.length-1;
        int evenIndex = 0;
        while(evenIndex<oddIndex){
            if(a[evenIndex]%2==0){ //is even
                evenIndex++;
            }else{
                int temp = a[oddIndex];
                a[oddIndex] = a[evenIndex];
                a[evenIndex] = temp;
                oddIndex--;
            }
            /*
            if (a[oddIndex]%2==0){ //is even
                int temp = a[oddIndex];
                a[oddIndex] = a[evenIndex];
                a[evenIndex] = temp;
            }else{
                oddIndex--;
            }
            */
        }
        return a;
    }
    public static void main(String args[]){
        int[] a ={12,2,4,7,9};
        System.out.println("before sorting\n");
        for(Integer aa:a){
            System.out.print(aa+",");
        }
        a = sortEvenOdd(a);
        System.out.println("\n");
                System.out.println("after sorting\n");
        for(Integer aa:a){
            System.out.print(aa+",");
        }
        System.out.println();
    }
}
