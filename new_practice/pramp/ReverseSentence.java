/**
#Sentence Reverse

You are given an array of characters arr, which consists of sequences of characters separated by space characters. Each space-delimited sequence of characters defines a word. How can you most efficiently reverse the order of the words in the array? Explain and implement your solution. Lastly, analyze its time and space complexities.

For example:

[ 'p', 'e', 'r', 'f', 'e', 'c', 't', '  ', 'm', 'a', 'k', 'e', 's', '  ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' ]
would turn into:

[ 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', '  ', 'm', 'a', 'k', 'e', 's', '  ', 'p', 'e', 'r', 'f', 'e', 'c', 't' ]
*/

import java.util.*;

public class ReverseSentence{

	/**
	Method 1:
	-iterate through the character array and accumulate each word in a list
	-every time, keep on adding the new word in front of the list(can use stack as well)
	-while revoking the items from the stack/list, iterate through the characters of each word and dump back into
	the resulting char array
	O(n) - first pass for each character
	O(k) for each word to change back to character array
	O(nk)
	Space: O(n)
	*/
	public static char[] getReverseSentence(char[] chars){
		StringBuilder sb = new StringBuilder();
		Stack<String> words = new Stack<String>();
		for(int i=0;i<chars.length; i++){
			char c = chars[i];
			if(c==' ' || i==chars.length-1){// a word is completed
				if(i==chars.length-1)
					sb.append(c);
				words.push(sb.toString());
				sb = new StringBuilder();
			}else{
				//append the char to the string
				sb.append(c);
			}
		}
		//now convert back all the words in stack into character
		int index = 0;
		while(!words.isEmpty()){
			String s = words.pop();
			System.out.println("word is:"+s+"...");
			//convert the word to chars
			for(char c:s.toCharArray()){//tocharArray() is linear time
				chars[index++] = c;
			}
			//after the word, append space if this is not the last word
			if(words.size()>0){
				chars[index++]=' ';
			}
		}
		return chars;
	}
	
	public static void main(String[] args){
		char[] chars = new char[] {'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' };
		System.out.println("orignal char array is:"+String.valueOf(chars));
		char[] revchars = getReverseSentence(chars);
		System.out.println("reversed char array is:"+String.valueOf(revchars));
	}
}