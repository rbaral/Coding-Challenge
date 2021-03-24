/*
Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.

Insert
Remove
Replace
All of the above operations are of equal cost.

Examples:

Input:   str1 = "geek", str2 = "gesek"
Output:  1
We can convert str1 into str2 by inserting a 's'.

Input:   str1 = "cat", str2 = "cut"
Output:  1
We can convert str1 into str2 by replacing 'a' with 'u'.

Input:   str1 = "sunday", str2 = "saturday"
Output:  3
Last three and first characters are same.  We basically
need to convert "un" to "atur".  This can be done using
below three operations. 
Replace 'n' with 'r', insert t, insert a




Solution:

 */
package com.alg.dp;

import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author rbaral
 */
public class EditDistance {

    /**
     * this method has exponential time complexity as it performs the same
     * operation multiple times. We can get slightly better performance with
     * memoization.
     *
     * @param x
     * @param y
     * @return
     */
    public static int getEditDistanceTopDown(String x, String y, Map<String, Integer> distMap) {
        //base case
        if (x.length() == 0) {
            return y.length();
        }
        if (y.length() == 0) {
            return x.length();
        }
        //compare the first character
        if (x.charAt(0) == y.charAt(0)) {
            String key = x.substring(1) + "," + y.substring(1);
            if (!distMap.containsKey(key)) {
                distMap.put(key, getEditDistanceTopDown(x.substring(1), y.substring(1), distMap));
            }
            return distMap.get(key);

        } else {
            String key1 = x.substring(1) + "," + y.substring(1);
            String key2 = x + "," + y.substring(1);
            String key3 = x.substring(1) + "," + y;

            if (!distMap.containsKey(key1)) {
                distMap.put(key1, getEditDistanceTopDown(x.substring(1), y.substring(1), distMap));
            }
            if (!distMap.containsKey(key2)) {
                distMap.put(key2, getEditDistanceTopDown(x, y.substring(1), distMap));
            }
            if (!distMap.containsKey(key3)) {
                distMap.put(key3, getEditDistanceTopDown(x.substring(1), y, distMap));
            }
            return 1 + Math.min(distMap.get(key1),
                    Math.min(distMap.get(key2),
                            distMap.get(key3)));
        }

    }

    public static int getEditDistanceBottomUp(String x, String y) {
        //lets create an auxiliary array to store the edit distances
        int[][] dist = new int[x.length() + 1][y.length() + 1];
        for (int i = 0; i <= x.length(); i++) {

            for (int j = 0; j <= y.length(); j++) {
                if (i == 0) {
                    dist[i][j] = j;
                } else if (j == 0) {
                    dist[i][j] = i;
                } else if (x.charAt(i - 1) == y.charAt(j - 1)) {//nothing required to do, just proceed with the shorter string
                    dist[i][j] = dist[i - 1][j - 1];
                } else {
                    //need to find the minimum among the insert, replace, and remove operations
                    dist[i][j] = 1 + Math.min(dist[i][j - 1], Math.min(dist[i - 1][j], dist[i - 1][j - 1]));
                }
            }
        }
        return dist[x.length()][y.length()];
    }

    public static void main(String args[]) {
        String str1 = "ocurrance";//sunday";
        String str2 = "occurrence";//saturday";
        int lengthBottomUp = getEditDistanceBottomUp(str1, str2);
        System.out.println("edit distance bottom up:" + lengthBottomUp);
		Map<String, Integer> distMap = new HashMap<String, Integer>();
        int lengthTopDown = getEditDistanceTopDown(str1, str2, distMap);
        System.out.println("edit distance top down:" + lengthTopDown);
    }
}
