/**
Given a method isSubString(s1, s2) that checks if one word is a substring of another, write a
method to find if one string is a rotation of another, by just making a single call to isSubstring(). 
For instance, the word erbottle is a rotation of the string waterbottle.
*/

public class CheckStringRotation{
	
	/**
	this is the given method that checks if the second string is a substring of the first string
	*/
	public static boolean isSubString(String s1, String s2){
		return s1.contains(s2);
	}
	
	/**
	we concatentation one string to itself and check if the other string is a substring of the concatentation string.
	As an example, waterbottle+waterbottle will be waterbottlewaterbottle and the string erbottlewat will be the substring
	of the concatentation string. The main challenge is to use efficient string concatentation method.
	As the simple string concatenation using + symbol is O(n^2), we need to use StringBuilder to make it O(n).
	*/
	public static boolean isRotation(String s1, String s2){
		//base case- if two strings are of different length they cannot be a rotation
		if(s1==null || s2==null || (s1.length()!=s2.length()))
			return false;
		StringBuilder sb = new StringBuilder();
		sb.append(s1);
		sb.append(s1);
		return isSubString(sb.toString(), s2);
	}
	
	public static void main(String args[]){
		String s1 = "erbottlewas";
		String s2 = "waterbottle";
		System.out.println("rotation check of "+s1+" and "+s2+" is "+isRotation(s1,s2));
	}
}