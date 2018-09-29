/*
Given two co-ordiantes, find the sum of the points that lie within a bounding rectangle. 
Each co-ordinate has some integer value associated with it.

Solution:
-we have two co-ordinates given, the question is asking about the sum of all the points that are bounded by the 
given two points
-we need to locate the other two points that along with the given two points bound the rectangle

Complexity: O(n^2)
 */
package com.alg.realtest;

import java.util.Arrays;

/**
 *
 * @author rbaral
 */
public class BoundingRectangleSum {
    /**
     * as we are given only two points, we derive the other two points from the combination of the given points
     * the two new points will be (x2, y1) and (x1,y2)
     * @param arr
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @return 
     */
    public static int findBoundedSum(int[][] arr, int x1, int y1, int x2, int y2){
        int sum = 0;
        int minx = Math.min(x1, x2);
        int maxx = x1==minx?x2:x1;
        int miny = Math.min(y1, y2);
        int maxy = y1==miny?y2:y1;
        System.out.println("minx:"+minx+" maxx:"+maxx+" miny:"+miny+" maxy:"+maxy);
        for(int i=0;i<arr.length; i++){//this is x
            for(int j = 0;j<arr[i].length; j++){//this is y
                //we check if this point is within the boundary, it will be within
                //the boundary if it's x falls within the min and max value of x and
                //its y falls within the min and max value of y
                if(i<=maxx && i>=minx && j<=maxy && j>=miny){
                    System.out.println("valid point:"+i+","+j);
                    sum+=arr[i][j];
                }
            }
        }
        return sum;
    }
    public static void main(String args[]){
        int[][] arr = new int[5][5];
        for(int i=0;i<arr.length; i++){
            for(int j=0;j<arr[i].length; j++){
                arr[i][j] = i+j;
            }
            System.out.println(Arrays.toString(arr[i]));
        }
        
        //the x1,y1 and x2,y2 should have different values of x and y else they wont bound a rectangle
        int x1 = 2,y1 =2, x2 =4, y2 = 0;
        int sum = findBoundedSum(arr, x1, y1, x2, y2);
        System.out.println("bounded sum is:"+sum);
    }
}
