/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
* 
* Solution 1:
* 1)Use brute force to iterate over all the chars and check if it is 1 and keep record of the count
* 
* time complexity = O(n)= O(32)
* 
* Solution 2:
* 1)Use binary approach, using a mask bit for each position and shifting the mask for every position
* Ref:http://stackoverflow.com/questions/109023/how-to-count-the-number-of-set-bits-in-a-32-bit-integer
* https://leetcode.com/articles/number-1-bits/
* 
* time complexity: O(n)
 *
 * @author rbaral
 */
public class NumberOf1Bits {
    
    // you need to treat n as an unsigned value
    public static int hammingWeight1(int n) {
        
        // Java: use >>> instead of >>
         // C or C++: use uint32_t
         n = n - ((n >> 1) & 0x55555555);
         n = (n & 0x33333333) + ((n >> 2) & 0x33333333);
         return (((n + (n >> 4)) & 0x0F0F0F0F) * 0x01010101) >> 24;
    }
    
    public static int hammingWeight(int n){
        int count = 0;
        int mask = 1; //mask that starts with the LSB
        for(int i=0;i<32;i++){
            if((n&mask)!=0)
                count++;
            mask<<= 1;
        }
        return count;
    }
    
    public static void main(String args[]){
        System.out.println(hammingWeight(0));
    }
}
