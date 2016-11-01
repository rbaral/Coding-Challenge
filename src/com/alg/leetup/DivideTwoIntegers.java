/**
 * Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
 */
package com.alg.leetup;

/**
 * @author rbaral
 *
 */
public class DivideTwoIntegers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int dividend =10, divisor =3;
		System.out.println(divide(dividend, divisor));

	}
	
	/**
	 * divides two integers without using mul,division and mod operator
	 * ref:http://www.programcreek.com/2014/05/leetcode-divide-two-integers-java/
	 * @param dividend is the number that is being divided
	 * @param divisor is the number which divides
	 * @return
	 */
	public static int divide(int dividend, int divisor) {
		//base cases
	    if(divisor==0) return Integer.MAX_VALUE;
	    if(divisor==-1 && dividend == Integer.MIN_VALUE)
	        return Integer.MAX_VALUE;
	 
	    //get long positive values
	    long pDividend = Math.abs((long)dividend);
	    long pDivisor = Math.abs((long)divisor);
	 
	    int result = 0;
	    //repeat till the divisor at least equal to the dividend
	    while(pDividend>=pDivisor){
	        //calculate number of left shifts
	        int numShift = 0;    
	      //figure out how many shifts are required to have divisor at least equal to the dividend
	        while(pDividend>=(pDivisor<<numShift)){
	            numShift++;
	        }
	        result += 1<<(numShift-1);
	        //find out the dividend minus the largest shifted divisor
	        pDividend -= (pDivisor<<(numShift-1));
	    }
	 
	    if((dividend>0 && divisor>0) || (dividend<0 && divisor<0)){
	        return result;
	    }else{
	        return -result;
	    }
	}

}
