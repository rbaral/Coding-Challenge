/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;

/**
 *
 * @author rbaral
 */
public class DigitToWord {

        public static String[] digits = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	public static String[] teens = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	public static String[] tens = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	public static String[] bigs = {"", "Thousand", "Million", "Billion"};
	
        public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}
        
	public static String numToString(int number) {
		if (number == 0) {
			return "Zero";
		}
		
		if (number < 0) {
			return "Negative " + numToString(-1 * number);
		}
		int count = 0;
		String str = "";
		
		while (number > 0) {
			if (number % 1000 != 0) {
				str = numToString100(number % 1000) + bigs[count] + " " + str;
			}
			number /= 1000;
			count++;
		}
		
		return str;
	}
	
	public static String numToString100(int number) {	
		String str = "";
		
		/* Convert hundreds place */
		if (number >= 100) {
			str += digits[number / 100 - 1] + " Hundred ";
			number %= 100;
		}
		
		/* Convert tens place */
		if (number >= 11 && number <= 19) {
			return str + teens[number - 11] + " ";
		} else if (number == 10 || number >= 20) {
			str += tens[number / 10 - 1] + " ";
			number %= 10;
		}
		
		/* Convert ones place */
		if (number >= 1 && number <= 9) {
			str += digits[number - 1] + " ";
		}
		
		return str;
	}
	
        
	public static void main(String[] args) {	
            
                /*
		// numbers between 100000 and 1000000 
		for (int i = 0; i < 8; i++) {
			int value = (int) Math.pow(10, i);
			String s = numToString(1 * value);
			System.out.println(value + ": " + s);
		}			
		
		// numbers between 0 and 100 
		for (int i = 0; i < 10; i++) {
			int value = randomIntInRange(0, 100);
			String s = numToString(value);
			System.out.println(value + ": " + s);
		}	
		
		// numbers between 100 and 1000 
		for (int i = 0; i < 10; i++) {
			int value = randomIntInRange(100, 1000);
			String s = numToString(value);
			System.out.println(value + ": " + s);
		}
		
		// numbers between 1000 and 100000 
		for (int i = 0; i < 10; i++) {
			int value = randomIntInRange(1000, 100000);
			String s = numToString(value);
			System.out.println(value + ": " + s);
		}		
		
		
		// numbers between 100000 and 100000000 
		for (int i = 0; i < 10; i++) {
			int value = randomIntInRange(100000, 100000000);
			String s = numToString(value);
			System.out.println(value + ": " + s);
		}	
		
		// numbers between 100000000 and 1000000000 
		for (int i = 0; i < 10; i++) {
			int value = randomIntInRange(100000000, 1000000000);
			String s = numToString(value);
			System.out.println(value + ": " + s);
		}			
                
		// numbers between 1000000000 and Integer.MAX_VALUE 
		for (int i = 0; i < 10; i++) {
			int value = randomIntInRange(1000000000, Integer.MAX_VALUE);
			String s = numToString(value);
			System.out.println(value + ": " + s);
		}
                */
                System.out.println(numToString(991));
	}

        
}
