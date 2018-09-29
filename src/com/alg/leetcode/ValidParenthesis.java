/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
package com.alg.leetup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rbaral
 *
 */
public class ValidParenthesis {

    private static DateFormat format = new SimpleDateFormat("YYYY-M-d:H:m:s:S");

    /**
     * @param args
     */
    public static void main(String[] args) {
        boolean isTestMode = true;
        if (isTestMode) {
            performTest();
        } else {
            String s = "[";
            s = "([])";
            System.out.println(format.format(new Date()));
            System.out.println(isValid(s));
            System.out.println(format.format(new Date()));
        }

    }

    /**
     * we first check for simple base cases for other cases, we push each
     * character to a list and check if the next character to be pushed forms a
     * pair with the last pushed char. If found, we remove the last pushed char,
     * else, we keep on pushing. If at the end, the list is empty, it means we
     * have found pair for all the chars and we return true else we return false
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        //base case
        if (s == null || s.length() < 2) {
            return false;
        } else if (s.length() == 2) {
            return isPair(s.charAt(0), s.charAt(1));
        } else if (s.length() % 2 != 0)//has odd characters
        {
            return false;
        } else {
            System.out.println("checking for:" + s);
            // push the remaining characters to the the list and while pushing check if consecutives form a pair
            List<String> charsList = new ArrayList<String>();
            for (int i = 0; i < s.length(); i++) {
                if (i == 0 || charsList.isEmpty()) {
                    charsList.add(String.valueOf(s.charAt(i)));
                } else// check if the last one and this form a pair
                if (isPair(charsList.get(charsList.size() - 1).charAt(0), s.charAt(i))) {
                    // remove the last entry from list
                    charsList.remove(charsList.size() - 1);
                } else {
                    charsList.add(String.valueOf(s.charAt(i)));
                }
            }
            if (charsList.size() == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean isPair(char a, char b) {
        if (a == '(' && b == ')') {
            return true;
        }
        if (a == '{' && b == '}') {
            return true;
        }
        if (a == '[' && b == ']') {
            return true;
        }
        return false;
    }

    public static char getPair(char a) {
        char result = a;
        switch (a) {
            case '(':
                result = ')';
                break;
            case '{':
                result = '}';
                break;
            case '[':
                result = ']';
                break;
            default:
                result = a;
        }
        return result;
    }

    public static void performTest() {
        Map<String, Boolean> testCases = new HashMap<String, Boolean>();
        List<String> failedCases = new ArrayList<String>();
        testCases.put("[", Boolean.FALSE);
        testCases.put("(]", Boolean.FALSE);
        testCases.put("([)]", Boolean.FALSE);
        testCases.put("()", Boolean.TRUE);
        testCases.put("()[]{}", Boolean.TRUE);
        testCases.put("{[{}]}", Boolean.TRUE);
        testCases.put("{[{}]}{[{}]}", Boolean.TRUE);
        testCases.put("([])", Boolean.TRUE);
        boolean result = false;
        for (String testCase : testCases.keySet()) {
            result = isValid(testCase);
            if (testCases.get(testCase) != result) {
                failedCases.add("Failed for:" + testCase + " expected:" + testCases.get(testCase) + " got:" + result);
            }
        }
        System.out.println("TEST RESULT: PASSED:" + (testCases.size() - failedCases.size()) + " FAILED:" + failedCases.size());
        for (String s : failedCases) {
            System.err.println(s);
        }
    }

}
