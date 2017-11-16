package com.alg.leetcode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Update (2014-11-10):
Test cases had been added to test the overflow behavior.
 */
/**
 * 
 * @author rbaral
 *
 */
public class ReverseInteger {

	public static void main(String args[]){
		boolean testEnabled = false;
		if(testEnabled){
			performTest();
		}else{
			DateFormat format = new SimpleDateFormat("YYYY-M-d:H:m:s:S");
			System.out.println(format.format(new Date()));
			int num=-1235;
			System.out.println("output is:"+reverse(num));
			System.out.println(format.format(new Date()));
		}
	}
	
	public static int reverse(int x) {
            if(x>=0 && x<10)
                return x;
            String sresult="";
            String snum = String.valueOf(x);
            boolean isNegative = false;
            int result=0;
            if(x<0){
                isNegative = true;
                snum = String.valueOf(-x);
            }
            for(int i=snum.length()-1;i>=0;i--){
                sresult+=String.valueOf(snum.charAt(i));
            }
            try{
                    result = Integer.parseInt(sresult);
            }catch(NumberFormatException nex){
                    result=0;
            }

            if(result>Integer.MAX_VALUE)
                return 0;
            if(isNegative)
                return -result;
            else
                return result;
    }

	
	public static void performTest(){
		
		Map<Integer,Integer> testCases= new HashMap<Integer,Integer>();
		List<String> failedCases = new ArrayList<String>();
		int result=0;
		testCases.put(123, 321);
		testCases.put(-123, -321);
		testCases.put(10, 1);//not 01
		testCases.put(1000000003, 0);//overflows for 32 bit integer, so return 0, instead
		testCases.put(-2147483648, 0);//overflows for 32 bit integer, so return 0, instead
		
		for(int testCase: testCases.keySet()){
			result = reverse(testCase);
			if(result!=testCases.get(testCase)){
				failedCases.add("Failed for:{"+testCase+"} got:"+result+" expected:"+testCases.get(testCase));
			}
		}
		System.out.println("TEST RESULT, Passed:"+(testCases.size()-failedCases.size())+" failed:"+failedCases.size());
		for(String failure:failedCases)
			System.err.println(failure);
	}
}
