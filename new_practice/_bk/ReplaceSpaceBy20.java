/**
Given a string, write a method to replace the spaces with %20. Assume that the string has
enough space to hold the additional characters. Also design the method to operate inspace.
*/
public class ReplaceSpaceBy20{

public static String replaceSpaceBy20(String s){
	//handle base cases
	//base1: string empty, string null
	//base2: string does not have enough space to hold additional characters
	
	int p1 = s.trim().length()-1; //points to the actual last character
	int p2 = 0;//points to the last character which will be space to hold the additional characters
	//p2 should point to the poisition that is enought to hold the available space replacements, the given string might have additional spaces which we might not need
	//count the number of spaces
	int spaceCount = 0;
	char[] chars = s.toCharArray();
	for(int i=0;i<chars.length; i++){
		if(i>=p1) //dont count the spaces beyond the last character
			break;
		if(chars[i]==' '){
			spaceCount++;		
		}
	}
	System.out.println("total space count in "+s+" is:"+spaceCount);
	p2 = p1+2*spaceCount;
	
	while(p1<p2 && p1>=0){
		if(s.charAt(p1) == ' '){//if this is a space character, add %20 at the current position p2
			chars[p2] = '0';
			chars[--p2] = '2';
			chars[--p2] = '%';
			p1--;
			p2--;
		}else{
			chars[p2] = chars[p1];		
			p2--; 
			p1--;
		}
	}
return new String(chars);
}
	public static void main(String args[]){
		String s1 = "Hello World this is Java        "; //we have 4 spaces so we provide 8 additional space to hold the additional characters
		String s2 = replaceSpaceBy20(s1);
		System.out.println("The new string is:"+s2);
		
	}
}
