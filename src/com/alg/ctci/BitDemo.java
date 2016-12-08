/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;

/**
 *
 * The way negative numbers are represented is called 2's complement. 
 * To demonstrate how this works, take -12 as an example. 12, in binary, is 00001100 (assume integers are 8 bits though in reality they are much bigger). 
 * Take the 2's complement by simply inverting every bit, and you get 11110011. 
 * Then, simply add 1 to get 11110100. Notice that if you apply the same steps again, you get positive 12 back.

* The >>> shifts in zero no matter what, so 12 >>> 1 should give you 00000110, which is 6, and (-12) >>> 1 should give you 01111010, which is 122. 
* If you actually try this in Java, you'll get a much bigger number since Java ints are actually much bigger than 8 bits.

* The >> shifts in a bit identical to the highest bit, so that positive numbers stay positive and negative numbers stay negative. 12 >> 1 is 00000110 (still 6) and (-12) >> 1 would be 11111010 which is negative 6.
 * 
 * 
 * @author rbaral
 */
class BitDemo {
    public static void main(String[] args) {
        int bitmask = 0x000F;
        int val = 0x22; //2*16^1 + 2*16^0 and so on
        // prints "2"
        System.out.println(bitmask);
        System.out.println(val);     
        System.out.println(val & bitmask);
        System.out.println(Integer.toBinaryString(1 >> 16));
        System.out.println(Integer.toBinaryString(-12 >> 1));
        
    }
}
