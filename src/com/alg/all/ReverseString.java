/**
Write a function that takes a string as input and returns the string reversed.

Example 1:

Input: "hello"
Output: "olleh"
Example 2:

Input: "A man, a plan, a canal: Panama"
Output: "amanaP :lanac a ,nalp a ,nam A"
*/

public class ReverseString{
	
	/**
	Method1:
	-use stack to store the characters and pop the characters to build a new string
	O(n) time, O(n) space for stack, O(n) space for new string
	Method2:
	-iterate through the characters of the given string and build a new string by appending the characters to StringBuffer
	O(n) time to iterate string, O(n) space for new string
	*/
	public static String reverse1(String s){
		//base case
		if(s==null || s.trim().length()<2){
			return s;
		}
		StringBuffer sb = new StringBuffer();
		for(char c:s.toCharArray()){
			sb.insert(0,String.valueOf(c));
		}
		return sb.toString();
	}
	
	/**
	Method2: use two pointers p1 and p2
	-p1 points to the first character and p2 points to the last character
	-iterate till p1<p2 and swap the characters at p1 and p2, advance p1 by +1 and p2 by -1
	O(n/2) time, O(1) space
	*/
	public static String reverse2(String s){
		//base case
		if(s==null || s.trim().length()<2){
			return s;
		}
		//create two pointers
		int p1 = 0;
		int p2 = s.length()-1;
		char[] chars = s.toCharArray();
		while(p1<p2){
			//swap
			char temp = chars[p1];
			chars[p1] = chars[p2];
			chars[p2] = temp;
			p1++;
			p2--;
		}
		return String.valueOf(chars);
	}
	
	public static void main(String args[]){
		String s1 = " apG0i4maAs::sA0m4i0Gp0"; //"hello";
		System.out.println("reverse1:"+ reverse1(s1)+"...");
		System.out.println("reverse2:"+ reverse2(s1)+"...");
	}
}