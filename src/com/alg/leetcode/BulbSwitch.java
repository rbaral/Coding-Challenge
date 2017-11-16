/**
 * There are n bulbs that are initially off. You first turn on all the bulbs. 
 * Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or 
 * turning off if it's on). For the nth round, you only toggle the last bulb. 
 * Find how many bulbs are on after n rounds.

Example:

Given n = 3. 

At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off]. 

So you should return 1, because there is only one bulb is on.

 */
package com.alg.leetcode;

import java.util.Date;

public class BulbSwitch {

	public static void main(String[] args) {
		
		System.out.println(new Date());
		System.out.println(bulbSwitch(4));
		System.out.println(bulbSwitch(999999999));
		System.out.println(new Date());

	}
	
	public static int bulbSwitch(int n) {
        /*int totalOnValue=0,sqrtIntVal=0;
        double sqrtDoubleVal=0;
        for(int i=0;i<n;i++){
        	sqrtDoubleVal = Math.sqrt(i+1);
        	//sqrtIntVal = (int)sqrtDoubleVal;
            if(sqrtDoubleVal%1==0)
                totalOnValue++;
        }
        return totalOnValue;*/
		return (int)Math.sqrt(n);
    }
	
}
