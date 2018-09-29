/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

import java.util.Arrays;

/**
 *
 * The longest common subsequence (LCS) problem is the problem of finding the longest subsequence common to all sequences 
 * in a set of sequences (often just two sequences). It differs from problems of finding common substrings: 
 * unlike substrings, subsequences are not required to occupy consecutive positions within the original sequences.
 * 
 * For e.g., given two strings {A, B, C, B, D, A, B} and {B, D, C, A, B, A}, the longest common subsequence of these two
 * string will be {B, C, B, A}, {B, D, A, B} as both of them have length of 4
 * 
 * Write a function to find the longest common subsequence for given strings
 * 
 * Solution 1:
 * 
 * 
 * @author rbaral
 */
public class LongestCommonSubsequence {
    public static int findLCS(String a, String b){
        if(a.length()==0 || b.length()==0){
            return 0;
        }
        //lets create an array of size a.length*b.length
        int[][] c = new int[a.length()+1][b.length()+1];
        for(int i=0; i<a.length()+1;i++){
            for(int j=0;j<b.length()+1;j++){
                //if i=0 or j = 0 then c = 0
                if((i==0 || j==0)){
                    c[i][j] = 0;
                }else if(a.charAt(i-1)==b.charAt(j-1)){
                    c[i][j] = c[i-1][j-1] +1;
                    System.out.println("matched "+a.charAt(i-1)+" and:"+b.charAt(j-1)+" at:"+(i-1)+" "+(j-1));
                }else{
                    c[i][j] = Math.max(c[i-1][j], c[i][j-1]);
                }
            }
        }
        for(int i =0;i<a.length()+1;i++)
            System.out.println(Arrays.toString(c[i]));
        return c[a.length()][b.length()];
    }
    
    public static void main(String args[]){
        String a = "ABCBDAB";
        String b =  "BDCABA";
        System.out.println("LCS is:"+findLCS(a, b));
    }
}
