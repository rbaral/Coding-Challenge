/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.locked;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rbaral
 * 
 * 
 * Given a string, we can "shift" each of its letter to its successive letter, 
 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence: "abc" -> "bcd" -> ... -> "xyz".

Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence, return:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]

 * Solution 1:
 * 1)For every inner list, we find the difference between consecutive chars
 * 2) make the pattern of difference a key and the input string as the value and put into map
 * 3)sort the values of the map before returning
 * 
 * Complexity: O(nk) where k is the number of chars in a string; Space: O(n)
 * 
 * 
 * 
 * Ref:https://discuss.leetcode.com/topic/20823/4ms-easy-c-solution-with-explanations
 * 
 */
public class GroupShiftedStrings {
    
    public List<List<String>> groupStrings(List<String> params){
        Map<String,List<String>> maps = new HashMap<String,List<String>>();
        List<List<String>> groups = new ArrayList<List<String>>();
        for(String s: params){//for every string in the input list
            StringBuffer tempBuf=new StringBuffer();
            for(int i=1;i<s.length();i++){
                int diff = (int)(s.charAt(i) - s.charAt(i-1));
                if(diff<0){//if the string is in decreasing alphabetic order
                    diff+=26;
                }
                tempBuf.append('a'+diff);
            }
            String temp = tempBuf.toString();
            if(!maps.containsKey(temp)){
                maps.put(temp, new ArrayList<String>());
            }
            maps.get(temp).add(s);
        }
        for(Map.Entry<String, List<String>> items: maps.entrySet()){
            Collections.sort(items.getValue());
        }
        groups.addAll(maps.values());
        return groups;
    }
    
    
    public static void main(String args[]){
        
    }
    
}
