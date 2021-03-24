 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;

/**
 * Write a function subtract(x, y) that returns x-y where x and y are integers. 
 * The function should not use any of the arithmetic operators (+, ++, –, -, .. etc). 
 *
 * Solution 1:
 * We can use bit operators as we did in the SumWithoutAddition.java
 * Lets look into an example:
 * 
 * X 	Y     Diff     Borrow
0 	0 	0 	0
0 	1 	1 	1
1 	0 	1 	0
1 	1 	0 	0
From the above table one can draw the Karnaugh map for “difference” and “borrow”.

So, Logic equations are:

    Diff   = y ⊕ x
    Borrow = x' . y 

Ref: http://www.geeksforgeeks.org/subtract-two-numbers-without-using-arithmetic-operators/
 * 
 * 
 * 
 * @author rbaral
 */
public class SubtractWithoutOperators {
    
    /**
     * returns the difference of a and b i.e. (a-b)
     * @param a
     * @param b
     * @return 
     */
    static int subtract(int a, int b){
        if(b==0){
            return a;
        }
        int diff = a^b; // a XOR b
        int borrow = (~a&b)<<1; // NOT(a) AND b
        return subtract(diff, borrow);
    }
    
    public static void main(String args[]){
        int a = 12;
        int b = 17;
        System.out.println("diff is:"+subtract(a, b));
    }
}
