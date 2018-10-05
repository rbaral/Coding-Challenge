/**
A string of brackets is considered correctly matched if every opening bracket in the string can be paired up with a later closing bracket, and vice versa. For instance, "(())()" is correctly matched, whereas ")(" and "((" aren’t. For instance, "((" could become correctly matched by adding two closing brackets at the end, so you’d return 2.

Given a string that consists of brackets, write a function bracketMatch that takes a bracket string as an input and returns the minimum number of brackets you’d need to add to the input in order to make it correctly matched.

Explain the correctness of your code, and analyze its time and space complexities.

Examples:

input:  text = "(()"
output: 1

input:  text = "(())"
output: 0

input:  text = "())("
output: 2
Constraints:

[time limit] 5000ms

[input] string text

1 ≤ text.length ≤ 5000
[output] integer
*/

import java.util.*;

public class BracketMatch{
	
	
   /**
	Method1:
  -adding the braces to a stack
  -every time for a new braces, check if it forms a pair with the stack top
  -if it forms pair, we can poll from the stack
  
  Example: (()
  (
  push ( 
  (
  push(
  )
  found a pair with the stack top
  poll from stack and we are left with 1 braces in stack
  the size of the stack is number of braces we need
  
  Example: ())(
  (
  push (
  )
  match, pop()
  )
  push )
  (
  // first one is closing and second one is opening so they dont' form a pair
  push the last char in stack
  no more chars left in given string
  return stack size as answer
  PASSED ALL TESTS
  */
  static int bracketMatch1(String text) {
    // your code goes here
    //base cases
    if(text==null || text.trim().length()<1){
      return 0;
    }
    if(text.trim().length()==1){
      return 1;
    }
    
    Stack<Character> chars = new Stack<Character>();
    for(char c: text.toCharArray()){
      if(chars.isEmpty() || !isPair(chars.peek(), c)){
        chars.push(c);
      }else if(isPair(chars.peek(), c)){
        chars.pop();
      }
    }
    return chars.size();
  }
  
  /**
  Method2:
  -use counters to keep track of the number of left and right brackets
  -for each right bracket encountered, reduce the number of left brackets if they are adjacent
  -the left over count is the desired value
  PASSED ALL TESTS
  */
  public static int bracketMatch2(String text){
	  //base case
	if(text==null || text.trim().length()<1){
      return 0;
    }
    if(text.trim().length()==1){
      return 1;
    }
	int leftcount = 0, rightcount = 0;
	char prev = '*'; //any arbitrary char
	for(char c: text.toCharArray()){
		if(c==')' && prev=='(' || c==')' && leftcount==1){//this forms a pair with the previous braces
			leftcount--;
		}else if(c==')'){
			rightcount++;
		}else{
			leftcount++;
		}
		prev = c;
	}
	System.out.println("for string:"+text+".."+leftcount+"..."+rightcount);
	return leftcount+rightcount;
  }
  
  public static boolean isPair(char c1, char c2){
    if(c1=='(' && c2==')'){
      return true;
    }else{
      return false;
    }
  }
  

  public static void main(String[] args) {
    String text = "(()";
    //System.out.println(isPair('(', ')'));
    //System.out.println(isPair(')', ')'));
    //System.out.println(isPair(')', '('));
    int op = bracketMatch1(text);
    System.out.println("braces required to match:"+op+"  from second method:"+bracketMatch2(text));
    text = "(())";
    op = bracketMatch1(text);
    System.out.println("braces required to match:"+op+"  from second method:"+bracketMatch2(text));
    text = "())(";
    op = bracketMatch1(text);
    System.out.println("braces required to match:"+op+"  from second method:"+bracketMatch2(text));
    
  }
}