/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

public class StringCompressor {

    //scan the string and keep its count to be used in the new string
    public static String compressString(String s1) {
        StringBuffer compString = new StringBuffer();
        int curCount = 1;
        for (int i = 1; i < s1.length(); i++) {
            if (s1.charAt(i) == s1.charAt(i - 1)) {
                curCount++;
            } else {
                //add the count and the char to new string
                compString.append(s1.charAt(i - 1));
                compString.append(curCount);
                curCount = 1;
            }
            //append the last entry
            if (i == s1.length() - 1) {
                compString.append(s1.charAt(i - 1));
                compString.append(curCount);
            }
        }
        return compString.toString();
    }

    public static void main(String args[]) {
        String s1 = "aabcccccaaa";
        String comp = compressString(s1);
        System.out.println("compressed sting is:" + (s1.length() <= comp.length() ? s1 : comp));

    }

}
