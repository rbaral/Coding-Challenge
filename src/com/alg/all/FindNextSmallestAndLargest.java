/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci.bitnbytes;

/**
 *Given a positive integer, print the next smallest and the next largest number that
have the same number of 1 bits in their binary representation.
* 
* NOTE:
* For 11, 1100, 00 there is not a bigger number
* with same number of 1s
* 
 * @author rbaral
 */
public class FindNextSmallestAndLargest {
    
    static int getSmallWithSame1Bits(int n){
        /**
         * find the count of zeros and ones
         * after the rightmost non-trailing zero bit
         */
        int c = n;
        int c0 = 0;
        int c1 = 0;
        //find zeros
        while(((c&1)==0) &&(c!=0)){
            c0++;
            c=c>>1;
        }
        //find ones
        while((c&1)==1){
            c1++;
            c=c>>1;
        }
        //the non-trailing zeros position is c0+c1
        if(c0+c1==31 || c0+c1==0){
            return -1;
        }
        int p = c0+c1; //position of rightmost non trailing zero
        n = n&(1<<p); //flip the rightmost non-trailing one to zero
        n&=~((1<<p)-1); // clear all bits on right of pth bit
        n|=(1<<(c1+1)) -1;//insert (c1-1) 1 bits on the right side
        return n;
    }
    
    static int getGreaterwithSame1Bits(int n){
        /**
         * find the count of zeros and ones
         * after the rightmost non-trailing zero bit
         */
        int c = n;
        int c0 = 0;
        int c1 = 0;
        //find zeros
        while(((c&1)==0) &&(c!=0)){
            c0++;
            c=c>>1;
        }
        //find ones
        while((c&1)==1){
            c1++;
            c=c>>1;
        }
        //the non-trailing zeros position is c0+c1
        if(c0+c1==31 || c0+c1==0){
            return -1;
        }
        int p = c0+c1; //position of rightmost non trailing zero
        n = n|(1<<p); //flip the rightmost non-trailing zero
        n&=~((1<<p)-1); // clear all bits on right of pth bit
        n|=(1<<(c1-1)) -1;//insert (c1-1) 1 bits on the right side
        return n;
    }
    
    public static void main(String args[]){
        System.out.println(getSmallWithSame1Bits(5));
        System.out.println(getGreaterwithSame1Bits(36));
    }
    
}
