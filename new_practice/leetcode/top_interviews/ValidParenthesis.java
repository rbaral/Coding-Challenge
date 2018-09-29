/**
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
*/

import java.util.Stack;

public class ValidParenthesis{
	
	/**
	get parenthesis pair
	*/
	public static char getPair(char c){
		char pair;
		switch(c){
			case '(':
				pair = ')';
				break;
			case ')':
				pair = '(';
				break;
			case '[':
				pair = ']';
				break;
			case ']':
				pair='[';
				break;
			case '{':
				pair ='}';
				break;
			case '}':
				pair ='{';
				break;
			default:
				pair =' ';
			
		}
		return pair;
		
	}
	/**
	Method1:
	-we have three different types of parenthesis (, {, and [
	-if the count of parenthesis is odd then it is invalid
	-we keep track of the left paren and right paren, for every left paren there should be a right paren
	-we store the opening parenthesis in a stack and for every closing, we check if the stack has corresponding opening on the top,
	if not then it is invalid
	O(n), Space O(n)
	*/
	public static boolean isValid1(String s) {
        //base cases
		if(s==null||s.length()==0){
			return true;
		}
		if(s.length()%2!=0) //if odd length
			return false;
		Stack<Character> charStack = new Stack<Character>();
		for(char c:s.toCharArray()){
			//if opening, put in stack
			if(c=='{' || c=='(' || c=='['){
				System.out.println("pushing char: "+c+" to stack");
				charStack.push(c);
			}else{
				System.out.println("for char "+c+" pair is:"+getPair(c));
				if(charStack.isEmpty() || charStack.peek()!=getPair(c)){
					return false;
				}
				//matched so we pop the corresponding pair
				System.out.println("popping char:"+charStack.peek()+" from stack");
				charStack.pop();
			}
		}
		return charStack.isEmpty();
    }
	
	public static void main(String args[]){
		String s = "()";
		s = "()[]{}";
		s = "(]";
		s = "([)]";
		s = "{[]}";
		s= "((";
		System.out.println("isvalid1 for string "+s+" is:"+isValid1(s));
	}
}