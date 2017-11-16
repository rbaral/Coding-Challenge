/*
Write a method to compute all permutations of a string


Solution:

-start with base case and keep on building
-if the length of given string is 0, return empty string which is the only permutation possible
-now we build on the top of the previous permutation, by adding the new elment in every possible positions
of the previous permutations
-the permutation obtained in the last step is the desired result
 */
package com.alg.practice;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author rbaral
 */
public class PermutationsOfString {

    public static List<String> getPerms(String s) {
        if (s.length() == 0) {
            List<String> myList = new ArrayList<String>();
            myList.add(" ");
            return myList;
        } else {
            //insert the character in every possible place of the previous permutations
            //previous permutations have all characters except the current character
            String curChar = s.substring(0, 1); //can take the first or last character
            String rem = s.substring(1);//the remining substring
            List<String> perms = getPerms(rem);
            //now insert the curChar to every permutation in every possible place
            List<String> newPerms = new ArrayList<String>();
            for (String perm : perms) {
                //System.out.println("adding "+curChar+" to perm "+perm+" of length:"+perm.length());
                //each perm is a word
                for (int i = 0; i < perm.length(); i++) {
                    //update the perm by adding the curChar
                    String newPerm = perm.substring(0, i) + curChar + perm.substring(i);
                    newPerms.add(newPerm);
                }
            }
            return newPerms;
        }
    }

    public static void main(String args[]) {

        String a = "abc";
        List<String> perms = getPerms(a);
        for (String perm : perms) {
            System.out.println(perm);
        }

    }

}
