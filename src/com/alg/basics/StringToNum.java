/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics;

/**
 *
 * @author rbaral
 * 
 * 
 * Convert a given string to a number and if there is an invalid input, throw an exception.
 * There can be + or - symbol infront of a valid number, but not elsewhere. The valid string
 * can be -123, +123.
 * Invalid can be: 12L, 12.0 and so on.
 * 
 */
public class StringToNum {
    
    static long stringToNum(String str) throws Exception{
        long num = 0;
        long digit = 1;
        for(int i = str.length()-1; i>=0;i--){
            System.out.println((int)str.charAt(i)+"..."+(str.charAt(i)-'0'));
            if(i==0 &&(str.charAt(i)=='+' || str.charAt(i)=='-')){
                if(str.charAt(i)=='-')
                    num=-num;
            }else if((int)str.charAt(i)>=48 && (int)str.charAt(i)<58){
                System.out.println("adding "+(str.charAt(i)-'0')+" to "+num+" gives "+(num + (long)(str.charAt(i)-'0')*digit));
                num = num + (long)(str.charAt(i)-'0')*digit;
                digit*=10;
            }else{
                throw new Exception("invlid input "+str);
            }
            
        }
        return num;
    }
    public static void main(String args[]){
        System.out.println(Long.MAX_VALUE);
        String a = "-999999999999999999";
        try {
            System.out.println("num is:"+stringToNum(a));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
