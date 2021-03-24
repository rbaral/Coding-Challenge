/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics;

import java.util.HashMap;
import java.util.Map;

/**
 *Variant: Assuming that keys take one of three values, reorder the array so that all objects with the
same key appear together. The order of the subarrays is not important. For example, [1,1,1,2,2,3,3,3] and [2,2,1,1,1,3,3,3] and [3,3,3,1,1,1,2,2]
* and so on are valid answers. 
* Use O(1) additional space and O(n) time
* 
* Solution 1:
* 1) scan the array and store the element,count in a map
* 2) iterate through the keys of the elements and replace the value of the original array by the item from the map
* 
* Complexity: O(n)
* Space: O(1) - the size of hash is equal to the number of unique elements (=3 in our case)
* 
 * @author rbaral
 */
public class ArraysThreeKeysSorting {
    
    public static int[] getOrderedArray(int[] a){
        //first find the max of them and make it pivot and put every value smaller than it to the left and others to the right
        Map<Integer,Integer> countMap = new HashMap<Integer, Integer>();
        for(Integer aa:a){
            if(!countMap.containsKey(aa)){
                countMap.put(aa, 0);
            }
            countMap.put(aa, countMap.get(aa)+1);
        }
        //now iterate through the keys of the map and overwrite the given array
        int arrIndex = 0;
        for(Integer aa: countMap.keySet()){
            int count = countMap.get(aa);
            int i = 0;
            while(i<count){
                a[arrIndex] = aa;
                i++;
                arrIndex++;
            }
        }
        return a;
    }
    
    public static void main(String args[]){
        System.out.println("main started");
        int a[] = {1,2,1,3,3,2,1,1};
        a = getOrderedArray(a);
        System.out.println("\n");
                System.out.println("after sorting\n");
        for(Integer aa:a){
            System.out.print(aa);
        }
        System.out.println();
    }
}
