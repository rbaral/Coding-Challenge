/*
Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents)
and pennies (1 cent), write code to calculate the number of ways of representing n
cents.

solution:
-As we have infinite number of coins, we can use either of the combinations
-we can use a denomination or not for the total value of n
-we repate this process for all the denomintations untill n>0
-For e.g., if n=100,
we can have change of 100 using a quarter or change of 75 without using a quarter
-for 75 cents again we can have a change of 75 using a quarter or of 50 without using a quarter
-this process is recursively repated until n>0


Extension: what if there are infinite number of coins of different denominations(i.e. we have more than 4 types of coins)
Extension: Can you print the denominations used in each way of change?

 */
package com.alg.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rbaral
 */
public class ChangeMaker {

    static int a = 1;

    public static int makeChange1(int n, int denom) {
        //we can use 0 denom, 1 denom, 2 denom, and so on
        if (denom == 1) {
            return 1;
        }
        int ways = 0;
        int nextDenom = 0;
        //lets use the denoms in order
        switch (denom) {
            case 25:
                nextDenom = 10;
                break;
            case 10:
                nextDenom = 5;
                break;
            case 5:
                nextDenom = 1;
                break;
            default:
                nextDenom = 1;//can always use 1 which at least divides every value of n
        }
        for (int i = 0; i * denom <= n; i++) {
            ways += makeChange1(n - i * denom, nextDenom);//after using i of denom, we might use other denom for the remaining amount
        }
        return ways;

    }

    public static void makeChange2(int n, int denom, List<List<Integer>> changes) {
        if (denom == 1) {
            if (changes.size() == 0) {
                changes.add(new ArrayList<Integer>());
            }
            int i = n;
            while (i > 0) {
                //System.out.println("***amount left "+i+" adding denom "+denom);
                changes.get(changes.size() - 1).add(denom);
                i--;
            }
            return;
        }
        int nextDenom = 0;
        //lets use the denoms in order
        switch (denom) {
            case 25:
                nextDenom = 10;
                break;
            case 10:
                nextDenom = 5;
                break;
            case 5:
                nextDenom = 1;
                break;
            default:
                nextDenom = 1;//can always use 1 which at least divides every value of n
        }
        for (int i = 0; i * denom <= n; i++) {
            if (i == 0) {
                //this coin was not used so we don't create a new list
                makeChange2(n - i * denom, nextDenom, changes);//after using i of denom, we might use other denom for the remaining amount
            } else {
                //the existing list will be filled because this coin was used
                List<Integer> change = new ArrayList<Integer>();
                changes.add(change);

                //add the denomination i*denom times
                int k = i;
                while (k > 0) {
                    System.out.println("i is " + i + " amount left " + n + " adding denom " + denom);
                    changes.get(changes.size() - 1).add(denom);
                    k--;
                }
                makeChange2(n - i * denom, nextDenom, changes);
            }
        }
    }

    
    static long getWays(long n, long[] c) {
        Arrays.sort(c); //, Collections.reverseOrder());//sort the denominations
        Map<String,Long> amountMap = new HashMap<String,Long>();
        long[] arr = c;
        return findWays(n, c, c.length - 1, amountMap);
    }

    /**
     * this solution is called recursion with memoization (a variant of DP also known as TopDown approach)
     * @param n
     * @param denoms
     * @param denomIndex
     * @param amountMap
     * @return 
     */
    public static long findWays(long n, long[] denoms, int denomIndex, Map<String,Long> amountMap) {
        System.out.print("\nbranching to find ways for " + n + " with coins ");
        for (int j = denomIndex; j >= 0; j--) {
            System.out.print(denoms[j] + ",");
        }
        if (denomIndex == 0 && n % denoms[denomIndex] == 0) {
            System.out.println("returning 1");
            return 1;
        } else if (denomIndex == 0) {
            System.out.println("returning 0");
            return 0;
        }
        long ways = 0;
        int nextDenomIndex = 0;
        //find the nextDenom to be used
        if (denomIndex < denoms.length && denomIndex > 0) {
            nextDenomIndex = denomIndex - 1;
        }

        for (int i = 0; i * denoms[denomIndex] <= n; i++) {
            long newAmount = n - i * denoms[denomIndex];
            //check if we already computed this branch
            long newArr[] = new long[nextDenomIndex + 2];//we store the amount and the denominations in an array
            newArr[newArr.length - 1] = newAmount;
            for(int k=0;k<=nextDenomIndex;k++)
                newArr[k] = denoms[k];
            System.out.println("new array is of length:"+newArr.length+" denomIndex is:"+nextDenomIndex+" and contains "+denoms[nextDenomIndex]);
            String key = Arrays.toString(newArr);
            if (!amountMap.containsKey(key)) {
                long tempWays = findWays(newAmount, denoms, nextDenomIndex, amountMap);
                //store the result in map
                amountMap.put(key, tempWays);
                System.out.println("newArr "+Arrays.toString(newArr)+" with amount "+newArr[newArr.length-1]+" not found, putting ways:"+tempWays);
                ways += tempWays;
            }else{
                ways+=amountMap.get(key);
            }
        }

        System.out.println(ways);
        return ways;
    }

    
    
    
    public static void main(String args[]) {
        /**
         * int n = 21; int denom = 25; int ways = makeChange1(n, denom);
         * System.out.println("ways of change for " + n + " is " + ways);
         * List<List<Integer>> changes = new ArrayList<List<Integer>>();
         * makeChange2(n, denom, changes); System.out.println("ways of change
         * for " + n + " is " + changes.size()); for(List<Integer>
         * change:changes){ //coins in one change Integer [] arr = new
         * Integer[change.size()]; arr = change.toArray(arr); Arrays.sort(arr);
         * for(Integer coin:arr){ System.out.print(coin+" "); }
         * System.out.println(""); }
         *
         */
        //long ways = getWays(4, new long[]{1,2,3});
        //long ways = getWays(10, new long[]{2, 5, 3, 6});
        //long ways = getWays(219, new long[] {36, 10 ,42, 7, 50, 1, 49, 24, 37, 12 ,34 ,13 ,39 ,18, 8, 29, 19, 43 ,5 ,44 ,28, 23, 35, 26});//Ans:168312708
        long ways = getWays(250, new long[]{41, 34, 46, 9, 37, 32, 42, 21, 7, 13, 1, 24, 3, 43, 2, 23, 8, 45, 19, 30, 29, 18, 35, 11});//Ans:15685693751;15685693751
        System.out.println("ways are:" + ways);
    }
}
