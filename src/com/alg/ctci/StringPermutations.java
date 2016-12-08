/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;

import java.util.ArrayList;

/**
 *Write a method to compute all permutations of a string
 * 
 * @author rbaral
 */
public class StringPermutations {
    
    /**
     * returns the permutation of a string by appending the nth character
     * to the all permutations of length n-1
     * @param a
     * @return 
     */
    static ArrayList<String> getPermutations(String a){
        //base cases
        if(a == null){
            return null;
        }
        ArrayList<String> perms = new ArrayList<String>();
        if(a.length()==0){ //a blank string
            perms.add("");
            return perms;
        }
        
        //now iterate character by character and add the new character
        //over the previous set of permutations
        char firstChar = a.charAt(0);
        String restPart = a.substring(1);
        ArrayList<String> words = getPermutations(restPart);
        //for every item in the permutations of the previous iteration, add the current char
        for(String word:words){ //for every last permutation item
            for(int i=0; i<=word.length(); i++){ //add the current character at every possible position
                String b = insertCharAt(word, firstChar, i);
                perms.add(b);
            }
        }
        return perms;
    }
    
    //adds the character to the index position of the string
    static String insertCharAt(String word, char b, int index){
        String start = word.substring(0, index);
        String end = word.substring(index);
        return start+b+end;
    }
    
    public static void main(String args[]){
        ArrayList<String> list = getPermutations("abcde");
        System.out.println("There are " + list.size() + " permutations.");
        for (String s : list) {
                System.out.println(s);
        }
    }
    
}
