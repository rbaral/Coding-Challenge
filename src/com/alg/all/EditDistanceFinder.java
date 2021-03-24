/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

/**
 * Sequence alignment: Given two strings, find the edit distance between them.
 * The edit distance consists of : - substituiting one char by another, -
 * removing one char from one string - adding one char to one of the strings
 *
 * Sol: -can be solved usign dynamic programming complexity: O(mn)
 */
public class EditDistanceFinder {

    public static int findSequenceAlignDistance(String a, String b) {
        int dist = 0;
        int[][] opt = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) {
            opt[i][0] = i;
        }

        for (int i = 0; i <= b.length(); i++) {
            opt[0][i] = i;
        }

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                //we assume same cost for add, delete, substitute operation
                if (a.charAt(i-1)== b.charAt(j-1)) {//if the chars at earlier position match
                    opt[i][j] = opt[i - 1][j - 1];
                } else {
                    opt[i][j] = 1 + Math.min(opt[i - 1][j - 1], Math.min(opt[i - 1][j], opt[i][j - 1]));
                }
            }
        }
        //the min distance will be in the last index of opt
        dist = opt[a.length()][b.length()];
        return dist;
    }

    public static void main(String args[]) {
        String a = "ocurrance";
        String b = "occurrence";
        int dist = findSequenceAlignDistance(a, b);
        System.out.println("edit distance of :" + a + " and " + b + " is:" + dist);
    }
}
