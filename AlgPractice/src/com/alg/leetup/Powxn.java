/**
 * Implement pow(x, n).
 */
package com.alg.leetup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author rbaral
 *
 */
public class Powxn {
	private static DateFormat format = new SimpleDateFormat("YYYY-M-d:H:m:s:S");
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x=10;
		int n = 3;
		System.out.println(format.format(new Date()));
		System.out.println(myPow(x, n));
		System.out.println(format.format(new Date()));
		System.out.println(myPowNaiveBayes(x, n));
		System.out.println(format.format(new Date()));
	}
	
	/**
	 * though simple, this has TIME EXCEEDS problem
	 * the naive bayes approach simply keeps on multiplying
	 * x by itself n times
	 * @param x
	 * @param n
	 * @return
	 */
	public static double myPowNaiveBayes(double x, int n) {
			double power =1;
			for(int i=0;i<n;i++){
				power = power*x;
			}
			return power;
	}

	/**
	 * this solution uses the recursive approach and has relatively
	 * better performance than the NaiveBayes
	 * @param x
	 * @param n
	 * @return
	 */
	public static double myPow(double x, int n){
		//handle the base cases
		if (n == 0)
			return 1;
		if (n == 1)
			return x;
		// keep track of the positive/negative n
		int pn = n > 0 ? n : -n;
		//temporarily store the pn value as we will manipulate the original pn value later
		int pn2 = pn;
		// keep track of the positive/negative x
		double px = x > 0 ? x : -x;
		double result = px;
	 
		int k = 1;
		/**
		 * the key part of solving this problem is somewhat similar
		 * to the NaiveBayes but here, we multiply for every other
		 * increment of the power
		 */
		while (pn / 2 > 0) {
			result = result * result;
			pn = pn / 2;
			k = k * 2;
		}
	 
		//recursively do the computation for the remining power
		result = result * myPow(px, pn2 - k);
	 
		// handle negative result
		if (x < 0 && n % 2 == 1)
			result = -result;
	 
		// handle negative power
		if (n < 0)
			result = 1 / result;
	 
		return result;
	}
}
