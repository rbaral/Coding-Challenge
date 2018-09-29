/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

/**
 * Knapsack problem: Given a set of items with weight and value pairs, and a
 * knapsack with a capacity W, find the items that can be filled in the knapsack
 * and have maximum value.
 *
 * Solution: -can be solved using greedy approach, but does not always yield an
 * optimal solution
 *
 * We need to use dynamic programming: OPT[i] = 0, if i==0 OPT[i] = OPT[i-1, w],
 * if wi>w OPT[i] = max(OPT[i-1, w-wi] + vi, OPT[i-1, w]), where w is the
 * remaining space in knapsack
 */
class Item {

        int weight;
        int val;

        public Item(int w, int v) {
            weight = w;
            val = v;
        }

        public int getWeight() {
            return weight;
        }

        public int getVal() {
            return val;
        }
    }

public class KnapSack01Filler {

    static int findMaxProfit(Item[] items, int cap) {
        int maxProfit = 0;
        //lets initialize the optimal profit for each item
        int[][] opt = new int[items.length][cap+1];
        int c = cap; //remaining capacity
        for (int i = 1; i < items.length; i++) {//for every item
            for (int j = 1; j <=c; j++) {//for every remaining capacity
                //if this item fits
                if (items[i].getWeight() <= j) {
                    opt[i][j] = Math.max(opt[i - 1][j - items[i].getWeight()] + items[i].getVal(), opt[i - 1][j]);
                } else {
                    opt[i][j] = opt[i - 1][j];
                }
            }

        }
        //the max profit is stored in the last grid of opt
        for(int i=0; i<opt.length; i++){
            for(int j = 0; j<opt[0].length;j++){
                System.out.print(" "+ opt[i][j]);
            }
            System.out.println("");
        }
        maxProfit = opt[items.length - 1][cap];
        return maxProfit;

    }

    public static void main(String args[]) {
        Item[] items = {new Item(1, 1), new Item(2, 6), new Item(5, 18), new Item(6, 22), new Item(7, 28)};
        int c = 11;
        int profit = findMaxProfit(items, c);
        System.out.println("max profit is:" + profit);
    }
}
