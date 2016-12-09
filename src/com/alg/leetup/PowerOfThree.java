/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

/**
 * 
 * Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
* 
 *
 * @author rbaral
 */
public class PowerOfThree {
    public static boolean isPowerOfThree(int n) {
        System.out.println("chcking for "+n);
        if(n==1 || n==3)
            return true;
        else if(n<9 || n%3!=0)
            return false;
        else
            return isPowerOfThree(n/3);
    }
    
    public static void main(String args[]){
        System.out.println(isPowerOfThree(45));
        System.out.println(isPowerOfThree(6));
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(19684));
    }
}
