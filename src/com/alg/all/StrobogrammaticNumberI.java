/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.locked;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rbara012
 * 
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.
* 
* Solution 1:
* 1)Make a map as key,value for the number and its strobogrammatic value
* 2)Initialize two pointers p1 pointing to first and p2 pointing to last char of the input number
* 3)Scan through the chars and check if the char at p1 is strobogrammatic of char at p2, check if the char at p1 and char at p2 are valid keys in the map
* 4)repeat 3 till p1<=p2 or (3) fails
* 
* Complexity: O(n/2) for scanning the array; Space: O(1) to store the strobogrammatic pairs
 * 
 */
public class StrobogrammaticNumberI {
    
    public static boolean isStrobo(int n){
        //store the pairs in a hash
        Map<Character,Character> pairs = new HashMap<Character,Character>();
        pairs.put('9', '6');
        pairs.put('6', '9');
        pairs.put('1', '1');
        pairs.put('8', '8');
        String num = String.valueOf(n);
        int p1 = 0, p2 = num.length()-1;
        while(p1<=p2){
            if(!pairs.containsKey(num.charAt(p1)) 
                    || !pairs.containsKey(num.charAt(p2)) 
                    || num.charAt(p1)!=pairs.get(num.charAt(p2))){
                return false;
            }
            p1++;p2--;
        }
        return true;
    }
    
    public static void main(String args[]){
        int n = 619;
        System.out.println("isstrobo "+n +" "+isStrobo(n));
    }
}
