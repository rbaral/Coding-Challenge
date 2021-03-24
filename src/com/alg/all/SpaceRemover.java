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
public class SpaceRemover {

    /**
     * we count the free spaces after the end of actuala character and verify if
     * the number of spaces within the string and the available one after the
     * actual string is enough to hold the compression. We use two pointers, p1
     * and p2, p1 will point to the end of the actual character and p2 will
     * point to the end of the whole string. We then keep on scanning and
     * replacing a space with %20.
     */
    public static String compressString(String s1) {
        //lets count the number of spaces after the string
        int spaceAfter = 0;
        int spaceWithin = 0;
        for (int i = s1.length() - 1; i >= 0; i--) {
            if ((int) s1.charAt(i) == 32) {
                spaceAfter++;
            }else{
                break; //reached the characters
            }
        }

        //lets count the number of spaces within the string
        for (int i = 0; i < s1.length() - spaceAfter; i++) {
            if ((int) s1.charAt(i) == 32) {
                spaceWithin++;
            }
        }
        //TODO: validate if space after and space within match
        
        //now create two pointers and scan the string to repace the space with %20
        int p1 = s1.length() - spaceAfter - 1;
        int p2 = s1.length() - 1;
        //shift the strings towards the end and substitute space
        char[] chars = s1.toCharArray();
        System.out.println("p1 is:"+p1+" p2 is:"+p2);
        while (p1 < p2 && p1>=0) {
            if ((int) chars[p1] == 32) {//is a space
                chars[p2] = '0';
                chars[p2 - 1] = '2';
                chars[p2 - 2] = '%';
                p2-= 3;
            } else {//simply shift the value
                chars[p2] = chars[p1];
                p2--;
            }
            p1--;
        }
        //check if compression worked
        String comp = new String(chars);
        return comp;

    }

    public static void main(String args[]) {
        String s1 = "ab cd ef    ";
        String comp = compressString(s1);
        System.out.println("compressed one is:" + comp);

    }

}
