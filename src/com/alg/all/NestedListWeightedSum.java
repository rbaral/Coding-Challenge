/*
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
 */
package com.alg.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author rbaral
 * 
 * Solution 1: Recursive approach
 * 
 * We recursively call the helper method that finds the sum of the Integer or the NestedInteger type
 * 
 * Complexity: O(d), where d is the maximum depth of the nested list
 * 
 * Solution 2: Iterative appraoch
 * 1) We iterate the nested list and store every element to a queue, we also assume depth 1 of this item and store the depth in another queue
 * 2) We pop the elements from the item queue and 
 * 2 a) if it is an integer, we apply the depth from the depth queue
 * 2 b) if it is a list, we enqueue this item to the queue and add depth=depth+1 for this item in the depth queue
 * 3) we repeat this process till the item queue is non-empty
 * 
 * Complexity: 
 * O(n) to iterate the original list and put the items to the queue
 * O(n + dk), where d is the max depth of k elements
 * 
 * total complexity is O(n +dk)
 * 
 */
public class NestedListWeightedSum {
    
    public int recursiveSum(List<NestedInteger> nestedList){
        
        return helperMethod(nestedList, 1); //call the helper method with a default depth of 1
    }
    
    public int helperMethod(List<NestedInteger> nestedList, int depth){
        int sum = 0;
        if(nestedList==null || nestedList.size()==0){
            return 0;
        }
        
        for(NestedInteger nestInt:nestedList){
            if(nestInt.isInteger()){
                sum+= nestInt.getInteger()*depth;
            }else{
                sum+= helperMethod(nestInt.getList(), depth+1);
            }
        }
        return sum;
    }
    
    
    //iterative method
    
    public int iterativeSum(List<NestedInteger> nestedList){
        //create two queues to store the item and depth
        LinkedList<NestedInteger> itemQueue = new LinkedList<NestedInteger>();
        LinkedList<Integer> depthQueue = new LinkedList<Integer>();
        //now add the items and depth to the relevant queues
        for(NestedInteger nestInt:nestedList){
            itemQueue.offer(nestInt);
            depthQueue.offer(1);// the default depth is 1 for the first time
        }
        
        //now iterate the items in the queue and calculate the sum
        int sum = 0;
        while(itemQueue.size()>0){
            //get the item in front and if Integer calculate sum, else append to the end of this queue
            NestedInteger nestInt = itemQueue.poll();
            Integer depth = depthQueue.poll();
            if(nestInt.isInteger()){
                sum+= nestInt.getInteger()*depth;
            }else{
                //this is again a list, so append back to the queue
                for(NestedInteger nes:nestInt.getList()){
                    itemQueue.offer(nes);
                    depthQueue.offer(depth+1);
                }
            }
        }
        return sum;
    }
}
