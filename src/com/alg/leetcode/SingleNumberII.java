/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

/**
 *
 * @author rbara012
 * 
 * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
* 
* Solution 1:
* 1)Use hashmap to store the count and then find the one that has just one occurence
* 
* Complexity: O(n); Space O(n)
* 
* Solution 2:
* Ref: http://www.geeksforgeeks.org/find-the-element-that-appears-once/
* 
* The idea is to use bitwise operators for a solution that is O(n) time and uses O(1) extra space. The solution is not easy like other XOR based solutions, because all elements appear odd number of times here. The idea is taken from here.

Run a loop for all elements in array. At the end of every iteration, maintain following two values.

ones: The bits that have appeared 1st time or 4th time or 7th time .. etc.

twos: The bits that have appeared 2nd time or 5th time or 8th time .. etc.

Finally, we return the value of ‘ones’

How to maintain the values of ‘ones’ and ‘twos’?
‘ones’ and ‘twos’ are initialized as 0. For every new element in array, find out the common set bits in the new element and previous value of ‘ones’. These common set bits are actually the bits that should be added to ‘twos’. So do bitwise OR of the common set bits with ‘twos’. ‘twos’ also gets some extra bits that appear third time. These extra bits are removed later.
Update ‘ones’ by doing XOR of new element with previous value of ‘ones’. There may be some bits which appear 3rd time. These extra bits are also removed later.

Both ‘ones’ and ‘twos’ contain those extra bits which appear 3rd time. Remove these extra bits by finding out common set bits in ‘ones’ and ‘twos’.
* 
* 
 */
public class SingleNumberII {
    
    public static int singleNumber(int[] nums) {
       if(nums==null||nums.length<1){
           return -1;
       }
       int ones = 0, twos = 0;
       int comonMask;
       for(int i=0;i<nums.length;i++){
           /* The expression "one & nums[i]" gives the bits that are
           there in both 'ones' and new element from nums[].  We
           add these bits to 'twos' using bitwise OR
            */
           twos = twos|(ones & nums[i]);
           /* XOR the new bits with previous 'ones' to get all bits
           appearing odd number of times
           */
           ones  = ones ^ nums[i];
           /* The common bits are those bits which appear third time
           So these bits should not be there in both 'ones' and 'twos'.
           common_bit_mask contains all these bits as 0, so that the bits can 
           be removed from 'ones' and 'twos'  */
           comonMask = ~(ones & twos);
           
           /* Remove common bits (the bits that appear third time) from 'ones'*/
           ones&=comonMask;
           /* Remove common bits (the bits that appear third time) from 'twos'*/
           twos&=comonMask;
           
       }
       return ones;
    }
    
    public static void main(String args[]){
        int a[] = {1,2,1,1,2,2,5,5,5};
        System.out.println("number is:"+singleNumber(a));
    }
}
