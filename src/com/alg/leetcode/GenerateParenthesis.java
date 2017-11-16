/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 */
package com.alg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 */
/**
 * 
 * @author rbaral
 * ref: http://www.programcreek.com/2014/01/leetcode-generate-parentheses-java/
 *
 */
public class GenerateParenthesis {

	public static void main(String args[]){
		int pairs=3;
		System.out.println(Arrays.toString(generateParenthesis(pairs).toArray()));
	}
	
	public static List<String> generateParenthesis(int n) {
	    ArrayList<String> result = new ArrayList<String>();
	    generateMatch(result, "", n, n);
	    return result;
	}
	
	/**
	 * 
	 * @param result is the result is stored in this list
	 * @param s is the string that is generated so far
	 * @param left is the number of left parenthesis we have remaining 
	 * @param right is the number of right parenthesis left we have remaining
	 */
	public static void generateMatch(ArrayList<String> result, String s, int left, int right){
	    //if we don't have any more left or right parenthesis to be used
	    if(left==0 && right==0){
	        result.add(s);
	        return;
	    }
	  //we have overused the right parenthesis, so we can't get any valid combination with the remainings
  		if(left > right)
  	        return;
	    /**
	     * if we have at least one left parenthesis, then we should use it because every valid combination
	     * should start with a left parenthesis
	     */
	    
	    if(left>0){
	    	generateMatch(result, s+"(", left-1, right);
	    }
	    //use the right parenthesis
	    if(right>0){
	    	generateMatch(result, s+")", left, right-1);
	    }
	}
}
