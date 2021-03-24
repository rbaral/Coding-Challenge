/**
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: "III"
Output: 3
Example 2:

Input: "IV"
Output: 4
Example 3:

Input: "IX"
Output: 9
Example 4:

Input: "LVIII"
Output: 58
Explanation: C = 100, L = 50, XXX = 30 and III = 3.
Example 5:

Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/

/**
Sol1:
-store the roman letters in a list in the order of increasing value
-scan the given string from left to right
--if it is the first character of iteration(at index 0), simply add the value of this literal to the sum and keep track of its index
--if the index of last element is less than the current element, subtract the value of last index from the current indexed element
*/
import java.util.Map;
import java.util.HashMap;

public class RomanToInteger{
	
	public static int getRomanToInt(String s){
		//base case
		if(s==null || s.trim().length()==0){
			return 0;
		}
		//add the roman literals in a map to keep track of their order and value
		Map<Character, Integer> litvalueMap = new HashMap<Character, Integer>();
		//initalize the map
		litvalueMap.put('I', 1);
		litvalueMap.put('V', 5);
		litvalueMap.put('X', 10);
		litvalueMap.put('L', 50);
		litvalueMap.put('C', 100);
		litvalueMap.put('D', 500);
		litvalueMap.put('M', 1000);
		int val = 0;
		//to keep track of the index of the current and last roman letter
		int curindex = -1;
		int lastindex = -1;
		for(int i=0; i<s.length(); i++){
			if(i==0){
				val+=litvalueMap.get(s.charAt(i));
				curindex = litvalueMap.get(s.charAt(i));
			}else{
				//check if the last and current index are aligned for addition or subtraction
				curindex = litvalueMap.get(s.charAt(i));
				//now check if we need to do addition or subtraction
				if(curindex<=lastindex){
					val+=litvalueMap.get(s.charAt(i));
				}else{
					//we subtract twice, one for the faulty addition we made in previous iteration and one for the proper pairing of the two literals
					val+=litvalueMap.get(s.charAt(i)) - lastindex - lastindex;
				}
			}
			lastindex = curindex;
		}
		return val;
	}
	public static void main(String args[]){
		String s = "VIII";
		System.out.println("Roman "+s+" has value of: "+getRomanToInt(s));
	}
}