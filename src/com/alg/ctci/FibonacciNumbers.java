/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;

/**
 *
 * @author rbaral
 * Class to generate Fibonacci numbers:  0 1 1 2 3 5 8 13.....
 */
public class FibonacciNumbers {
    
    static int fibonacci(int i){
        if(i==0){ //fib(0) = 0
            return 0;
        }else if(i==1){ //fib(1) = 1
            return 1;
        }
        else{
            int fib =  (fibonacci(i-1)+ fibonacci(i -2));
            System.out.print(fib+" ");
            return fib;
        }
    }
    
    static int[] fib = new int[100]; //some maximum slots
    static int fibonaccidp(int i){
        if(i==0){
            return 0;
        }else if(i==1){
            fib[i] =1;
            return fib[i];
        }else{
            if(fib[i]!=0){
                //System.out.print(fib[i]+" ");
                return fib[i]; //use the cached value
            }else{
                int fibn =  (fibonaccidp(i-1)+ fibonaccidp(i -2));
                fib[i] = fibn;
                //System.out.print(fibn+" ");
                return fibn;
            }
        }
    }
    /**
     * 
     * @param args 
     */
    public static void main(String args[]){
        /*
        fibonaccidp(10);
        for(int a:fib){
            System.out.print(a+" ");
        }
        */
        fibonacci(7);
        
    }
}
