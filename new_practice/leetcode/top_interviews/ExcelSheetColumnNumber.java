/**
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
Example 1:

Input: "A"
Output: 1

Example 2:

Input: "AB"
Output: 28

Example 3:

Input: "ZY"
Output: 701
*/
import java.lang.Math;

public class ExcelSheetColumnNumber{
	/**
	-for every character starting from right we can multiply 26^i and keep on adding the power as we move left
	-the base value is 1 for A and increases by 1 for each sequential letter (e.g., B=2, C = 3)
	*/
	public static int getValue(String s){
		int sum = 0;
		for(int i=s.length()-1; i>=0;i--){
			char c = s.charAt(i);
			sum+=Math.pow(26, s.length()-1 -i)*(c -'A' + 1);
		}
		return sum;
	}
	
	public static int getValue2(String s){
		int result = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            result = result * 26 + (c - 'A') + 1;
        }
        return result;
	}
	public static void main(String args[]){
		String s = "ZY";
		
		System.out.println(getValue2(s));
	}

}