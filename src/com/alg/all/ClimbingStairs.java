/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
* 
* Solution:
* 
* We solve by induction:
* 0 = {}
* 1 = {1}
* 2 = {1, 1}, {2}
* 3 = {1, 1, 1}, {1,2}, {2,1}
* 4 = {1, 1, 1, 1}, {1, 1, 2}, {1, 2, 1}, {2, 2}, {2, 1, 1}
* 5 = {1, 1, 1, 1, 1}, {1, 1, 1, 2}, {1, 2, 2}, {1, 2, 1, 1}, {2, 2, 1}, {2, 1, 2}, {1, 1, 2, 1}, {2, 1, 1, 1}
* 
* This looks like a fibonacci series: {1, 2, 3, 5, 8...}
* 
* So, we can use f(n) ways to climb the stairs where f(n) is the nth fibonacci term
* 
 * @author rbaral
 */
public class ClimbingStairs {
    public static int climbStairs(int n) {
        //base cases
        if(n<=1)
            return 1;
        Map<Integer, Integer> ways = new HashMap<Integer, Integer>();
        ways.put(0, 1);
        ways.put(1, 1);
        return findWays(ways, n);
    }
    
    static int findWays(Map ways, int n){
        if(ways.containsKey(n)){
            return (int)ways.get(n);
        }else{
            int way = findWays(ways, n-1)+ findWays(ways, n-2);
            ways.put(n, way);
        }
        return (int)ways.get(n);
    }
    
    public static void main (String args[]){
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(44));
    }
}
