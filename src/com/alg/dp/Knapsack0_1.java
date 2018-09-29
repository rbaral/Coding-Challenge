/*
Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. 
In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items 
respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that 
sum of the weights of this subset is smaller than or equal to W. 
You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).


Solution:
-we cannot use brute force approach of trying each and every items and check if the value is maximum
-sorting the items by thier values and taking the one with maximum value might work for some cases but
not for all set of weights and values (here the greedy approach fails), if we were allowed to take fraction of items
then the greedy approach would have worked instead
-we can use dynamic programming as it has many overlapping subproblems
-for every item, we check if this item fits in the knapsack and including it increases the value
 */
package com.alg.dp;

/**
 *
 * @author rbaral
 */
public class Knapsack0_1 {

    /**
     * this is a recursive approach,
     * it can be extended to meomoization which will be computationally cheaper than the plain recursive model
     * @param c
     * @param vals
     * @param weights
     * @param size
     * @return 
     */
    public static int findMaxvalueRec(int c, int[] vals, int[] weights, int size) {
        //base cases
        if (c == 0 || size == 0) {//zero capacity knapsack, or no items left to be considered
            return 0;
        }
        if (weights[size - 1] > c) {
            //this cannot be included, so continue with other items
            return findMaxvalueRec(c, vals, weights, size - 1);
        } else {
            //check if including this item maximizes the profit and does not violate the capacity constraints
            int valIncluding = findMaxvalueRec(c - weights[size - 1], vals, weights, size - 1) + vals[size - 1];
            int valExcluding = findMaxvalueRec(c, vals, weights, size - 1);
            return Math.max(valIncluding, valExcluding);
        }
    }

    /**
     * we create a 2-d array to hold the value of every item for weight(1,2,...,c),
     * and iteratively check if the current item fits for the current weight
     * @param c
     * @param vals
     * @param weights
     * @param size
     * @return 
     * 
     * complexity: O(nW)
     */
    public static int findMaxvalueBottomUp(int c, int[] vals, int[] weights, int size) {
        //base cases
        if (c == 0 || size == 0) {
            return 0;
        }
        //lets create an array that stores the maximum value for every element
        int[][] maxvals = new int[size + 1][c + 1];
        for (int i = 0; i <= size; i++) {//for every item
            for (int j = 0; j <= c; j++) {//for every possible weight till the capacity constraint is met
                if (i == 0||j == 0) {//no item or no weight left
                    maxvals[i][j] = 0;
                } else if (weights[i - 1] <= j) {//there is still capacity left for this item
                    maxvals[i][j] = Math.max(maxvals[i - 1][j - weights[i - 1]] + vals[i - 1],
                            maxvals[i - 1][j]);
                } else {
                    maxvals[i][j] = maxvals[i - 1][j];
                }
            }
        }
        return maxvals[size][c];
    }

    public static void main(String args[]) {
        int c = 50;
        int[] vals = {100, 120, 60};
        int[] weights = {20, 30, 10};
        int valr = findMaxvalueRec(c, vals, weights, vals.length);
        System.out.println("valr:" + valr);
        int valdp = findMaxvalueBottomUp(c, vals, weights, vals.length);
        System.out.println("valdp:" + valdp);

    }

}
