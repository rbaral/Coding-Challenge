/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics;

/**
 * "101" +"102" ="210"
 *
 * binary {0,1} trinary {0,1,2} write a method to add the two trinary numbers
 *
 * @author rbaral
 */
public class TernaryAddition {

    static String performAddition(String a, String b) {

        //lets check the length and pad 0s if required
        int len1 = a.length();
        int len2 = b.length();
        if (len1 < len2) {
            int diff = len2 - len1;
            while (diff > 0) {
                a = "0" + a;
                diff--;
            }
        } else if (len2 < len1) {
            int diff = len1 - len2;
            while (diff > 0) {
                b = "0" + b;
                diff--;
            }
        }
        //iterate and add from the last character
        int sum, carry = 0;
        String totalSum = "";
        for (int i = a.length() - 1; i >= 0; i--) {
            sum = a.charAt(i) - '0' + b.charAt(i) - '0' + carry;
            carry = sum / 3;
            sum = sum % 3;
            totalSum = sum + totalSum;
        }
        if (carry > 0) {
            totalSum = carry + totalSum;
        }

        return totalSum;
    }

    public static void main(String args[]) {
        String a = "102";
        String b = "20111";

        System.out.println("" + performAddition(a, b));
    }
}
