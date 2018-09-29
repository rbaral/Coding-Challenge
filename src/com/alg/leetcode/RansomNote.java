/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if the ransom
 * note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note: You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true 
 * canConstruct("fffbfg", "effjfggbffjdgbjjhhdegh") ->true
 *
 *
 * NOTE:
 *
 * The magazine should have a character for the character in the ransomnote.
 * Each character can only be used once from the magazine.
 *
 *
 * @author rbaral
 */
public class RansomNote {

    static boolean canConstruct1(String ransomNote, String magazine) {
        //base cases
        if (ransomNote.length() == 1 && magazine.length() == 1 && !ransomNote.equals(magazine)) {
            return false;
        } else if (magazine.contains(ransomNote)) {
            return true;
        } else {
            //iteratively search for the solution
            int[] magUsed = new int[magazine.length()]; //initialize an array to keep track of used chars from magazine
            int matchCount = 0;
            for (int i = 0; i < ransomNote.length(); i++) {
                for (int j = 0; j < magazine.length(); j++) {
                    if ((ransomNote.charAt(i) == magazine.charAt(j)) && magUsed[j] == 0) {
                        magUsed[j] = -1;
                        matchCount++;
                        break;
                    }
                }
            }
            System.out.println(matchCount + "...." + ransomNote.length());
            if (matchCount == ransomNote.length()) {
                return true;
            }
        }

        return false;
    }

    static boolean canConstruct2(String ransomNote, String magazine) {
        //base cases
        if (ransomNote.length() == 1 && magazine.length() == 1 && !ransomNote.equals(magazine)) {
            return false;
        } else {
            //get the hash of the chars in magazine
            Map<String, Integer> charMap = new HashMap<String, Integer>();
            for (int i = 0; i < magazine.length(); i++) {
                if (charMap.containsKey(magazine.substring(i, i + 1))) {
                    charMap.put(magazine.substring(i, i + 1), charMap.get(magazine.substring(i, i + 1)) + 1);
                } else {
                    charMap.put(magazine.substring(i, i + 1), 1);
                }
            }
            //now for every char in ransomnote check if it is in the charMap
            int j = 0;
            for (j = 0; j < ransomNote.length(); j++) {
                if (charMap.containsKey(ransomNote.substring(j, j + 1)) && charMap.get(ransomNote.substring(j, j + 1)) > 0) {
                    charMap.put(ransomNote.substring(j, j + 1), charMap.get(ransomNote.substring(j, j + 1)) - 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean canConstruct(String ransomNote, String magazine) {
        //base cases
        if (ransomNote.length() == 1 && magazine.length() == 1 && !ransomNote.equals(magazine)) {
            return false;
        } else {
            //create an array for the char count in magazine
            int[] charCount = new int[26];//we assume only small case letters are there
            for (int i = 0; i < magazine.length(); i++) {
                charCount[magazine.charAt(i) - 'a'] += 1;
            }
            //now decrement the count by scanning the ransomnote
            for (int j = 0; j < ransomNote.length(); j++) {
                if (charCount[ransomNote.charAt(j) - 'a'] > 0) {
                    charCount[ransomNote.charAt(j) - 'a']--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        String magazine = "a";
        String ransomNote = "b";

        System.out.println(canConstruct(ransomNote, magazine));
        ransomNote = "aa";
        magazine = "ab";
        System.out.println(canConstruct(ransomNote, magazine));
        magazine = "aab";
        ransomNote = "aa";
        System.out.println(canConstruct(ransomNote, magazine));
        System.out.println(canConstruct("fffbfg", "effjfggbffjdgbjjhhdegh"));

        ransomNote = "bjaajgea";
        magazine = "affhiiicabhbdchbidghccijjbfjfhjeddgggbajhidhjchiedhdibgeaecffbbbefiabjdhggihccec";
        System.out.println(canConstruct(ransomNote, magazine));

        ransomNote = "fihjjjjei";
        magazine = "hjibagacbhadfaefdjaeaebgi";

        System.out.println(canConstruct(ransomNote, magazine));

        ransomNote = "bcjefgecda";
        magazine = "hfebdiicigfjahdddiahdajhaidbdgjihdbhgfbbccfdfggdcacccaebh";

        System.out.println(canConstruct(ransomNote, magazine));

    }
}
