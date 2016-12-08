/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;

/**
 * Ref: http://www.programmerinterview.com/index.php/general-miscellaneous/find-max-without-comparison/
 * 
 *Write a method which finds the maximum of two numbers. You should not use
if-else or any other comparison operator.
* 
 * @author rbaral
 */
public class MinMaxWithoutComparing {
    
    //flips 1 to 0 and 0 to 1
    static int flip(int bit){
        return 1^bit; //return 1 - bit; 
    }
    
    //returns 1 if a is positive, and returns 0 when a is negative
    //shifting right by 31 bits will have just the MSB kept in the shifted value. If the number is negative this will be 1 else it will be 0.
    //doing and with 1 will result in 1 if the shifted value was 1 else it will result in 0
    static int sign(int a){
        return flip((a>>31) & 0x1); //shift right 31 bits and ands with hex value of 1
    }
    static int max(int x, int y){
        int z = (x-y);
        int i = (z>>31) & 0x1;
       return x-i*z;
    }
    
    public static void main(String args[]){
        int a =5, b= 10;
        System.out.println(0x1);
        System.out.println("max "+max(5,10)); // both positive
        System.out.println("max "+max(-2,-15)); //both negative
        System.out.println("max "+max(5,-10));//first positive second negative
        System.out.println("max "+max(-5,10));//first negative second positive
        
    }
}
