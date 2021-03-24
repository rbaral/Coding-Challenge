/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

public class OperationsWithAddition {

    public int negate(int a) {
        if (a == 0) {
            return a;
        }
        int neg = 0;
        int temp = a > 0 ? -1 : 1;
        while (a != 0) {
            neg += temp;
            a += temp;
        }
        return neg;
    }

    public int abs(int a) {
        return a >= 0 ? a : negate(a);
    }

    //implements the subtraction 
    public int minus(int a, int b) {
        return a + negate(b);
    }

    public int multiply(int a, int b) {
        //multiply is straight forward, just add a to itself b times, and later check the sign
        int sum = 0;
        for (int i = 1; i <= abs(b); i++) {
            sum += a;
        }
        if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
            //both negatives or both positives, so result is positive
            return sum;
        }
        return negate(sum);
    }

    public int divide(int a, int b) throws Exception {
        //implements a/b
        if (b == 0) {
            throw new Exception("Division by zero error");
        }
        //we use the multiplication operation, i.e. a/b = x=> a = bx
        int absa = abs(a);
        int absb = abs(b);
        int temp = 0;
        int prod = 0;
        while ((prod + absb) <= absa) {
            prod += absb;
            temp++;
        }
        if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
            //both positive or negative
            return temp;
        } else {
            return negate(temp);
        }
    }

    public static void main(String args[]) throws Exception {
        int a = 5;
        int b = -10;
        OperationsWithAddition ops = new OperationsWithAddition();
        System.out.println("a is:" + a + " b is:" + b);
        System.out.println("a -b is:" + ops.minus(a, b));
        System.out.println("a/b is:" + ops.divide(a, b));
        System.out.println("a*b is:" + ops.multiply(a, b));
    }

}
