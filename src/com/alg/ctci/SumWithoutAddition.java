/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;

/**
 *Write a function that adds two numbers. You should not use + or any arithmetic
operators.
* 
 * @author rbaral
 */
public class SumWithoutAddition {
    
    static int add(int a, int b){
        if(b==0){
            return a;
        }else if(a==0){
            return b;
        }else{
            int sum = a^b; //add without carrying
            int carry = (a&b) <<1; //carry but don't add
            return add(sum, carry);
        }
    }
    
    public static void main(String args[]){
        System.out.println("sum:"+add(5,7));
    }
}
