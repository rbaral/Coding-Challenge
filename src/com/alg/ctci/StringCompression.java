/**
Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become
a2blc5a3. If the "compressed" string would not become smaller than the original
string, your method should return the original string
* 
* NOTE:
* As the string concatenation is expensive (O(n^2)), we can use StringBuffer to make this method more effective
*/

package com.alg.ctci;

public class StringCompression{
	
	/**
	compress the string by using the count of same chars
	in adjacent position. If the compressed string is not 
	smaller than the original one, returns the original one
	*/
	static String compressString(String a){
		String compressedString ="";
		int duplicateCount = 0;
		for(int i=0;i<a.length();i++){
			if(i==0){//for the first char we just append to the new string
				compressedString+=a.charAt(i);
			}else{
				//now if the previous string is same as current one, increase the count
				if(a.charAt(i)==a.charAt(i-1)){
					duplicateCount++;
				}else{//this is another character
					//if we have incremented the duplicateCount, append that number first and append the current char
					if(duplicateCount>0){
						compressedString+=String.valueOf(duplicateCount+1); //one for the first one and the rest for the duplicates
						duplicateCount=0;//reset the count
					}
					//just append the new char
					compressedString+=a.charAt(i);
					
				}
			}
			//if the last char is duplicate then it's count should be added too
			if(duplicateCount>0 && i==a.length()-1){//this was for the last char, so just append the count
				compressedString+=String.valueOf(duplicateCount+1); //one for the first one and the rest for the duplicates
			}
		}
		
		
		return (compressedString.length()<a.length()?compressedString:a);
	}
	
	
	public static void main(String args[]){
		
		String a ="aaabc"; //should be compressed to a3bc
		System.out.println("compressed of "+a+" is:"+compressString(a));
		a="abbbc";
		System.out.println("compressed of "+a+" is:"+compressString(a));//should return compressed string ab3c
		a="abbbccaa";
		System.out.println("compressed of "+a+" is:"+compressString(a));//should return compressed string ab3c2a2
		a = "aabc"; //compressed is a2bc which is of same length as original, so we should get original one
		System.out.println("compressed of "+a+" is:"+compressString(a));
	}
}