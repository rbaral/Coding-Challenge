/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

/**
 *
 * Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
* For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.
* 
* Solution 1:
* 1)divide by 2 or 3 or 5 repeatedly till these cannot divide the number
* 2)if there is any other factor found then return false
* 3) if no other factor found return true
* 
* O(logn)
* 
 * @author rbaral
 */
public class UglyNumber {
    public static boolean isUgly(int num) {
        //prime factors are only 2, 3 and 5
        if(num==0){
            return false;
        }
        if(num==1){
            return true;
        }else{
            if(num%5==0){
                return isUgly(num/5);
            }else if(num%3==0){
                return isUgly(num/3);
            }else if(num%2==0){
                return isUgly(num/2);
            }else{
                return false;
            }
        }
    }
    
    public static void main(String args[]){
        System.out.println(isUgly(14));
    }
}
