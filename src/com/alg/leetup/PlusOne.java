/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

/**
 *
 * Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
* 
* Solution 1:
* 
* 0) handle base cases where arr1 is null, has just one element and so on
* 1)create an array arr2 of same size as of the arr1 and have its last element 1 rest 0s
* 2)iterate through the size or arr1 from the last element and add the elements at that position in the two arrays
* 2 a) the sum will be retained in this position
* 2 b) the carry will be transferred to the next position
* 3) if both arrays are exhausted and still carry is 1, then create a new array of size arr1.length +1 and copy the
* carry to position 0 and the rest of elements of arr1 from index 1 onwards
* 4) return the sum array
 * 
 * 
 * @author rbaral
 */
public class PlusOne {
    
}
