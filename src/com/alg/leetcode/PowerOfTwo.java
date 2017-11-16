/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

/**
 *
 * @author rbaral
 */
public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        //System.out.println("chcking for "+n);
        if(n==1 || n==2)
            return true;
        else if(n<2 || n%2!=0)
            return false;
        else
            return isPowerOfTwo(n/2);
    }
    
    public static void main(String args[]){
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(6));
        System.out.println(isPowerOfTwo(123456789));
    }
}
