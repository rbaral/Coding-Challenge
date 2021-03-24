/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci.bitnbytes;

/**
 * 
 * Given a real number between 0 and 7 (e.g., 0.72) that is passed in as a double, print
the binary representation. If the number cannot be represented accurately in binary
with at most 32 characters, print "ERROR."
* 
* 
* Solution:
* 
* NOTE: When otherwise ambiguous, we'll use the subscripts x_2 and x_10 to indicate
whether x is in base 2 or base 10.
First, let's start off by asking ourselves what a non-integer number in binary looks like. By
analogy to a decimal number, the binary number 0.1012 would look like:
0.101_2 = 1 * (1/2^1) + 0 * (1/2^2) + 1 * (1/2^3).
To print the decimal part, we can multiply by 2 and check if 2*n is greater than or equal
to 1. This is essentially "shifting" the fractional sum. That is:
r = 2_10 * n
= 2_10 * 0.101_2
= 1 * (1/2^0) + 0 * (1/2^1) + 1 * (1/2^2)
= 1.012
If r >= 1, then we know that n had a 1 right after the decimal point. By doing this
continuously, we can check every digit.
 *
 * @author rbaral
 */
public class FractionToBinary {
 
    static String printBinary(double num){
        if (num>=1 || num<=0){
            return "ERROR";
        }
        StringBuilder bin = new StringBuilder();
        bin.append(".");
        while(num>0){
            if(bin.length()>=32){
                System.out.println(bin.toString());
                return "ERRORss";
            }
            double twice = 2*num;
            if(twice>=1){
                bin.append(1);
                num = twice - 1;
            }else{
                bin.append(0);
                num = twice;
            }
        }
        
        return bin.toString();
    }
    public static void main(String args[]){
        System.out.println(printBinary(0.125));
    }
}
