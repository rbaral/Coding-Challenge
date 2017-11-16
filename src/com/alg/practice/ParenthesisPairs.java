/*
Implement an algorithm to print all valid (i.e., properly opened and closed) combinations
ofn-pairs of parentheses.

solution:
-we recursively add the left parenthesis till we have left parenthesis remaining
-add the right parenthesis till we have right parenthesis remaining
-the recursion makes the pair form a valid pair unless one or both are exhausted
 */
package com.alg.practice;

import java.util.ArrayList;
import java.util.List;

public class ParenthesisPairs {

    public static void getPairs(List<String> validPairs, int leftRem, int rightRem, char[] pairs, int index) {
        //handle base cases
        if (leftRem == 0 && rightRem == 0) {//no more braces left
			//copy the pairs formed so far to the validpairs
			validPairs.add(String.valueOf(pairs));
            return;
        }

        if (leftRem > rightRem) {//this is invalid combination
            return;
        }

        //get different combination
        //add one left and get the possible valid pairs on the remaining braces
        pairs[index] = '(';
        //repeat for the remaining braces
        if (leftRem > 0) {
            getPairs(validPairs, leftRem - 1, rightRem, pairs, index+1);
        }
        //make the pair complete by adding the right braces
        pairs[index] = ')';
        //repeat for the remaining braces
        if (rightRem > 0) {
            getPairs(validPairs, leftRem, rightRem - 1, pairs, index+1);
        }

    }

    public static void main(String args[]) {
        int braces = 3; //2 pairs
        List<String> validPairs = new ArrayList<String>();
        int leftRem = braces;
        int rightRem = braces;
        char[] pairs = new char[braces * 2]; //we store the pairs in this char array
        getPairs(validPairs, leftRem, rightRem, pairs, 0);
        for (String pair : validPairs) {
            System.out.println(pair);
        }
    }

}
