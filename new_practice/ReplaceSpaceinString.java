/**
replace every space character with %20
-given there is enough space at the end to hold the additional characters
*/
public class ReplaceSpaceinString{
	
	/**
	-count the number of space characters
	-scan from end by keeping track of the pointer to actual character and the pointer to end of the string
	-if space character is found, add %20 at the end, else move the non-space character to the end
	*/
	public static String replaceSpace(String s){
		int spaceCount = 0;
		int charLastIndex = -1;
		char[] chars = s.toCharArray();
		for(int i=chars.length-1; i>=0; i--){
			if(charLastIndex<0 && chars[i]!=' '){
				charLastIndex = i;
			}
			if(chars[i]==' '){
				spaceCount++;
			}
		}
		int charCount = chars.length - spaceCount;
		//base case, check if there is enough space at the end of the given string
		int endPointer = s.length() - 1;
		int charPointer = charLastIndex;
		while(charPointer>0 && endPointer>0){
			if(chars[charPointer]==' '){
				chars[endPointer] = '0';
				chars[--endPointer] = '2';
				chars[--endPointer] = '%';
			}else{//nonspace character
				chars[endPointer] = chars[charPointer];
			}
			endPointer--;
			charPointer--;
		}
		return new String(chars);
		
	}
	
	public static void main(String args[]){
		String s1 = "ab cd e    ";
		System.out.println("for string "+s1+" the new form is "+replaceSpace(s1));
	}
}