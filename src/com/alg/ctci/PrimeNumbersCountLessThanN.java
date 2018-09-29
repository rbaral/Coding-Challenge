/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * 
 * @author rbaral
 */
public class PrimeNumbersCountLessThanN {
    
    /**
     * find the number of prime numbers from 1 to n-1
     * 
     * Solution:
     * 
     * this is relied on the fact that every non-prime is divisible by a prime number.
     * first we assume that 0 and 1 are not prime and rest are prime
     * and starting from 2 onwards, we reset the flag for the multiples of 2
     * till we reach the given number (e.g., 2*2 is not prime, 2*3 is not prime and so on)
     * Next we advance this number to 3 and do the same thing until we are done with the
     * value equal to the given number.
     * 
     * @param n
     * @return 
     */
    
    /**
     * 
     * @param flags 
     */
    static void init(boolean[] flags){
        for(int i=0;i<flags.length;i++){
            if(i<=1){
                flags[i] = false;
            }else{
                flags[i] = true;
            }
            
        }
    }
    static boolean[] getPrimes(int max) {
        boolean[] flags = new boolean[max + 1];
        int count = 0;

        init(flags); // Set all flags to true other than 0 and 1
        int prime = 2;

        while (prime <= Math.sqrt(max)) {
            /* Cross off remaining multiples of prime */
            crossOff(flags, prime); //set prime flag to false if the number is a multiple of a prime

            /* Find next value which is true */
            prime = getNextPrime(flags, prime);

            if (prime >= flags.length) {
                break;
            }
        }

        return flags;
    }

    static void crossOff(boolean[] flags, int prime) {
        /* Cross off remaining multiples of prime. We can start with
        * (prime*prime), because if we have a k * prime, where
         * k < prime, this value would have already been crossed off in
         * a prior iteration. */
        for (int i = prime * prime; i < flags.length; i+= prime) {
            flags[i] = false;
        }
    }

    static int getNextPrime(boolean[] flags, int prime) {
        int next = prime + 1;
        //if the next candidate is within the range and its flag indicates it's not prime
        while (next < flags.length && !flags[next]) {
            next++;
        }
        return next;
    }

    static int countPrimes(int n) {
        boolean [] arr = getPrimes(n);
        int primeCount = 0;
        for(int i=0;i<n;i++){
            if(arr[i]){
                primeCount++;
            }
        }
        return primeCount;
    }
    
    public static void main(String args[]) {
        System.out.println("prime counts are:"+countPrimes(5));
    }
}
