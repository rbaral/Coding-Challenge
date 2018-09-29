/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.todo.sol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * 
 * Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * 
 * 
 * Solution 1:
 * 1)Count the occurences of each element and store in a HashMap
 * 2)Iterate the hash and for every count, have the elements in an arraylist with the index as the count of the numbers
 * and the values as the list of elements having that count
 * 2)to return k most frequent, we start from the end of the array list and check if the array at that index
 * is greater enough to get the k elements, if not we advance to the next index and so on
 * 
 * 
 * Complexity: O(nlogn); Space: O(n)->when there is one entry for every element in the input array
 * 
 * @author rbaral
 */
public class TopKFrequentElements {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> topK = new ArrayList<Integer>();
        if(nums.length==k){
            Arrays.sort(nums);
            for(int i:nums){
                topK.add(i);
            }
            return topK;
        }
        //count the frequency
        HashMap<Integer,Integer> freqMap = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0)+1);
        }
        //now store the elements based on the count to the corresponding index
        List<List<Integer>> elemCounts = new ArrayList<List<Integer>>();
        //intialize the elemCounts Lists
        for(int i:nums){
            elemCounts.add(new ArrayList<Integer>());
        }
        for(int n:freqMap.keySet()){
            int count = freqMap.get(n);
            List<Integer> curList = elemCounts.get(count-1);
            curList.add(n);
            elemCounts.set(count-1, curList);
        }
        //now let's prepare our top k elements
        for(int i = elemCounts.size()-1; i>=0;i--){
            List<Integer> myList = elemCounts.get(i);
            // the submission requires the larger number with same frequency be added first
            Integer[] n = new Integer[myList.size()];
            n = myList.toArray(n);
            Arrays.sort(n);
            int index= n.length-1;
            while(index>=0 && topK.size()<k){
                topK.add(n[index]);
                index--;
            }
            if(topK.size()==k){
                break;
            }
        }
        return topK;
    }
    
    public static void main(String args[]){
        int arr[] = {1,1,1,2,2,3,3};
        int k =3;
        System.out.println(Arrays.toString(topKFrequent(arr, k).toArray()));
        arr = new int[]{2,1};
        k = 2;
        System.out.println(Arrays.toString(topKFrequent(arr, k).toArray()));
        arr = new int[]{-1,-1};
        k = 1;
        System.out.println(Arrays.toString(topKFrequent(arr, k).toArray()));
    }
}
