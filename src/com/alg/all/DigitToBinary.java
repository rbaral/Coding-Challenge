/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.realtest;

/**
 *
 * @author rbaral
 */
public class DigitToBinary {
    
    public static String digitToBase(int num, int base){
        String bin = "";
        if (num<=0 || base<=0){
            return "0";
        }
        while(num>0){
            bin = num%base + bin;
            num = num/base;
        }
        return bin;
    }
    
    public static void main(String args[]){
        int num = 15;
        int base = 3;
        System.out.println("base "+base+" of "+num+" is "+digitToBase(num, base));
        //int c = num&(~((1<<(3))-1));
        int c = num&(((1<<(3))));
        System.out.println("c is:"+c);
    }
}
