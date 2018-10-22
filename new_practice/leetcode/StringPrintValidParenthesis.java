/**
String ValidParenthesis

Implement an algorithm to print all valid (i.e., properly opened and closed) combinations
ofn-pairs of parentheses
*/
import java.util.*;

public class StringPrintValidParenthesis{

	/**
	Method1:
	-use the concept of build from previous
	-first build for case n = 1, {()}
	-for n=2, add the new pair in every possible places, i.e. 0,1,... of the previous valid pairs:
	{()()},{(())}, again we can avoid duplicates
	-this will generate duplicates and we need to check to avoid duplicates
	*/
	public List<String> getValidParenthesis1(int n){
		List<String> pairs = new ArrayList<String>();
		return pairs;
	}
	
	/**
	Method2:
	use recursive approach
	-keep track of left and right remaining braces
	-as long as the combination is valid (left<=right, left>0, right>0) we recursively add the braces
	-stop when left and right are both exhuasted
	*/

	public static List<String> getValidParenthesis(int n){
		List<String> pairs = new ArrayList<String>();
		if(n==0){
			return pairs;
		}
		if(n==1){
			pairs.add("()");
			return pairs;
		}
		StringBuilder sb = new StringBuilder("");
		sb.append("");
		char[] chars = new char[2*n];
		getPairsRecursive(n, n, pairs, chars, 0);
		return pairs;
	}
	
	public static void getPairsRecursive(int lcount, int rcount, List<String> res, char[] chars, int index){
		if(lcount==0 && rcount==0){
			res.add(String.valueOf(chars));
			return;
		}else if(rcount<lcount){
			return; //invalid combination
		}
		if(lcount>0){
			chars[index] = '(';
			getPairsRecursive(lcount-1, rcount, res, chars, index+1);
		}
		if(rcount>lcount){
			chars[index] = ')';
			getPairsRecursive(lcount, rcount-1, res, chars, index+1);
		}
	}
		
	
	public static void main(String[] args){
		int n = 2;
		List<String> pairs = getValidParenthesis(n);
		for(String pair:pairs){
			System.out.println(pair);
		}
	}
}