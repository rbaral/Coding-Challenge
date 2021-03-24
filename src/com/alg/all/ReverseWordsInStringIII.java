/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
package com.alg.leetcode;

/**
 *
 * @author rbaral
 * 
 * Solution 1:
 * 
 * 1) split the given string by space, to get an array of words
 * 2) for every word in the array, reverse the word
 * 2 a) to reverse a word, simply print it from end
 * 3) print the reversed words with space between them
 * 
 * complexity: 
 * O(n) to split, where n= number of characters in the string
 * O(nk) to reverse every word in the string, where k is the total words in the string
 * O(n) to assemble the reversed words into the resulting string
 * 
 * Total complexity: O(nk+2n)
 * 
 */
public class ReverseWordsInStringIII {
    
    public static String reverseWords(String s) {
        //split into words
        String[] words = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int j = 0; j<words.length; j++){
            char[] chars = words[j].toCharArray();
            //reverse every word
            for(int i=0;i<chars.length/2; i++){
                //swap the two ends
                char c1 = chars[i];
                chars[i] = chars[chars.length -1 -i];
                chars[chars.length -1 -i] = c1;
            }
            
            words[j] = String.valueOf(chars);
            sb.append(words[j]+" ");
        }
        return sb.toString().trim();
    }
    
    public static String reverseWordsII(String param){
        StringBuffer rev = new StringBuffer();
        StringBuffer word = new StringBuffer();
        for(int i=param.length()-1; i>=0;i--){
            if(param.charAt(i)==' '){//word terminator
                rev.insert(0, word.toString());
                rev.insert(0, ' ');
                //clear word
                word.setLength(0);
            }
            else
                word.append(param.charAt(i));
            //for the first word
            if(i==0){
                rev.insert(0, word.toString());
                rev.insert(0, ' ');
            }
        }
        return rev.toString();
    }
    public static void main(String args[]){
        String input= "Let's take LeetCode contest";
        String output = reverseWordsII(input);
        System.out.println(output);
    }
}
