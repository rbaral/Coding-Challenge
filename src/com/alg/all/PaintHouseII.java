/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.locked;

/**
 *
 * @author rbara012
 * 
 * There are a row of n houses, each house can be painted with one of the k colors. 
 * The cost of painting each house with a certain color is different. 
 * You have to paint all the houses such that no two adjacent houses have the same color.
The cost of painting each house with a certain color is represented by a n x k cost matrix. 
* For example, costs[0][0] is the cost of painting house 0 with color 0; 
* costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

* Note:
All costs are positive integers.
* 
Follow up:
Could you solve it in O(nk) runtime?
* 
 * 
 * Solution 1:
 * 
 * Explanation: 
 * dp[i][j] represents the min paint cost from house 0 to house i when house i use color j; 
 * The formula will be dp[i][j] = Math.min(any k!= j| dp[i-1][k]) + costs[i][j].

Take a closer look at the formula, we don't need an array to represent dp[i][j], we only need to know the min cost to the previous house of any color 
* and if the color j is used on previous house to get prev min cost, use the second min cost that are not using color j on the previous house. 
* So I have three variable to record: prevMinCost, prevMinColor, prevSecondMinCost. and the above formula will be translated into: 
* dp[currentHouse][currentColor] = (currentColor == prevMinColor? prevSecondMinCost: prevMinCost) + costs[currentHouse][currentColor].
 * 
 * REf:https://discuss.leetcode.com/topic/25489/fast-dp-java-solution-runtime-o-nk-space-o-1
 */
public class PaintHouseII {
    
    
    public int minCostII(int[][] costs){
        if(costs==null || costs.length==0 || costs[0].length==0){
            return 0;
        }
        
        //find the number of houses and the colors
        int k = costs[0].length, n = costs.length;
        
        if(k==1){//if only one color is there, only one house can be painted else we can't get the combination
            return (n==1?costs[0][0]:-1);
        }
        
        int prevMinCost = 0; //the min cost till the previous house
        int prevSecMinCost = 0; //the second min cost till the previous house- we need this because we need to check if the current house gets the color of the prev house then check which gives the mininum cost
        int prevMinColor = -1; //which color was used for the previous house
        
        for(int i=0;i<n;i++){
            int minCost = Integer.MAX_VALUE;
            int minColor = -1;
            int secMinCost = Integer.MAX_VALUE;
            for(int j=0;j<k;j++){
                int cost = costs[i][j] + (j==prevMinColor?prevSecMinCost:prevMinCost);
                if(minColor<0){ //for the first time we don't have valid color value in minColor
                    minColor = j;
                    minCost = cost;
                }else if(cost<minCost){ //if the current cost is less than the minimum cost found so far
                    secMinCost = minCost;
                    minCost = cost;
                    minColor = j;
                }else if(cost<secMinCost){ //if the current cost is less than the second minimum cost found so far
                    secMinCost = cost;
                }
            }
            prevMinColor = minColor;
            prevMinCost = minCost;
            prevSecMinCost = secMinCost;
        }
        return prevMinCost;
    }
}
