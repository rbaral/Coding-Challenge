/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.locked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author rbara012
 * 
 * Print all unique combination of factors (except 1) of a given number.

For example:
Input: 12
Output: [[2, 2, 3], [2, 6], [3, 4]]
Input: 15
Output: [[3, 5]]
Input: 28
Output: [[2, 2, 7], [2, 14], [4, 7]]
* 
* Solution:
* 
 * 
 */
public class FactorCombinations {
    
    public static List<List<Integer>> getFactors(int n){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        getFactorsDFS(n, res, cur, 1, 2); //2 is for start because 1 is not included in the factors, 1 is for the product so far
        return res;
    }
    
    public static void getFactorsDFS(int n, List<List<Integer>> res, List<Integer> cur, int prod, int start){
        if(start>n || prod>n){
            return;
        }
        if(prod==n){//we reached the prodcut with the factors in cur, so just add the cur as one of the factors set
            List<Integer> temp = new ArrayList<Integer>(cur);
            res.add(temp);
            return;
        }
        //iteratively use the factors from the start position till the given number
        for(int i=start;i<n;i++){
            if(prod*i>n) break; //if the product so far and the current factor exceeds the given number then we dont need to include this factor
            if(n%i==0){//if this number can be a factor of the given target number
                cur.add(i);
                getFactorsDFS(n, res, cur, prod*i, i);
                cur.remove(cur.size()-1);//remove the lastly added factor because it was just used in the recursion
            }

        }
        
    }
    
    public static void main(String args[]){
        List<List<Integer>> factorsList = getFactors(56);
        for(List<Integer> l: factorsList){
            System.out.println("factors:"+Arrays.toString(l.toArray()));
        }
    }
    
}
