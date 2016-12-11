package com.alg.leetup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * Some hints: Could negative integers be palindromes? (ie, -1)
 *
 * If you are thinking of converting the integer to string, note the restriction
 * of using extra space.
 *
 * You could also try reversing an integer. However, if you have solved the
 * problem "Reverse Integer", you know that the reversed integer might overflow.
 * How would you handle such case?
 *
 * There is a more generic way of solving this problem. TODOS: 
 * Handle overflow
 */
/**
 *
 * @author rbaral
 *
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        boolean testEnabled = false;
        if (testEnabled) {
            performTest();
        } else {
            DateFormat format = new SimpleDateFormat("YYYY-M-d:H:m:s:S");
            System.out.println(format.format(new Date()));
            int num = 191;
            System.out.println("output is:" + isPalindrome(num));
            System.out.println(format.format(new Date()));
        }

    }

    public static boolean isPalindrome(int x) {
        if (x < 0)//negative numbers are not palindrome
        {
            return false;
        }
        if (x < 10)//one digit is always a palindrome
        {
            return true;
        }
        //find the reverse of the number and check if the reverse is equal to it
        int rev = 0;
        int temp = x;
        while (temp > 0) {
            rev = temp % 10 + rev * 10;
            temp /= 10;
        }
        System.out.println("reverse is:" + rev + " number is:" + x);
        if (rev == x) {
            return true;
        }
        return false;
    }

    public static void performTest() {
        Map<Integer, Boolean> testCases = new HashMap<Integer, Boolean>();
        List<String> failedCases = new ArrayList<String>();
        boolean result = false;
        testCases.put(121, true);
        testCases.put(122, false);
        testCases.put(-2147483648, false);

        testCases.put(11, true);
        for (int testCase : testCases.keySet()) {
            result = isPalindrome(testCase);
            if (result != testCases.get(testCase)) {
                failedCases.add("Failed for:{" + testCase + "} got:" + result + " expected:" + testCases.get(testCase));
            }
        }
        System.out.println("TEST RESULT, Passed:" + (testCases.size() - failedCases.size()) + " failed:" + failedCases.size());
        for (String failure : failedCases) {
            System.err.println(failure);
        }
    }

}
