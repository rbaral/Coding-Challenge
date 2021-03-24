/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ccup;

/**
 *
 * @author rbaral
 *
 * Given a set of positive integers S = { a1,a2,a3,...,an} find two subsets s1
 * and s2 of A such that S2 = S - S1 and difference of | sum(S1) - sum(S2) | is
 * minimum. For example if we have a set S={12,4,7,1,6,3,3 }then S1= {12,6} and
 * S2={ 4,7,1,3,3} such that sum(S1) - sum(S2) = 0 . It is not necessary that
 * two subsets will always have the same sum.
 *
 * Solution 1: 1)sort the array 2)alternatively put the largest and smallest of
 * the sorted array into two sub arrays
 *
 * This is a greedy approach and doesn't always give optimal solution: Its time
 * complexity is O(2^n)
 *
 * Solution 2: 1)Used DP approach 2)create a 2D array d[n+1][sum] where n is the
 * number of elements in the array and sum is the sum of all the elements in the
 * array 3) Intitialize dp[n+1][sum+1] i.e. dp[i][j] a) = 1 if some subset from
 * 1st to ith has a sum equal to j b) = 0 otherwise where i ranges from 1 to n
 * and j ranges from 0 to sum 4) So dp[n+1][sum+1] will be 1 if 1) The sum j is
 * achieved including i'th item 2) The sum j is achieved excluding i'th item.
 * 5)Let sum of all the elements be S.  *
 * To find Minimum sum difference, we have to find j such that Min{sum - j*2 :
 * dp[n][j] == 1 } where j varies from 0 to sum/2
 *
 * The idea is, sum of S1 is j and it should be closest to sum/2, i.e., 2*j
 * should be closest to sum.
 *
 *
 * Complexity: O(n*sum)
 *
 *
 * REf:
 * http://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
 */
public class BalancedPartition {

    public static int findMin(int a[], int n) {
        //find total sum
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        //an array to store the results of subproblems
        boolean dp[][] = new boolean[n + 1][sum + 1];
        //init first col as true, as ) sum is possible with all elements
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        //init top row except dp[0][0] as false. within the 0 elements, no other sum except 0 is possible
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }

        //fill the table in bottom up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                //if the ith element is excluded
                dp[i][j] = dp[i - 1][j];
                //if the ith element is included
                if (a[i - 1] <= j) {
                    dp[i][j] |= dp[i - 1][j - a[i - 1]];
                }
            }
        }
        int diff = Integer.MAX_VALUE;
        int j = sum / 2;
        for (j = sum / 2; j >= 0; j--) {
            if (dp[n][j]) {
                diff = sum - 2 * j;
                System.out.println("the array used was:" + n + ".." + j + "..array size:" + dp[0].length);
                break;
            }
        }
        //so one of the subset should have the sum of j
        System.out.println("one of the array has sum of:" + j);
        //To find the two arrays, sort the original array and do binary search to find the elements that sum to j
        return diff;
    }

    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 2, 2, 2};
        System.out.println("diff is"+findMin(arr, arr.length));
    }

}
