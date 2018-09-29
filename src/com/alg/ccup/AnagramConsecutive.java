/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ccup;

/**
 *
 * @author rbaral
 *
 * Given two words, determine if the first word, or any anagram of it, appears
 * in consecutive characters of the second word. For instance, tea appears as an
 * anagram in the last three letters of slate, but let does not appear as an
 * anagram in actor even though all the letters of let appear in slate. Return
 * the anagram of the first word that has appeared in the second word. Sample
 * Input 1 tea slate  *
 * Sample Output1 ate  *
 * Sample Input 2 let slate  *
 * Sample Output2 NONE
 *
 *
 * solution 1: 1)use two nested loops and check for the whole window in the
 * word2 to see if there is a match
 *
 * Complexity: O(n^2)
 *
 *
 * Solution 2: 1)if first word is longer than the second one then there is no
 * solution 2)If the first word is not longer than the second one do the
 * following: 2 a) keep track of the count of the characters in teh first word 2
 * b) start scanning the second word for the window equal to the length of the
 * first word 2 c) if the count of the every chars in the window is equal to the
 * count of the chars in the first word then we found the match 2 d) if not
 * found in (c) advance the window by one character 3)repeat (2) till a match is
 * found or there is no more window left
 *
 * Complexity: O(n)
 *
 */
public class AnagramConsecutive {

    public static String findAnagram(String word1, String word2) {
        if (word1 == null || word2 == null || word1.length() > word2.length()) {
            return "NONE";
        }
        String ana = "NONE";
        int[] charcount1 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            charcount1[word1.charAt(i) - 'a'] += 1;
        }
        int matchedCharsCount = 0;
        int skippedCharsCount = 0;
        int[] charcount2 = new int[26];
        for (int i = 0; i < word2.length(); i++) {
            charcount2[word2.charAt(i) - 'a']+= 1;
            if (charcount2[word2.charAt(i) - 'a'] == charcount1[word2.charAt(i) - 'a']) {//the count is same
                System.out.println("matchcount same for char:" + word2.charAt(i) + " total match count:" + matchedCharsCount);
                matchedCharsCount++;
            } else if (charcount2[word2.charAt(i) - 'a'] > charcount1[word2.charAt(i) - 'a'] && charcount1[word2.charAt(i) - 'a'] > 0) {//the count exceeded
                matchedCharsCount--;
            }
            //if we have enough window
            if (i >= word1.length() - 1) {
                if (matchedCharsCount == word1.length()) {
                    //a match is found
                    ana = word2.substring(skippedCharsCount, i + 1);
                    return ana;
                }else {
                    //reduce the count of the skipped char
                    //if the matccount have used the character being skipped then update it
                    if (charcount2[word2.charAt(skippedCharsCount) - 'a'] == charcount1[word2.charAt(skippedCharsCount) - 'a'] && charcount1[word2.charAt(skippedCharsCount) - 'a'] > 0) {
                        matchedCharsCount--;
                    }
                    charcount2[word2.charAt(skippedCharsCount) - 'a']--;
                    skippedCharsCount++; //the window is there but we couldn't find the anagram
                    //System.out.println("skip "+skippedCharsCount+" i:"+i);
                }
            }
        }
        System.out.println("matched count is:" + matchedCharsCount);
        return ana;
    }

    public static void main(String args[]) {
        String a = "tea", b = "slate";
        System.out.println(findAnagram(a, b));
        a = "tale";
        b = "slate";
        System.out.println(findAnagram(a, b));
        a = "tales";
        b = "slate";
        System.out.println(findAnagram(a, b));
        a = "let";
        b = "slate";
        System.out.println(findAnagram(a, b));

    }

}
