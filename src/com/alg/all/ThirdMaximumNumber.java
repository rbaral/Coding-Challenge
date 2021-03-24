/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.todo.sol;

import java.util.Arrays;

/**
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
* 
* Solution 1:
* 1)Sort the array
* 2)if the array has less than 3 elements, return the maximum in the array
* 3) else scan from the right to find the third maximum unique element and return it
* 
* Complexity: O(logn) for sorting and O(n) for scanning from the right to find the third largest
* 
* Solution 2:
* 1)Scan the array and store three unique elements
* 2)for every new element encountered, check if it is greater than either of them, if so replace the stored element with this one
* 3)every time, the stored elements will be three unique elements, when the scanning is finished these will be the three largest elements
* 4)return the smallest among these
* 
* Complexity: O(n)
 *
 * @author rbaral
 */
public class ThirdMaximumNumber {
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int uniqueElemCount = 1;
        for(int i= nums.length-2;i>=0;i--){
            if(nums[i]!=nums[i+1]){
                uniqueElemCount++;
            }
            if(uniqueElemCount==3){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
    
    public static void main(String args[]){
        int nums[] = {1,2,5,9,12,19,16,16};
        System.out.println(thirdMax(nums));
        nums = new int[]{1};
        System.out.println(thirdMax(nums));
    }
}
