/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

/**
 * Given an infinite number of quarters, dimes, nickels, and pennies, find the
 * number of ways to represent n cents
 */
/**
 * this can be solved recursively, e.g., 100 cents = (1 quarter + 75 cents) or
 * (100 cents with 10,5,1 cents) 75 cents = (1 quarter + 50 cents) or (75 cents
 * with 10,5,1 cents) and so on
 */
public class WaysForNCents {

    static int[] denoms = {25, 10, 5, 1};

    /**
     * recursively apply the current denom or pass over to the next indexed
     * denom
     */
    public static int waysFinder(int cents, int denom) {
        if (cents == 0 || denom > denoms.length) {
            return 1;
        }
        if (cents == 1 || denom == denoms.length - 1) {//we are only left with 1 cents or with 1 denom
            return 1;
        }
        if (denoms[denom] > cents) {
            //check with next denom
            return waysFinder(cents, denom + 1);
        }
        int usingCurrentDenom = waysFinder(cents - denoms[denom], denom);
        int notUsingCurrentDenom = waysFinder(cents, denom + 1);
        return usingCurrentDenom + notUsingCurrentDenom;

    }

    public static void main(String args[]) {
        int cents = 25;
        int ways = waysFinder(cents, 0);
        System.out.println("ways for:" + cents + " is " + ways);
    }
}
