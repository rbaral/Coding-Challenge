/**
 * Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, si and s2, write code to check If s2 is a rotation of si
 * using only one call to isSubstring (e.g., "waterbottLe" is a rotation of "erbottLewat").
 */
package com.alg.ctci;

public class WordRotationSubString {

    /**
     * checks whether the word2 is a rotational substring of word1 or not we
     * just concatenate the word1 with itself and check if word2 is a substring
     * of it For ex: waterbottle+waterbottle = waterbottlewaterbottle contains
     * the substring erbottlewat
     */
    static boolean isSubstring(String word1, String word2) {
        boolean isValid = false;
        //check if the strings' length is non zero and is equal to each other
        if (word1.length() > 0 && word1.length() == word2.length()) {
            String newString = word1 + word2;
            return newString.contains(word2);
        } else {//strings are of zero length or are not equal in size
            isValid = false;
        }
        return isValid;
    }

    public static void main(String args[]) {
        String word1 = "waterbottLe";
        String word2 = "erbottLewa";
        System.out.println(isSubstring(word1, word2));
    }
}
