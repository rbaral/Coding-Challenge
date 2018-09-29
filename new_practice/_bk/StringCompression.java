/**
Given a string, compress it by using the count of the consecutive repeated characters. For e.g., for the string aaabcccc, the result should be a3b1c4. If the length of the compressed string is not less than the original string, return the original string.
*/
import java.lang.reflect.Array;
import java.util.Arrays;

public class StringCompression{
	
public static void main(String args[]){
	String s = "aaabcccc";
	//s = new String("aabbcc");
	String comp = getCompressedStringStringCharArray(s);
	System.out.println("String "+s+" is compressed to:"+comp);
}

//return the compressed string using StringBuffer
public static String getCompressedStringStringBuffer(String s){
	//check base cases - string null, string empty, string less than 3 characters
	if(getCompressionLength(s) == s.length()){
		//doesnt reduce the length, so return original
		return s;
	}else{
		//we check the count of the consecutive duplicates and add it to the string
		StringBuffer newstr = new StringBuffer();
		char[] charArr = s.toCharArray();
		char last = charArr[0];
		int count = 1;
		for(int i=1; i<charArr.length; i++){
			if(last==charArr[i]){
				count++;			
			}else{
				newstr.append(last);
				newstr.append(count);
				count = 1;
				last = charArr[i];			
			}
		}
		//also add the last character and its count
		newstr.append(last);
		newstr.append(count);
		return newstr.toString();
	}

}


/**
This method does the compression without using stringbuffer.
It defines the character array and fills the character array with the character and its count at the proper
index.
*/
public static String getCompressedStringStringCharArray(String s){
	//handle bases cases
	int complength = getCompressionLength(s);
	if(complength >=s.length()){
		return s;	
	}else{
		//we define character array and fill the character array
		char[] chars = new char[complength];
		int charsindex = 0;
		char[] charArr = s.toCharArray();
		int count = 1;
		char last = charArr[0];
		for(int i=1; i<charArr.length; i++){
			if(last==charArr[i]){
				count++;			
			}else{
				//not the same character, so add the character and its count to the chars
				charsindex = setChars(chars, charsindex, last, count);
				last = charArr[i];
				count = 1;
			}
		}
		setChars(chars, charsindex, last, count);
		return String.valueOf(chars);
	}
}

//a method to add the character and its count to the character array
public static int setChars(char[] chars, int index, char c, int count){
	chars[index] = c;
	index++;
	for(int j = 0;j<String.valueOf(count).length(); j++){
		chars[index] = String.valueOf(count).charAt(j);
		index++; 
	}
	return index;
}

//find the length of the compressed string
public static int getCompressionLength(String s){
char lastChar = s.charAt(0);
int count = 1;
char[] charArr = s.toCharArray();
int complength = 0;
for(int i=1; i<charArr.length; i++){
	if(charArr[i] == lastChar){
		count++;
	}else{
		complength+=1+String.valueOf(count).length();
		lastChar = charArr[i];
		count=1;
	}
}
//the last character should be added to the character count as well
complength+=1+String.valueOf(count).length();
return complength;
}

}
