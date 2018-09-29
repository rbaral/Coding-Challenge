/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci.bitnbytes;

/**
 *Write a function to determine the number of bits required to convert integer A to
integer B.
* 
* 
* Solution:
* This seemingly complex problem is actually rather straightforward. To approach this,
ask yourself how you would figure out which bits in two numbers are different. Simple:
with an XOR.
Each 1 in the XOR represents a bit that is different between A and B. Therefore, to check
the number of bits that are different between A and B, we simply need to count the
number of bits in AAB that are 1.
* 
* 
 * @author rbaral
 */
public class BitsRequiredToGetAFromB {
    
    static int bitSwapRequired(int a, int b){
        int count = 0;
        for(int c= a^b; c!=0;c>>=1){
            count+= c&1;
        }
        return count;
    }
    
    public static void main(String args[]){
        System.out.println(bitSwapRequired(4, 2));
    }
}
