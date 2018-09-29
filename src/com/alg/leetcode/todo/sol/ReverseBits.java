/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.todo.sol;

/**
 *
 * Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?
* 
* Solution 1:
* 1)get the binary string of the input number
* 2)have two pointers one pointing to the begining and another to the end of the binary string
* 3)repeat until two pointers meet
* 3 a) if the bits at two  pointers are same, simple advance both indices (pointer1 increases, pointer2 decreases)
* 3 b) if the bits are different simply swap them
* 
* complexity: O (logn)
 * 
 * @author rbaral
 */
public class ReverseBits {
    
}
