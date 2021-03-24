/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.locked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rbara012
 * 
 * 
 * This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

For example,

Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = "coding”, word2 = "practice”, return 3. Given word1 = "makes", word2 = "coding", return 1.

Note
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 * 
 */
public class ShortestWordDistanceII {
    
    List<String> words;
    Map<String,List<Integer>> indices = new HashMap<String,List<Integer>>();//stores the indices of the words
    public ShortestWordDistanceII(List<String> wordsList){
        this.words = wordsList;
        for(int i=0;i<words.size();i++){
            String word = words.get(i);
            if(indices.containsKey(word)){
               indices.get(word).add(i);
            }else{
                List<Integer> indList = new ArrayList<Integer>();
                indList.add(i);
                indices.put(word, indList);
            }
        }
    }
    
    int shortestDistance(String word1, String word2){
        //get the indices of the two words
        List<Integer> indices1 = indices.get(word1);
        List<Integer> indices2 = indices.get(word2);
        int dist = Integer.MAX_VALUE;
        int p1 = 0, p2=0;
        while(p1<indices1.size() && p2<indices2.size()){
            dist = Math.min(dist, Math.abs(indices1.get(p1) - indices2.get(p2)));
            //now if index1 is still smaller than index2, we just advance index1 so that we might get smaller distance
            if(indices1.get(p1)<indices2.get(p2)){
                p1++;
            }else{
                p2++;
            }
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
        ShortestWordDistanceII sdist = new ShortestWordDistanceII(words);
        System.out.println("shortest dist is:"+sdist.shortestDistance(word1, word2));
        word1 = "makes"; word2 = "coding";
        System.out.println("shortest dist is:"+sdist.shortestDistance(word1, word2));
    }
}
