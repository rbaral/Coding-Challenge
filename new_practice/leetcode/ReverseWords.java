/**
Given an input string, reverse the string word by word.

Example:  

Input: "the sky is blue",
Output: "blue is sky the".
Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
Follow up: For C programmers, try to solve it in-place in O(1) space.
*/
import java.util.*;

public class ReverseWords{
	public static String reverseWords(String s) {
        //base case
        if(s.trim().length()<1){
            return "";
        }
        s = s.trim();
        Stack<String> words = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        String[] tokens = s.split(" ");
        for(String token: tokens){
			if(token.trim().length()>0)
				words.push(token.trim());
        }
        //get back to the reverse string
        while(!words.isEmpty()){
            sb.append(words.pop());
            if(words.size()>0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
	
	public static void main(String[] args){
		String in = "the sky is blue";//Output: "blue is sky the".
		in = "   a   b ";//op: b a
		System.out.println("input is:"+in+"...");
		System.out.println("output is..."+reverseWords(in)+"...");
	}
}