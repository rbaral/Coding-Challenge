/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * For US currency, wherein coins take values 1; 5; 10; 25 cents, write a
 * program to find the minimum number of coins required to get a change for a
 * given amount.
 *
 * Solution 1: 1) use greedy approach and start with the largest coin 2)
 * repeatedly find the remainder amount that cannot be changed by the current
 * coin and so on
 *
 *
 * Complexity: O(1) as we have constant number of coins
 *
 * @author rbaral
 */
public class CoinChange {

    static int[] coins = {25, 10, 5, 1};

    public static int coinChangeGreedy(int[] coins, int a) {
        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            count += a / coins[i];
            a = a % coins[i];
        }
        return count;
    }

    /**
     * Greedy algorithm fails when the highest denomination leaves the amount
     * which needs more coins. This would have been solved by using few coins of
     * lower denominations. Ex: for the denomintations {25,15,1} and amount 30,
     * greedy uses {25,1,1,1,1,1} which is not the correct answer but DP will
     * give {15,15}
     *
     * The folllowing DP solution works for every denominations. NOTE: the coins
     * should be sorted in ascending denomination before the algorithm works.
     *
     * Complexity: O(nk), where k is the number of denominations and n is the
     * total amount
     *
     * @param coins
     * @param total
     * @return
     */
    public static int minimumCoinBottomUp(int coins[], int total) {
        int temp[] = new int[total + 1];
        temp[0] = 0;
        List<List<Integer>> coinsUsed = new ArrayList<List<Integer>>();
        coinsUsed.add(new ArrayList<Integer>());
        //lets suppose for every value from 1 to total, we need some number of coins
        for (int i = 1; i <= total; i++) { 
            temp[i] = Integer.MAX_VALUE - 1;
            coinsUsed.add(new ArrayList<Integer>());
        }

        for (int j = 1; j <= total; j++) { //the amount
            for (int i = 0; i < coins.length; i++) {//all denominations
                if (j >= coins[i]) {
                    //be careful here. Max_val + 1 can result in very small negative number.
                    temp[j] = Math.min(temp[j], temp[j - coins[i]] + 1);
                    //for this amount, we used the coins=> coins[i]*1 + coinsUsed[j - coins[i]]
                    List<Integer> denom = new ArrayList<Integer>();
                    denom.addAll(coinsUsed.get(j - coins[i]));
                    denom.add(coins[i]);
                    coinsUsed.set(j, denom);
                }
            }

        }
        for (int i = 0; i < coinsUsed.size(); i++) {
            System.out.println("coins used for amount:" + i + " are:" + Arrays.toString(coinsUsed.get(i).toArray()));
        }
        return temp[total];
    }

    public static void main(String args[]) {
        int a = 30;
        int[] coins = {25, 15, 1};//{1,5,10,25};
        System.out.println("Greedy approach: change for " + a + " can be done with " + coinChangeGreedy(coins, a) + " coins");
        System.out.println("DP approach: change for " + a + " can be done with " + minimumCoinBottomUp(coins, a) + " coins");
    }

}
