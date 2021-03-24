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
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

* For example, the numbers "69", "88", and "818" are all strobogrammatic.
* 
Write a function to determine strobogrammatic numbers of length n.
* For n= 2, the function should return ["11","69","88","96"].
* 
* Solution 1:
* 1) prepare the hash map for the pair of the strobogrammatic numbers
* 2)Recursively, use the pairs as the starting and ending char and for the middle portion, find the strobogrammatic number of length n-2
* 2 a) break the recursion


 */
public class StrobogrammaticNumberII {
    
    public static List<String> findStos(int n, List<String> res){
        if(n==0){
            return new ArrayList<String>();
        }else if(n==1){
            List<String> temp = new ArrayList<String>();
            temp.add("1");temp.add("0"); temp.add("8");
            return temp;
        }else if(n==2){
            List<String> temp = new ArrayList<String>();
            temp.add("11");temp.add("69"); temp.add("88");temp.add("96");temp.add("00");
            return temp;
        }
        else{
            List<String> temp = findStos(n-2, res);
            int len = temp.size();
            for(int i=0;i<len;i++){
                String s = temp.get(0);
                String s1 = "1" +s+"1";
                String s2 = "8" +s+"8";
                String s3 = "6" +s+"9";
                String s4 = "9" +s+"6";
                String s5 = "0" +s+"0";
                temp.add(s1);
                temp.add(s2);
                temp.add(s3);
                temp.add(s4);
                temp.add(s5);
                temp.remove(0);//remove the one with less chars because we used it to build the number of length n
            }
            res = temp;
        }
        return res;
    }
    
    public static void main(String args[]){
        List<String> res = new ArrayList<String>();
        int n = 4;
        res = findStos(n, res);
        System.out.println("stros of length:"+n+" are:"+Arrays.toString(res.toArray()));
    }
}
