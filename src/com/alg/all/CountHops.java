/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

/**
 * A child can take 1, 2, or 3 steps at a time. How many ways can she can move
 * to climb the stairs with n steps?
 */
/**
 * one solution is to use the recursion, e.g., the number of ways to reach the
 * last spot is to take 3 steps from (n-3) step, or take 2 steps from (n-2)
 * step, or take 1 step from (n-1) step. So, the number of ways to hit the
 * destination is the number of ways one can reach these three steps.
 */
public class CountHops {

    //complexity is exponential (3^n)
    public static int getWaysRecursive(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return getWaysRecursive(n - 1) + getWaysRecursive(n - 2) + getWaysRecursive(n - 3);
        }
    }

    //we can use dynamic programing to solve it in a better way. We can memoize the computation
    //and use later, rather than recomputing the same value again and again
    public static int getWaysDP(int[] mem, int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (mem[n-1] > -1) {
            return mem[n-1];
        } else {
            mem[n-1] = getWaysDP(mem, n - 3) + getWaysDP(mem, n - 2) + getWaysDP(mem, n - 1);
            return mem[n-1];
        }
    }

    public static void main(String args[]) {
        CountHops cways = new CountHops();
        int stairSize = 20;
        int[] mem = new int[stairSize];
        for (int i = 0; i < mem.length; i++) {
            mem[i] = -1;
        }
        System.out.println(cways.getWaysDP(mem, stairSize));
        System.out.println(cways.getWaysRecursive(stairSize));

    }

}
