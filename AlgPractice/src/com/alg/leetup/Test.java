package com.alg.leetup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		int nums[]=new int[]{-1, 0, 1, 2, -1, -4};
		int test[] = nums.clone();
		System.out.println(Arrays.toString(nums));
		test[0]=100;
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(test));
		DateFormat format = new SimpleDateFormat("YYYY-M-d:H:m:s:S");
		System.out.println(format.format(new Date()));
		

	}

}
