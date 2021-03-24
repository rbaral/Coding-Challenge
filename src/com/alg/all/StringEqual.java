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
public class StringEqual {

    //count the chars in two string and check if the count is equal
    public static boolean stringEqual(String a, String b) {
        if(a.length()!=b.length())
            return false;
        int count[] = new int[256];
        for (int i = 0; i < a.length(); i++) {
            int val = (int) a.charAt(i);
            System.out.println(val);
            count[val]++;
        }
        
        //check if same count in second string
        for (int i = 0; i < b.length(); i++) {
            int val = (int) b.charAt(i);
            if (--count[val] < 0) {
                return false;
            }
            //count[val]--;
        }
        return true;
    }

    public static void main(String args[]) {
        String a = "abce";
        String b = "bcda";
        boolean equal = stringEqual(a, b);
        System.out.println("equality is:" + equal);
    }

}
