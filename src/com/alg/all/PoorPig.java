/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetcode;

/**
 *There are 1000 buckets, one and only one of them contains poison, the rest are filled with water. They all look the same. If a pig drinks that poison it will die within 15 minutes. What is the minimum amount of pigs you need to figure out which bucket contains the poison within one hour.

Answer this question, and write an algorithm for the follow-up general case.

Follow-up:

If there are n buckets and a pig drinking poison will die within m minutes, how many pigs (x) you need to figure out the "poison" bucket within p minutes? There is exact one bucket with poison.
* 
* 
* Ref:http://massivealgorithms.blogspot.com/2016/11/leetcode-458-poor-pigs.html
* https://www.glassdoor.com/Interview/There-are-1000-buckets-one-of-them-contains-poison-the-rest-are-filled-with-water-They-all-look-the-same-If-a-pig-drink-QTN_175255.htm
* 
 * @author rbaral
 */
public class PoorPig {
    
    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets--==1){
            return 0;
        }
        int base=minutesToTest/minutesToDie+1;
        int count=0;
        while (buckets>0){
            buckets/=base;
            count++;
        }
        return count;
    }
    
    public static void main(String args[]){
        int buckets = 1000;
        int minsToDie = 15;
        int minsToTest = 60;
        System.out.println(""+poorPigs(buckets, minsToDie, minsToTest));
    }
}
