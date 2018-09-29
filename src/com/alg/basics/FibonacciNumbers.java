package com.alg.basics;

public class FibonacciNumbers {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int num = getFibonacciNumberRecursively(7);
        System.out.println(num);
        System.out.println(getFibonacciNumberByMemoization(7));
        System.out.println(getFibonacciNumberUsingGoldenRatio(7));
    }

    public static int getFibonacciNumberUsingGoldenRatio(int n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        double phiPrime = (1 - Math.sqrt(5)) / 2;
        double fib = (Math.pow(phi, n) - Math.pow(phiPrime, n)) / Math.sqrt(5);
        return (int) fib;
    }

    public static int getFibonacciNumberRecursively(int n) {
        int num = 0;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            num = getFibonacciNumberRecursively(n - 1) + getFibonacciNumberRecursively(n - 2);
        }
        return num;
    }

    public static int getFibonacciNumberByMemoization(int n) {
        int num = 0;
        //lets create an array to hold the fib numbers
        int fib[] = new int[n + 1];
        //initialize all to some default values
        for (int i = 0; i <= n; i++) {
            fib[i] = 0;
        }
        fib[1] = 1;//fib_1
        if (n == 0 || n == 1) {
            return fib[n];
        } else {
            for (int j = 2; j <= n; j++) {
                fib[j] = fib[j - 1] + fib[j - 2];
            }
        }
        return fib[n];
    }

}
