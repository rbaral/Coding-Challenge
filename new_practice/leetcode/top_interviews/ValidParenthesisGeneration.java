/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/
import java.util.List;
import java.util.ArrayList;

public class ValidParenthesisGeneration{

	/**
	Method1:
	-use recursive approach
	*/
	public static List<String> generateParenthesis1(int n) {
        List<String> parsList = new ArrayList<String>();
		//base case
		if(n==0){
			return parsList;
		}
		generateParensRecursive(parsList, "", n, n);
		return parsList;
    }
	
	/**
	using the number of left and right number of parenthesis keep on building the valid lists
	*/
	public static void generateParensRecursive(List<String> parsList, String curPar, int left, int right){
		if(right<left){//overused right
			return;
		}
		if(left==0 && right==0){//no more left and right parenthesis left
			//add the current string to the list
			parsList.add(curPar);
			return;
		}
		//add one left parenthesis to the string and recurse again
		if(left>0)
			generateParensRecursive(parsList, curPar+"(", left-1, right);
		if(right>0)
			generateParensRecursive(parsList, curPar+")", left, right-1);
	}
	
	/**
	Method2:
	-use iterative approach to build from the basics
	-assume () is the only case for n=1 and start building from it
	-for n=2, build from the combinations of n=1, by inserting a new pair after i=0,1 (i.e. n-1) openings if present
	-similarly repeat for other values of n
	O(n*k) where n is the given input and k is the possible combinations of the parenthesis for (n-1)
	Space O(n) - need to store the parenthesis set for all the values from 1...n
	*/
	public static List<String> generateParenthesis2(int n) {
		return null;
		
	}
	
	public static void main(String args[]){
		int n= 3;
		
		List<String> pars1 = generateParenthesis1(n);
		System.out.println("Valid parentesis1 are:");
		for(String s:pars1){
			System.out.println(s);
		}
		
		/**
		List<String> pars2 = generateParenthesis2(n);
		System.out.println("Valid parentesis2 are:");
		for(String s:pars2){
			System.out.println(s);
		}
		*/
		
	}
}