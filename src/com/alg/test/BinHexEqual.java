/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

/**
 *
 * @author rbaral
 */
public class BinHexEqual {
    //check if two binary and hex strings are equal or not

    public static boolean hexBinEqual(String bin, String hex) {
        int n1 = convertToBase(bin, 2);
        int n2 = convertToBase(hex, 16);
        if (n1 < 0 || n2 < 0) {
            return false;
        } else {
            return n1 == n2;
        }
    }

//convert a char to digit
    public static int digitToChar(char a) {
        if (a >= '0' && a <= '9') {
            return a - '0';
        } else if (a >= 'A' && a <= 'F') {
            return a - 'A' + 10;
        } else if (a >= 'a' && a <= 'f') {
            return a - 'a' + 10;
        } else {
            return -1;
        }
    }

    public static int convertToBase(String num, int base) {
        if (base < 2 || (base > 10 && base != 16)) {
            return -1;
        }
        int totVal = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int val = digitToChar(num.charAt(i));
            //apply the base to the value
            if (val!= -1) {
                int exp = num.length() - 1 - i;
                totVal+=val*(int)Math.pow(base, exp);
            }else{
                return -1;
            }
        }
        return totVal;

    }
    
    public static void main(String args[]){
        String bin = "11011";
        String hex = "1A";
        System.out.println("bin hex equality is:"+hexBinEqual(bin, hex));
    }
}
