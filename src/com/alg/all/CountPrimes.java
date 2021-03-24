/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.todo.sol;

/**
 *
 * Count the number of prime numbers less than a non-negative number, n.
 *
 *
 * Solution 1: 1)
 *
 * @author rbaral
 */
public class CountPrimes {

    public static int countPrimes(int n) {
        /*
        if(n<=1)
            return 0;
        System.out.println("log  of "+n+" is:"+n/(Math.log(n))+".."+(1.25506*n/Math.log(n)));
        
        return (int)(n/(Math.log(n)));
         */
        if (n < 2) {
            return 0;
        } else {
            int primeCount = 0;
            for (int i = 2; i <n; i++) {
                   if (isPrime(i)) {
                       if(i>100){
                           System.out.println(i+" is prime");
                       }
                    primeCount++;
                }
               
            }
            return primeCount;
        }
    }

    static boolean isPrime(int n) {
        if (n==2 || n == 3 || n == 5 || n == 7) {
            return true;
        }else{
            if((n%2==0) || (n%3==0) || (n%5==0) || (n%7==0) || (((int)Math.sqrt(n) * (int) Math.sqrt(n))==n)){
                return false;
            }
            return true;
        }
        //return false;
    }

    public static void main(String args[]) {
        System.out.println(countPrimes(0));
        System.out.println(countPrimes(3));

        System.out.println(countPrimes(4));
        System.out.println(countPrimes(10));
        System.out.println(countPrimes(100));
        System.out.println(countPrimes(1000));

    }
}
