/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

/**
 *Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?
* 
* Ref: https://en.wikipedia.org/wiki/Digital_root
* 
* It helps to see the digital root of a positive integer as the position it holds with respect to the largest multiple of 9 less than the number itself. For example, the digital root of 11 is 2, which means that 11 is the second number after 9. Likewise, the digital root of 2035 is 1, which means that 2035 − 1 is a multiple of 9. If a number produces a digital root of exactly 9, then the number is a multiple of 9.
With this in mind the digital root of a positive integer n may be defined by using floor function as
 dr(n)=n-9*( {n-1}/{9}).
* 
 * @author rbaral
 */
public class AddDigits {
    
    public static int addDigits(int n){
        return (int)(n-9*(int)((n-1)/9));
    }
    
    public static void main(String args[]){
        int num = 38;
        System.out.println("Digital root of "+num+" is "+addDigits(num));
    }
}
