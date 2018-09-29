/**
Question taken from Pramp.com
Decrypt Message
An infamous gang of cyber criminals named "The Gray Cyber Mob", which is behind many hacking attacks and drug trafficking, has recently become a target for the FBI. After intercepting some of their messages, which looked like complete nonsense, the agency learned that they indeed encrypt their messages, and studied their method of encryption.

Their messages consist of lowercase latin letters only, and every word is encrypted separately as follows:

Convert every letter to its ASCII value. Add 1 to the first letter, and then for every letter from the second one to the last one, add the value of the previous letter. Subtract 26 from every letter until it is in the range of lowercase letters a-z in ASCII. Convert the values back to letters.

For instance, to encrypt the word "crime"

Decrypted message:	c	r	i	m	e
Step 1:	99	114	105	109	101
Step 2:	100	214	319	428	529
Step 3:	100	110	111	116	113
Encrypted message:	d	n	o	t	q
The FBI needs an efficient method to decrypt messages. Write a function named decrypt(word) that receives a string that consists of small latin letters only, and returns the decrypted word.

Explain your solution and analyze its time and space complexities.

Examples:

input:  word = "dnotq"
output: "crime"

input:  word = "flgxswdliefy"
output: "encyclopedia"
Since the function should be used on messages with many words, make sure the function is as efficient as possible in both time and space. Explain the correctness of your function, and analyze its asymptotic runtime and space complexity.

Note: Most programing languages have built-in methods of converting letters to ASCII values and vica versa. You may search the internet for the appropriate method.

Constraints:

[time limit] 5000ms

[input] string word

The ASCII value of every char is in the range of lowercase letters a-z.
[output] string
*/
import java.io.*;
import java.util.*;

public class DecryptMessage{
	
	public static int getASCII(char c){
		if(String.valueOf(c).toLowerCase().equals(String.valueOf(c))){
			//input is a lowercase letter
			return c-'a'+97;
		}else{
			//input is a uppercase letter
			return c-'A'+65;
		}
	}
	
	public static char getCharFromASCII(int val){
		return (char)val;
	}
	/**
	we reverse the given steps to encrypt a given word, the decryption step would be:
	- get ASCII value of each character
	- minus 1 from first character
	- except the first character subtract the ASCII value of previous char
	- for each character that are not in the ASCII range a-z, keep on adding 26 until all values are in the range
	- convert the ASCII values to the character values
	- O(n) to convert each character in input word to ASCII
	- O(n) subtracting the value of previous character of each character
	- O(k) adding 26 on the values to get them in the range of a-z
	- O(n) converting ascii values to char
	-Total time O(3n+k), Space O(n) to store the ASCII values of the each characters in input word
	-Asymptotic O(n)
	*/
	public static String decrypt(String word) {
		if(word==null || word.trim().length()<1){
			return word;
		}
		int[] asciivals = new int[word.length()];
		char[] orgchars = word.toCharArray();
		//convert to ascii val
		for(int i=0;i<orgchars.length; i++){
			asciivals[i] = getASCII(orgchars[i]);
		}
		
		//subtract the value of previous element
		for(int i=asciivals.length-1; i>0;i--){
			asciivals[i]-=asciivals[i-1];
		}
		//subtract 1 from the first char
		asciivals[0]-=1;
		//now keep on adding 26 until all values are in the range of a-z
		for(int i=0;i<asciivals.length;i++){
			while(asciivals[i]<getASCII('a')){
				asciivals[i]+=26;
			}
		}
		
		//convert ascii vals to char
		for(int i=0;i<asciivals.length; i++){
			orgchars[i] = (char)asciivals[i];
		}
		return String.valueOf(orgchars);
	}
  
	public static void main(String args[]){
		String word = "dnotq";
		System.out.println("decrypted of :"+word+" is: "+decrypt(word));
	}
}