/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
 
 Solution 1:
 -can be solved using DP
 - Let X(1...m) and Y(1...n) be the two sequences and Z be the common subsequence, we have the following:
 -if Xm = Yn then Z is the common subsequence of X and Y
 - if Xm<> Yn and Xm=Zk then X(1...m) and Y(1...n-1) are subsequence of Z
 - if Xm<>Yn and Yn=Zk then X(1...m-1) and Y(1...n) are subsequence of Z
 
 
 
 */
package com.alg.dp;

import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author rbaral
 */
public class LongestCommonSubsequence {

    /**
     * this recursion approach solves the problem in O(2^n) time complexity in
     * worst case because we solve the same smaller subproblems multiple times
     * which entails extra computing We can use memoization to get a better
     * result
     *
     * @param x
     * @param y
     * @return
     */
    public static int getCommonSubsequenceLengthTopDown(String x, String y, Map<String, Integer> lcsMap) {
        //base cases
        if (x.length() == 0 || y.length() == 0) {
            return 0;
        }
        //if last char of both match
        if (x.charAt(x.length() - 1) == y.charAt(y.length() - 1)) {
            String key = x.substring(0, x.length() - 1) + "," + y.substring(0, y.length() - 1);
            if (!lcsMap.containsKey(key)) {
                int length = getCommonSubsequenceLengthTopDown(x.substring(0, x.length() - 1), y.substring(0, y.length() - 1), lcsMap);
                lcsMap.put(key, length);
            }
            return 1 + lcsMap.get(key);
        } else {
            String key1 = x.substring(0, x.length() - 1) + "," + y;
			String key2 = x + "," + y.substring(0, y.length() - 1);
            if (!lcsMap.containsKey(key1)) {
                int length = getCommonSubsequenceLengthTopDown(x.substring(0, x.length() - 1), y, lcsMap);
                lcsMap.put(key1, length);
            }
            if (!lcsMap.containsKey(key2)) {
                int length = getCommonSubsequenceLengthTopDown(x, y.substring(0, y.length() - 1), lcsMap);
                lcsMap.put(key2, length);
            }
            return Math.max(lcsMap.get(key1), lcsMap.get(key2));
        }
    }

    /**
     * In this approach we use a table to store the length of subsequence if the
     * item of corresponding indices are considered. Complexity is O(mn)
     * 
     * Following is detailed algorithm to print the LCS. It uses the same 2D table L[][].

1) Construct L[m+1][n+1] using the steps discussed in previous post.

2) The value L[m][n] contains length of LCS. Create a character array lcs[] of length equal to the length of lcs plus 1 (one extra to store \0).

2) Traverse the 2D array starting from L[m][n]. Do following for every cell L[i][j]
…..a) If characters (in X and Y) corresponding to L[i][j] are same (Or X[i-1] == Y[j-1]), then include this character as part of LCS.
…..b) Else compare values of L[i-1][j] and L[i][j-1] and go in direction of greater value.
     *
     * @param x
     * @param y
     * @return
     */
    public static int getCommonSubsequenceLengthBottomUp(String x, String y) {
        //lets create a 2-d array to store the length of longest subsequence
        int lcs[][] = new int[x.length() + 1][y.length() + 1];//to store the length when mth and nth character are used from x and y

        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0 || j == 0) {
                    lcs[i][j] = 0;
                } else if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        //find the maximum value among all the subsequences

        return lcs[x.length()][y.length()];

    }

    public static void main(String args[]) {
        String x = "AGGTAB";
        String y = "GXTXAYB";
        //we use memoization on topdown approach
        Map<String, Integer> lcsMap = new HashMap<String, Integer>();
        int lcsLength = getCommonSubsequenceLengthTopDown(x, y, lcsMap);
        System.out.println("longest subsequence is of length" + lcsLength);
        int lcsLengthBottomUp = getCommonSubsequenceLengthBottomUp(x, y);
        System.out.println("longest subsequence is of length" + lcsLengthBottomUp);

    }

}
