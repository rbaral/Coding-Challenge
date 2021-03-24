/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.locked;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author rbara012
 * 
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
* 
* 
* Ref: http://www.programcreek.com/2014/05/leetcode-nested-list-weight-sum-java/
* 
 */
public class NestedListWeightSum {
    
    public int depthSumRecursive(List<NestedInteger> nestedList){
     
        return depthSumHelper(nestedList, 1); //initial depth is 1
    }
    
    public int depthSumHelper(List<NestedInteger> nestedList, int depth){
        if(nestedList==null || nestedList.size()==0){
            return 0;
        }
        int sum = 0;
        for(NestedInteger i: nestedList){
            if(i.isInteger()){
                sum+=i.getInteger()*depth;
            }else{
                sum+= depthSumHelper(i.getList(), depth+1);
            }
        }
        return sum;
    }
    
    
    
    /**
     * the next one is iterative solution
     */
    
    public int depthSum(List<NestedInteger> nestedList){
        //add the elements and their default depth to a list
        
        LinkedList<NestedInteger> items = new LinkedList<NestedInteger>();
        LinkedList<Integer> depths = new LinkedList<Integer>();
        int sum = 0;
        
        //add the items and the default depth in their linked lists
        for(NestedInteger i:nestedList){
            items.offer(i);
            depths.offer(1);
        }
        
        //now iterate through the elements and find the sum
        while(!items.isEmpty()){
            NestedInteger item = items.poll();
            int depth = depths.poll();
            
            if(item.isInteger()){//if this is an integer
                sum+=depth*item.getInteger();
            }else{//if this is a list
                for(NestedInteger ii:item.getList()){
                    items.offer(ii);
                    depths.offer(depth+1);
                }
            }
        }
        return sum;
    }
    
}
