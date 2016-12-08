/**
 * a function to check if the value of a binary number
(passed as a string) equals the hexadecimal representation of a string
 */
package com.alg.ctci;

/**
 * ref:Cracking the coding interview
 * @author rbaral
 *
 */
public class CompareBinToHex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String binary = "1010";//binary representation
		String hex = "A";//hex representation
		System.out.println(compareBinToHex(binary, hex));

	}

	public static boolean compareBinToHex(String binary, String hex) {
		int nl = convertToBase(binary, 2);
		int n2 = convertToBase(hex, 16);
		if (nl < 0 || n2 < 0) {
			return false;
		} else {
			return nl == n2;
		}
	}
	public static int digitToValue(char c) {
		//if is below 10
		if (c >= '0' && c <= '9'){
			return c - '0';
		}
		else if (c >= 'A' && c <= 'F'){//is between 10 and 15
			return 10 + c - 'A';
		}
		else if (c >= 'a' && c <= 'f'){//is between 10 and 15
			return 10 + c - 'a';
		}
		return -1;//is invalid
	}
	
	public static int convertToBase(String number, int base) {
		/**
		 * if the base is neither 2 nor 16
		 */
		if (base < 2 || (base > 10 && base != 16))
			return -1;
		int value = 0;
		/**
		 * from the rightmost char/digit, convert to the base value
		 */
		for (int i = number.length() - 1; i >= 0; i--) {
			int digit = digitToValue(number.charAt(i));
			if (digit < 0 || digit >= base) {
				return -1;
			}
			int exp = number.length() - 1 - i;
			value += digit * Math.pow(base, exp);
		}
		return value;
	}
}
