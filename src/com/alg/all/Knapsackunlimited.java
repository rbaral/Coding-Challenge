/*
Given a knapsack weight W and a set of n items with certain value vali and weight wti, 
we need to calculate minimum amount that could make up this quantity exactly. 
This is different from classical Knapsack problem, here we are allowed to use 
unlimited number of instances of an item.

Examples:

Input : W = 100
       val[]  = {1, 30}
       wt[] = {1, 50}
Output : 100
There are many ways to fill knapsack.
1) 2 instances of 50 unit weight item.
2) 100 instances of 1 unit weight item.
3) 1 instance of 50 unit weight item and 50
   instances of 1 unit weight items.
We get maximum value with option 2.

Input : W = 8
       val[] = {10, 40, 50, 70}
       wt[]  = {1, 3, 4, 5}       
Output : 110 
We get maximum value with one unit of
weight 5 and one unit of weight 3.
 */
package com.alg.dp;

/**
 *
 * @author rbaral
 */
public class Knapsackunlimited {

    /**
     * we approach the problem as the 0-1 knapscak problem but consider the item
     * again and again because we have unlimited supply, the rest approach is
     * almost similar
     *
     * @param c
     * @param vals
     * @param weights
     * @return
     */
    public static int findMaxvalBottomUp(int c, int[] vals, int[] weights, int n) {
        //lets create an array to hold the max value
        int[] maxvals = new int[c + 1];
        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j <= c; j++) {
                if (i == 0 || j == 0) {
                    maxvals[j] = 0;
                } else if (weights[i-1] <= j) {//if this item fits, we use i-1 because weight array starts with 0 index, but maxvals array has valid values starting from index 1
					//the max value for this weight is either by including this item or by excluding it
                    maxvals[j] = Math.max(maxvals[j - weights[i-1]] + vals[i-1], maxvals[j]);
                } else {
                    maxvals[j] = maxvals[j - 1];
                }
            }
        }
        return maxvals[c];

    }

    public static void main(String args[]) {
        int c = 100;
        int val[] = {10, 30, 20};
        int wt[] = {5, 10, 15};
        int maxVal = findMaxvalBottomUp(c, val, wt, val.length);
        System.out.println("maxValBottomUp:" + maxVal);
    }

}
