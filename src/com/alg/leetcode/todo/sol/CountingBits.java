/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.todo.sol;

/**
 *
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
Hint:

You should make use of what you have produced already.
Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
Or does the odd/even status of the number help you in calculating the number of 1s?
* 
* Solution 1:
* 1)For every number, generate the binary string
* 2)count the one bit in the binary string iteratively
* 3)store the count in the index equivalent to the number (for e.g., the count of 1 bit for 2 will be stored in the result[2])
* 
* 
* Complexity: O(nm), where m is the maximum number of bits needed to represent the number upto n
* 
* 
* Solution 2:
* 1)Use a mask number 1
* 2)use mask&n and check if this is 0 or not, if this is not 0 then increase the count
* 3)if mask&n is zero the bit at the position where mask bit is 1 is zero
* 4)If the numbers are of 32 bit, left shift mask bit and check for every other bits in the binary string of the number
* 
* Complexity: O(mn)
* 
* 
 * @author rbaral
 */
public class CountingBits {
    
}
