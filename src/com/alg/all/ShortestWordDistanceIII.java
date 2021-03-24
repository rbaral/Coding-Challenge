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
This is a follow-up problem of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = "makes", word2 = "makes", return 3.
* 
* 
* Solution 1:
* Proceed as the ShortestDistanceI or ShortestDistanceII and for the case when word1 and word2 are equal, just find the distance between consecutive indices and return the minimum value
* 
 */
public class ShortestWordDistanceIII {
    List<String> words;
    Map<String,List<Integer>> indices = new HashMap<String,List<Integer>>();//stores the indices of the words
    
    public ShortestWordDistanceIII(List<String> wordsList){
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
        if(word1.equals(word2)){
          //if the two words are equal, both indices1 and indices2 will be equal, we just find the minimum distance between the consecutive values
            //as both word1 and word2 are expected to be individual words, we expect the size of indices to be at least 2
            for(int i = 0; i< indices1.size()-1;i++){
                dist = Math.min(dist, Math.abs(indices1.get(i)- indices1.get(i+1)));
            }
            return dist;
        }
        
        
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
        ShortestWordDistanceIII sdist = new ShortestWordDistanceIII(words);
        System.out.println("shortest dist is:"+sdist.shortestDistance(word1, word2));
        word1 = "makes"; word2 = "coding";
        System.out.println("shortest dist is:"+sdist.shortestDistance(word1, word2));
        word1 = "makes"; word2 = "makes";
        System.out.println("shortest dist is:"+sdist.shortestDistance(word1, word2));
    }
}
