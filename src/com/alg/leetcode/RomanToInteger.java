/**
 * Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 */

package com.alg.leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * TEST CASES:
 * CMXI
 * "DCXXI"
 * "MCMXCVI" 1996
 * 
 * @author rbaral
 *
 */
public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCVI"));

	}
	public static int romanToInt(String roman){
		if(roman==null||roman.trim().length()<1)
			return 0;
		int intValue=-1;
		intValue = getIntValue(roman);
		if(intValue<0){//was not caught by the switch-case statements
			char[] literals = roman.toCharArray();
			List<String> litOrder =new ArrayList<String>();
			litOrder.add("I");
			litOrder.add("V");
			litOrder.add("X");
			litOrder.add("L");
			litOrder.add("C");
			litOrder.add("D");
			litOrder.add("M");
			int lastIndex=-1,curIndex=-1;
			intValue=0;
			List<Integer> intValues = new ArrayList<Integer>();
			for(int i=0;i<literals.length;i++){
				curIndex = litOrder.indexOf(String.valueOf(literals[i]));
				//System.out.println(curIndex+"..."+lastIndex+"..."+intValue+"..."+Arrays.toString(intValues.toArray())+"..."+roman);
				if(i==0){
					intValues.add(getIntValue(String.valueOf(literals[i])));
					intValue+=intValues.get(intValues.size()-1);
				}
				else if(curIndex<=lastIndex){
					intValues.add(getIntValue(String.valueOf(literals[i])));
					intValue+=intValues.get(intValues.size()-1);
				}
				else{
					//System.out.println("subtracting"+String.valueOf(literals[i]));
					intValue-=intValues.get(intValues.size()-1);
					intValues.set(intValues.size()-1, getIntValue(String.valueOf(literals[i]))-intValues.get(intValues.size()-1));
					intValue+=intValues.get(intValues.size()-1);
				}
				lastIndex = curIndex;
			}
			/*System.out.println(intValue);
			intValue=0;
			for(int j=0;j<intValues.size();j++)
				intValue+=intValues.get(j);*/
		}
		
		return intValue;
	}
	
	public static int getIntValue(String roman) {
		int intValue = 0;
		switch (roman) {
		case "I":
			intValue = 1;
			break;
		case "V":
			intValue = 5;
			break;
		case "X":
			intValue = 10;
			break;
		case "L":
			intValue = 50;
			break;
		case "C":
			intValue = 100;
			break;
		case "D":
			intValue = 500;
			break;
		case "M":
			intValue = 1000;
			break;
		default:
			intValue = -1;

		}
		return intValue;
	}

}
