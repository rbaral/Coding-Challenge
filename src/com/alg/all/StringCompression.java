/**
String compression: compress a string representation using the count of characters, if the compressed string is not
shorter than the original one, return the original string. For instance, aaabbb should be compressed to a3b2, but aaab should be
returned as aaab because its compressed form a3b1 is not shorter than the original string aaab.
*/

public class StringCompression{
	
	/**
	Method 1:
	we can also use string concatenation as a brute force solution but this will take O(n^2) time
	*/
	
	
	/**
	Method 2:
	finds the compressed form of a string using hte count of the charaacters,
	if the compressed one is not shorter then returns the original string
	*/
	public static String getCompressedString(String s){
		//handle base cases, string of length<2 cannot be compressed to shorter form
		if(s==null || s.length()<2){
			return s;
		}
		//iterative scan the characters and keep track of the count of characters
		int charCount = 0;
		StringBuffer newStr = new StringBuffer();
		char curChar = s.charAt(0);
		for(int i=1; i<s.length(); i++){
			if(curChar == s.charAt(i)){//same character in consecutive positions
				charCount++;
			}else{
				newStr.append(curChar);
				newStr.append(++charCount);
				charCount=0;
				curChar = s.charAt(i);
			}
		}
		//add the character at last index and its count
		newStr.append(curChar);
		newStr.append(++charCount);
		//if the compressed string is shorter than the original, return the compressed one, else return the original one
		if(newStr.length()<s.length())
			return newStr.toString();
		else
			return s;
	}
	
	
	/**
	given a string, find the length of its compressed form
	*/
	public static int getCompressionLength(String s){
		//base cases
		if(s==null || s.length()==1){
			return 1;
		}
		int compLength = 0;
		//iteratively scan the string and check for the consecutive occurence of a character and record the count
		int curCount = 0;
		char curChar = s.charAt(0);
		for(int i=1; i<s.length(); i++){
			if(curChar == s.charAt(i)){//repeated character
				curCount++;
			}else{
				//the space required for a character and its count (it can be multiple digits so we convert count to string to find the length)
				compLength+=1+String.valueOf(++curCount).length();
				curCount=0;
				curChar = s.charAt(i);
			}
		}
		//take care of the final character which won't be handled due to loop termination
		compLength+=1+String.valueOf(++curCount).length();
		return compLength;
	}
	
	/**
	Method 3:
	if we are not allowed to use StringBuffer we can use the compressed string length to declare
	a character array and then populate the character array to get the final string
	*/
	public static String getCompressedStringWithoutStringBuffer(String s){
		int compLength = getCompressionLength(s);
		if(compLength>=s.length()){
			return s;
		}
		//create a char array to hold the characters and count of the compressed string
		char[] newStr = new char[compLength];
		int curIndex = -1; //to track the position of char in the new string
		int charCount = 1;
		char curChar = s.charAt(0);
		for(int i=1;i<s.length(); i++){
			if(curChar == s.charAt(i)){
				charCount++;
			}else{
				newStr[++curIndex] = curChar;
				//the count can be multiple digits so we need to fill the newStr accordingly
				char[] charCountsArr = String.valueOf(charCount).toCharArray();
				for(char c:charCountsArr){
					newStr[++curIndex] = c;
				}
				//after adding the previous character to the character array, we set the count to zero and set curchar to current one
				curChar = s.charAt(i);
				charCount = 1;
			}
		}
		
		//handle the last character that was not catched due to loop termination
		newStr[++curIndex] = curChar;
		//the count can be multiple digits so we need to fill the newStr accordingly
		char[] charCountsArr = String.valueOf(charCount).toCharArray();
		for(char c:charCountsArr){
			newStr[++curIndex] = c;
		}
		//return the new string
		return new String(newStr);
		
	}
	
	public static void main(String args[]){
		String s1 = "aaabbbc";
		System.out.println("compressed form of "+s1+" is :"+getCompressedString(s1));
		System.out.println("compressed form of "+s1+" without string buffer is :"+getCompressedStringWithoutStringBuffer(s1));
		String s2 = "aaab";
		System.out.println("compressed form of "+s2+" is :"+getCompressedString(s2));
		System.out.println("compressed form of "+s2+" without string buffer is :"+getCompressedStringWithoutStringBuffer(s2));
	}
}