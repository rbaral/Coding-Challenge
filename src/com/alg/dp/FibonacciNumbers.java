/*
Write a function to find nth fibonacci numbers

Solution:
-we can use simple recursive approach but it will take exponential time
-we can use dynamic programming for this as it has many overlapping subproblems
 */
package com.alg.dp;

/**
 *
 * @author rbaral
 */
public class FibonacciNumbers {

    public static int findFibonacciRecursive(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return findFibonacciRecursive(n - 1) + findFibonacciRecursive(n - 2);
        }
    }

    /**
     *in bottom up, we store the fibonacci numbers in an array
     * @param n
     * @return
     */
    public static int findFibonacciBottomUp(int n) {
		int[] fibo = new int[n+1];
		fibo[0] = 0;
		fibo[1] = 1;
		for(int i=2; i<=n; i++){
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
        return fibo[n];
    }

    /**
     * this is also a recursive approach but does memoization to avoid the
     * recomputation of same subproblem again and again
     *
     * @param n
     * @return
     */
    public static int findFibonacciTopDown(int n, int[] arr) {
        if (n >= 2) {
            if (arr[n - 1] == -1) {
                arr[n - 1] = findFibonacciTopDown(n - 1, arr);
            }
            if (arr[n - 2] == -1) {
                arr[n - 2] = findFibonacciTopDown(n - 2, arr);
            }
            arr[n] = arr[n - 1] + arr[n - 2];
        }
        return arr[n];
    }

    public static void main(String args[]) {
        int num = 8;
        int fibor = findFibonacciRecursive(num);
        System.out.println("fibor:" + fibor);
        int[] arr = new int[num + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        //first fibo is 0 and second is 1
        arr[0] = 0;
        arr[1] = 1;
        int fibomem = findFibonacciTopDown(num, arr);
        System.out.println("fibor:" + fibomem);
		int fibodp = findFibonacciBottomUp(num);
		System.out.println("fobdp:"+fibodp);

    }
}
