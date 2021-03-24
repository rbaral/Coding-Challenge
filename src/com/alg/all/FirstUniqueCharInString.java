/**
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
*/

public class FirstUniqueCharInString{
	
	/**
	Method1:
	-use two nested loops and check if a char occurs or not
	O(n^2)
	*/
	public static int getfirstUnique1(String s){
		//base case
		if(s==null)
			return -1;
		if(s.length()==1)
			return 0;
		int index = -1;
		for(int i=0;i<s.length();i++){
			//assume it is unique and set index to its index
			index=i;
			for(int j=0;j<s.length();j++){
				if(i!=j){
					if(s.charAt(i)==s.charAt(j)){
						index=-1;
						break;
					}
				}
			}
			if(index>=0){//found one, no need to check subsequent characters in the string
				return index;
			}
		}
		return index;
	}
	
	/**
	Method2:
	-in first pass, lets store the count of each character in an array, we assume only ASCII characters are present
	-in second pass, find the first entry in count array whose count is 1, if none found, return -1
	O(n), Space O(n)
	*/
	public static int getfirstUnique2(String s){
		if(s==null || s.length()<1)
			return -1;
		if(s.length()==1)
			return 0;
		int[] counts = new int[256];
		for(char c:s.toCharArray()){
			counts[(int)c]++;
		}
		//in the second pass check the char with count 1
		int index = 0;
		for(char c:s.toCharArray()){
			if(counts[(int)c]==1){
				return index;
			}
			index++;
		}
		return -1;
	}

	public static void main(String args[]){
		String s = "leetcode";
		s= "ss";
		s= "loveleetcode";
		s= "aadadaad";
		s= "dddccdbba";
		System.out.println("first unique1:"+getfirstUnique1(s));
		System.out.println("first unique2:"+getfirstUnique2(s));
	}
	
}