/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.locked;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rbara012
 * 
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = "coding", word2 = "practice", return 3. Given word1 = "makes", word2 = "coding", return 1.

Note
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
* 
* The tricky part is there can be multiple occurences of the words and either of them can occur first in the array
* 
* Solution 1:
* 1)Initialize two indices p1 and p2 to -1, p1 will point to the index of word1 and p2 will point to the index of word2, initialize distance to arbitrarily large value
* 2)Scan the array for the words
* 2 a) if word1 is found or word2 is found update the index
* 2 b) if both indices are set, check if smaller value for distance is found, if so, update the distance 
* Complexity: O(n)
 * 
 */
public class ShortestWordDistance {
    
    public static int shortestDistance(List<String> words, String word1, String word2){
        int p1 = -1, p2 = -1;
        int dist = Integer.MAX_VALUE;
        for(int i=0;i<words.size();i++){
            if(words.get(i).equals(word1)){
                p1 = i;
            }else if(words.get(i).equals(word2)){
                p2 = i;
            }
            //if both indices are valid indices, we update the distance
            if(p1!=-1 && p2!=-1)
                dist = Math.min(dist, Math.abs(p1-p2));
        }
        return dist;
    }
    
    public static void main(String args[]){
        List<String> words = new ArrayList<String>();
        words.add("practice");
        words.add("makes");
        words.add("perfect");
        words.add("coding");
        words.add("makes");
        String word1 = "coding", word2 = "practice";
        System.out.println("distance is:"+shortestDistance(words, word1, word2));
        word1 = "makes"; word2 = "coding";
        System.out.println("distance is:"+shortestDistance(words, word1, word2));
        
    }
}
