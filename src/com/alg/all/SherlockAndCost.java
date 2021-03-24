/*
Array A contains the elements, A1,A2...AN. And array B contains the elements, B1,B2...BN. There is a relationship between Ai and Bi, ∀ 1 ≤ i ≤ N, i.e., 
any element Ai lies between 1 and Bi.

Let the cost S of an array A be defined as:

You have to print the largest possible value of S.

Input Format

The first line contains, T, the number of test cases. Each test case contains an integer, N, in first line. The second line of each test case contains N integers that denote the array B.

Constraints

1 ≤ T ≤ 20 
1 ≤ N ≤ 105 
1 ≤ Bi ≤ 100

Output Format

For each test case, print the required answer in one line.

Sample Input

1
5
10 1 10 1 10
Sample Output

36
Explanation

The maximum value occurs when A1=A3=A5=10 and A2=A4=1.
 */
package com.alg.practice;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author rbaral
 */
public class SherlockAndCost {

    public static int findMax(int[] arr){
        if(arr==null){
            return 0;
        }else{
            int high = 0;
            int low = 0;
            for(int i=1;i<arr.length; i++){
                int high_low_diff = arr[i-1] -1;
                int low_high_diff = arr[i] -1;
                int high_high_diff = Math.abs(arr[i] - arr[i-1]);
                int nextHigh = Math.max(high+ high_high_diff, low+ low_high_diff);
                int nextLow = Math.max(low, high + high_low_diff);
                low = nextLow;
                high = nextHigh;
            }
            return Math.max(low, high);
        }
    }
    
    public static void main(String args[]) throws Exception {
        /**
         * first line contains the number of test cases second line contains the
         * number fo elements in array B in third line third line contains the
         * array B
         */
        //read the input from the console
        Scanner sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.next());
        int[] arr = null;
        for (int i = 0; i < cases; i++) {
            int itemcount = Integer.parseInt(sc.next());
            String stringInput = new Scanner(System.in).nextLine();
            //convert to array
            System.out.println("string input is:"+stringInput);
            
            String[] stringArr = stringInput.trim().split(" ");
            arr = new int[stringArr.length];
            int index = 0;
            for (String a : stringArr) {
                arr[index] = Integer.parseInt(a);
                index++;
            }
            
        }
        
        int max = findMax(arr);
        System.out.println("max for array:"+Arrays.toString(arr)+" is:"+max);
    }
}
