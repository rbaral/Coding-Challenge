/*
Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.

Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output:  True  //There is a subset (4, 5) with sum 9.

Solution:
-we can solve this problem recursively which will take exponential time
-we can use dp approach to get pseudo polynomial time
 */
package com.alg.dp;

/**
 *
 * @author rbaral
 */
public class SubsetSumChecker {

    /**
     * this is a simple recurisve solution and takes exponential time. It can be
     * extended by memoization to avoid solving same problem multiple times
     *
     * @param data
     * @param size
     * @param sum
     * @return
     */
    public static boolean isSubsetSumr(int[] data, int size, int sum) {
        //base cases
        if (sum == 0) {
            return true;
        }
        if (size == 0 && sum != 0) {
            return false;
        }
        if (data[size - 1] > sum) {//the last element cannot contribute to the sum
            return isSubsetSumr(data, size - 1, sum);//check with other items
        }
        //check if other items give sum or not
        return isSubsetSumr(data, size - 1, sum) || isSubsetSumr(data, size - 1, sum - data[size - 1]);

    }

    /**
     * this is the dp approach which uses an array to keep track of existence of
     * sum for paraticular array indices. For instance, issum[i][j] stores
     * True/False if sum of i exists by the items 1...j from the given dataset
     *
     * @param data
     * @param size
     * @param sum
     * @return
     */
    public static boolean isSubsetSumBottomUp(int[] data, int size, int sum) {
        //base cases
        if (sum == 0) {
            return true;
        }
        if (size == 0 && sum != 0) {
            return false;
        }
        boolean[][] issum = new boolean[sum + 1][size + 1];
        for (int i = 0; i <= sum; i++) {
            for (int j = 0; j <= size; j++) {
                if (i == 0) {//sum of 0 can be obtained by an empty set
                    issum[i][j] = true;
                } else if (j == 0) {//if dataset is empty, assume we cannot get the sum
                    issum[i][j] = false;
                } else { //if the current item is less than or equal to sum then only it can contribute to sum
                    issum[i][j] = issum[i][j - 1];
                    if (data[j - 1] <= i) {
                        issum[i][j] = issum[i - data[j - 1]][j - 1] || issum[i][j];
                    }
                }

            }
        }
        return issum[sum][size];

    }

    public static void main(String args[]) {
        int data[] = {3, 34, 4, 12, 5, 2};
        int target = 19;
        boolean foundr = isSubsetSumr(data, data.length, target);
        System.out.println("subset found is:" + foundr);
        System.out.println("subset found bottom up is:" + isSubsetSumBottomUp(data, data.length, target));
    }
}
