/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics;

/**
 *
 * find all pairs that add up to a certain value in an array
 * 
 * Solution 1:
 * Use two nested loops and check if every pair give the sum
 * 
 * complexity: O(n^2)
 * 
 * 
 * Solution 2:
 * 1)Sort the given numbers : O(nlogn)
 * 2)have two pointers: p1 pointing to 0 and p2 pointing to arr.length-1
 * 3)repeat while p1<=p2
 * 3 a) if arr[p1] + arr[p2]> sum, p2--
 * 3 b) if arr[p1] + arr[p2]< sum, p1++
 * 3 c) if arr[p1] + arr[p2] == sum
 *      i) if(p1< p2 && arr[p1] == arr[p1+1]) then p1++ //to handle duplicates
 *      ii) else if(p2>p1 && arr[p2]==arr[p2-1]) then p2-- //to handle duplicates
 *      iii) else p1++, p2--
 * 
 * Complexity: O(nlogn + n)
 * 
 * Sol 3: Use hashmap to store every items, and in the second iteration of the array,
 * check if we find a difference that forms the given sum
 * 
 * Complexity: O(n), Space: O(n)
 * 
 * 
 * @author rbaral
 */
public class PairsToSumArray {
    
}
