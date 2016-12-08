/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ccup;

import java.util.Arrays;
import java.util.Random;

/**
 * You have a sorted array containing the age of every person on Earth.
 * 
 * [0, 0, 0,......, 1,1,1,....., 110,...]
 * 
 * Find out how many people have each age.
 * 
 * In the first observation, it looks like we can scan through all the elements of the array
 * and store the count in a HashTable and updat the count accordingly.
 * Though this takes O(n) time to scan the array, the big size of array might not be a good fit for this
 * solution, also we are not using the given fact that the numbers are sorted.
 * 
 * So, we are trying an alternative solution using the binary search to look for smaller than and greater than.
 * the difference between the indices of smaller and grater than element gives the count.
 *
 * @author rbaral
 */
public class CountPeopleOfEachAge {
    
    static int[] count(int[] ages){
        int[] counts = new int[ages[ages.length-1]+1]; //just create the array with slots for each age
        count(ages, 0, ages.length-1, counts);
        return counts;
    }
    
    static void count(int[] ages, int start, int end, int[] counts){
        if(ages[start]== ages[end]){//this is the window for same age
            counts[ages[start]]+= end-start+1;
        }else{
            count(ages, start, (start+end)/2, counts);
            count(ages, (start+end)/2 +1, end, counts);
        }
    }
    
    public static void main(String args[]){
        //lets create a sample age array
        int [] ages = new int[500];
        Random rand = new Random();
        for(int i=0;i<500;i++){
            ages[i] = rand.nextInt(125);
        }
        Arrays.sort(ages);
        
        for(Integer a: ages){
            System.out.println(""+a);
        }
        
        
        int[] agesCount = count(ages);
        for(int i=0; i<125; i++){
            System.out.println("age:"+i+" count "+agesCount[i]);
        }
    }
}
