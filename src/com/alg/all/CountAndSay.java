/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ccup;

/**
 *
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211. Given an integer n, generate the nth
 * sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 *
 * Base case: n = 0 print "1" for n = 1, look at previous string and write
 * number of times a digit is seen and the digit itself. In this case, digit 1
 * is seen 1 time in a row... so print "1 1" for n = 2, digit 1 is seen two
 * times in a row, so print "2 1" for n = 3, digit 2 is seen 1 time and then
 * digit 1 is seen 1 so print "1 2 1 1" for n = 4 you will print "1 1 1 2 2 1"
 *
 *
 * @author rbaral
 */
public class CountAndSay {

    public static String countAndSay(int n) {
        String resultString = "1";
        //base case
        if (n <= 1) {
            return "1";
        } else {
            int count = 1;

            for (int i = 1; i < n; i++) {
                StringBuilder lastString = new StringBuilder();
                for (int j = 1; j < resultString.length(); j++) {
                    if (resultString.charAt(j) == resultString.charAt(j - 1)) {// a repeat character
                        count++;
                    } else {//new character
                        lastString.append(count);
                        lastString.append(resultString.charAt(j - 1));
                        count = 1;
                    }
                }
                lastString.append(count);
                lastString.append(resultString.charAt(resultString.length() - 1));
                resultString = lastString.toString();
                count = 1;
            }
        }

        return resultString;
    }

    public static void main(String args[]) {
        System.out.println(countAndSay(6));
    }
}
