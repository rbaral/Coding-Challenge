/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

/**
 * A robot is on the top left corner (0,0) of a X*Y grid and can only move one
 * step right or down at a time. How many ways it can move to get to (X,Y)?
 */
/**
 * Sol- We can take the problem from backward, i.e. how many ways can it get
 * back from (X,Y), by moving one step left or one step up and do the recursive
 * or dynamic programing solution.
 */
public class RobotNavigation {

    private static int x_left = 0;
    private static int y_left = 0;
    private static int x_right = 10;
    private static int y_right = 10;

    //find the number of ways to get to point
    public static int getWaysRecursive(int x, int y) {
        if (x < 0 || y < 0) {
            return 0;
        } else if (x == 0 && y == 0) {
            return 1;
        } else {
            return getWaysRecursive(x - 1, y) + getWaysRecursive(x, y - 1);
        }
    }

    public static int getWaysDP(int[][] ways, int x, int y) {
        //System.out.println("val of x is:"+x+" y is:"+y);
        if (x < 0 || y < 0) {
            return 0;
        } else if (x == 0 || y == 0) {
            return 1;
        } else if (ways[x-1][y-1]!= -1) {
            return ways[x-1][y-1];
        } else {
            ways[x-1][y-1] = getWaysDP(ways, x - 1, y) + getWaysDP(ways, x, y - 1);
            return ways[x-1][y-1];
        }
    }

    public static void main(String[] args) {
        int[][] ways = new int[10][10];//number of ways to reach 0,0 from 10,10
        for (int i = 0; i < ways.length; i++) {
            for (int j = 0; j < ways[0].length; j++) {
                ways[i][j] = -1;
            }
        }
        System.out.println("number of ways:"+getWaysRecursive(x_right, y_right));
        System.out.println("number of ways:"+getWaysDP(ways, x_right, y_right));
    }

}
