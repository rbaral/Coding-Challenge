package com.alg.leetup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		int coinChange[][] = new int[2][];
		System.out.println(coinChange[0][0]);
	}
	
	public static int[] cloneArray(int[] nums,int index){
		int[] temp= new int[nums.length-1];
		//if it is the first element
		if(index ==0)
			System.arraycopy(nums, 1, temp, 0, temp.length);
		else if(index==nums.length-1)
			System.arraycopy(nums, 0, temp, 0, temp.length);
		else{//the index is somewhere in the middle
			System.arraycopy( nums, 0, temp, 0, index ) ;
			System.arraycopy( nums, index+1, temp, index, (nums.length -(index+1)) ) ;
		}
		return temp;
	}

}
