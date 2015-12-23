package com.alg.leetup;

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
