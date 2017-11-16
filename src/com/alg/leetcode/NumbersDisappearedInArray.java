/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
* 
* 
 * @author rbaral
 */
 
import java.util.Random;
 
public class NumbersDisappearedInArray {
    
	//this is O(n) solution but requires the extra space for the count array
    static List<Integer> findDisappearedNumbersUsingExtraSpace(int[] a){
		List<Integer> missings = new ArrayList<Integer>();
		int[] counts = new int[a.length+1];
        /*
		assuming the array is sorted, we can just compare the index with the value and if they differ, the
		number is most likely missing. We store such number in a list and if later encountered, we remove it
		from the list. The final list will contain the missed numbers
		*/
		for(int i=0;i<a.length;i++){
			//lets suppose the numbers are in the range 1....n
			counts[a[i]]+=1;
		}
		//counts contain the counts of all the elements, whose count is zero is missing
		for(int i=1;i<counts.length;i++){
			if(counts[i]<1){
				missings.add(i);
			}
		}
		return missings;
    }
	
	static List<Integer> findDisappearedNumbers(int[] a){
		List<Integer> missings = new ArrayList<Integer>();
		//first lets assume that every value is missing and record them
		for(int i=0;i <a.length; i++){
			missings.add(i,1);
		}
		//now iterate for every element and reset the missings flag
		//Iterate the missings list and remove the entries whose missing flag is reset
		//return the missings list
		return missings;
	}
    
    public static void main(String args[]){
        //lets create an array with randomly selected numbers
		Random ran = new Random();
		int arr[] = new int[20];
		for(int i=0;i<20;i++){
			//add a random number between 1 and 20
			arr[i] = ran.nextInt(20)+1;
		}
		//sort the array
		Arrays.sort(arr);
		for(int b:arr){
			System.out.println(b);
		}
		//from the description of question, it looks like the array is sorted
		List<Integer> disappeared = findDisappearedNumbers(arr);
		System.out.println("Disappeared are:");
		for(int i:disappeared){
			System.out.println(i);
		}
    }
}
