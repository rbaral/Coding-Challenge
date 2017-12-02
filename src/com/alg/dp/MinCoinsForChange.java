/*
Given a list of N coins, their values (V1, V2, … , VN), and the total sum S. 
Find the minimum number of coins the sum of which is S (we can use as many coins of one type as we want), 
or report that it’s not possible to select coins in such a way that they sum up to S.

Solution:

This can be solved using DP. I am going to show the BottomUp approach where we solve the
smaller problem first and then solve larger problems using the solution of the smaller problems.
-for every amount (1...S), we assume the largest possible value is the minimum coins required
and initialize and array min[1..S] accordingly. Dont worry, we update this array as we go on
and finally hold the correct values for each value of S.
-for the amount 0, we set min[0] = 0, because there is no change for amount 0
-for all other value of S, we check if subtracting a value equal to a coin gives better minimum value, if so we update min value


Complexity: O(N^2)

*/
package com.alg.dp;

/**
 *
 * @author rbaral
 */
public class MinCoinsForChange {
    
    public static int findMinCoins(int n, int[] coins){
        //initialize array for the amount and set to infinity
        int[] min = new int[n+1];
        for(int i=0;i<min.length;i++){
            min[i] = Integer.MAX_VALUE;// assume this is very big
        }
        //base case
        min[0] = 0;
        for(int i =1;i <=n; i++){
            for(int j=0;j<coins.length; j++){
                //if this coin can be used to make a change for i
                if(coins[j]<=i && (min[i-coins[j]]+1 < min[i])){
                    min[i] = min[i-coins[j]]+1;
                }
            }
        }
        return min[n];
    }
    public static void main(String args[]){
        int[] coins = {1, 5, 10, 25};
        int amount = 15;
        int minCoins = findMinCoins(amount, coins);
        System.out.println("for amount:"+amount+" min coins required:"+minCoins);
    }
}
