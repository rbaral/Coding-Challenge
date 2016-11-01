/**
 * Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

For example:
"112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
"199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
1 + 99 = 100, 99 + 100 = 199
Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Follow up:
How would you handle overflow for very large input integers?
 */
//ref:http://bookshadow.com/weblog/2015/11/18/leetcode-additive-number/
package com.alg.leetup;

import java.util.ArrayList;
import java.util.List;

class AdditiveNumberTestCase{
	String num;
	boolean additive;
	
	public AdditiveNumberTestCase(String num, boolean add){
		this.num = num;
		this.additive = add;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public boolean isAdditive() {
		return additive;
	}
	public void setAdditive(boolean additive) {
		this.additive = additive;
	}
	
	public String toString(){
		return "For string num:"+getNum()+" expected is:"+isAdditive();
	}
	
}
/**
 * @author rbaral
 *
 */
public class AdditiveNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean isTestMode = true;
		if(isTestMode){
			performTest();
		}else{
			String num ="123";
			System.out.println(isAdditiveNumber(num));
		}

	}

	/**
	 * recursively finds the sum of the first two numbers and check if it is
	 * equal to the third number. If the third number is equal to the sum of the first
	 * and the second number, then we have got the additive numbers, else we advance
	 * the pointers
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static boolean search(String a, String b, String c){
		String d = String.valueOf(Long.parseLong(a) + Long.parseLong(b));
		if(Long.parseLong(d)>Integer.MAX_VALUE)
			return true;
		if(!isValid(d) || !c.startsWith(d))
            return false;
        if(c.equals(d))
            return true;
        //if the remaining string is exhausted before we found the additive numbers
        if(c.trim().length()<d.length())
        	return false;
        System.out.println(c.trim().length());
        return search(b, d, c.substring(d.length()));
	}
	/**
	 * checks if the number has 0 at the beginning
	 * @param nums
	 * @return
	 */
	public static boolean isValid(String nums){
		return nums.length()==1 || nums.charAt(0)!='0';
	}
	
	/**
	 * 
	 * @param num
	 * @return
	 */
	public static boolean isAdditiveNumber(String num) {
		String a, b, c;
		for(int i=1;i<num.length();i++){
			for(int j=i+1;j<num.length();j++){
				a = num.substring(0,i);
				b = num.substring(i, j);
				c = num.substring(j);
				if(!isValid(a) || !isValid(b))
					continue;
				if(search(a,b,c)){
					return true;
				}
			}	
		}
		return false;
	}
	

    public static void performTest(){
		List<AdditiveNumberTestCase> testCases = new ArrayList<AdditiveNumberTestCase>();
		List<String> failedCases = new ArrayList<String>();
		testCases.add(new AdditiveNumberTestCase("112358", true));
		testCases.add(new AdditiveNumberTestCase("1123581", false));
		testCases.add(new AdditiveNumberTestCase("101235813", false));
		testCases.add(new AdditiveNumberTestCase("1023", false));
		testCases.add(new AdditiveNumberTestCase("211738", true));
		testCases.add(new AdditiveNumberTestCase("111122335588143", true));
		testCases.add(new AdditiveNumberTestCase("123", true));
		boolean result;
		for(AdditiveNumberTestCase testCase:testCases){
			result = isAdditiveNumber(testCase.getNum());
			
			if(testCase.isAdditive()!=result){
				failedCases.add("Failed for:"+testCase.getNum()+"...got:"+result+"..expected:"+testCase.isAdditive());
			}else{
				System.out.println("for:"+testCase.getNum()+" expected:"+testCase.isAdditive()+" got:"+result);
			}
		}
		System.out.println("TEST RESULT: PASSED "+(testCases.size() - failedCases.size())+"... FAILED.."+failedCases.size());
		for(String res:failedCases){
			System.err.println(res);
		}
	}
}
