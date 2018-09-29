/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ccup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rbaral Given an unsorted array of nonnegative integers, find a
 * continous subarray which adds to a given number.
 *
 * Examples:
 *
 * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33 Ouptut: Sum found between
 * indexes 2 and 4
 *
 * Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7 Ouptut: Sum found between
 * indexes 1 and 4
 *
 * Input: arr[] = {1, 4}, sum = 0 Output: No subarray found
 *
 *
 * Solution 1: 1)Use two nested loops, the outer loop points to one element at a
 * time and the inner loop scans for rest of the elements to check if the sum is
 * found
 *
 *
 * Complexity: O(n^2)
 *
 * Solution 2: Initialize a variable curr_sum as first element. curr_sum
 * indicates the sum of current subarray. Start from the second element and add
 * all elements one by one to the curr_sum. If curr_sum becomes equal to sum,
 * then print the solution. If curr_sum exceeds the sum, then remove trailing
 * elemnents while curr_sum is greater than sum.
 *
 * NOTE: It only works for positive numbers
 *
 * Complexity: O(n)
 *
 *
 * Solution 3: 1) To handle negative numbers, use hashmap and store the sum so
 * far in a variable. 2) For each element, check if the sum - cur_sum is in hash
 * map, if so, we found it, else we store the sum so far in hash and continue 3)
 * if no sum is found till we reach the end, the sum cannot be found
 *
 * Complexity: O(n)
 *
 *
 * Ref: http://www.geeksforgeeks.org/find-subarray-with-given-sum/
 */
public class ContiguousSubArrayWithSumK {

    /* Returns true if the there is a subarray of arr[] with sum equal to
       'sum' otherwise returns false.  Also, prints the result */
    static int subArraySum(int arr[], int n, int sum) {
        int curr_sum = arr[0], start = 0, i;

        // Pick a starting point
        for (i = 1; i <= n; i++) {
            // If curr_sum exceeds the sum, then remove the starting elements
            while (curr_sum > sum && start < i - 1) {
                curr_sum = curr_sum - arr[start];
                start++;
            }

            // If curr_sum becomes equal to sum, then return true
            if (curr_sum == sum) {
                int p = i - 1;
                System.out.println("Sum found between indexes " + start
                        + " and " + p);
                return 1;
            }

            // Add this element to curr_sum
            if (i < n) {
                curr_sum = curr_sum + arr[i];
            }

        }

        System.out.println("No subarray found");
        return 0;
    }

    static void subArraySumWithNegatives(int nums[], int k) {
        int sum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum == k) {
                max = i + 1;
                System.out.println("found in the range:"+0+" and "+i);
            } else if (map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k));
                System.out.println("found in range:"+max+" and "+i);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        System.out.println(" "+max);
        System.out.println("sum not found");
    }

    static int subArrayProduct(int arr[], int n, int prod) {
        int curr_prod = arr[0], start = 0, i;

        // Pick a starting point
        for (i = 1; i <= n; i++) {
            // If curr_prod exceeds the prod, then remove the starting elements
            while (curr_prod > prod && start < i - 1) {
                curr_prod = curr_prod / arr[start];
                start++;
            }

            // If curr_prod becomes equal to prod, then return true
            if (curr_prod == prod) {
                int p = i - 1;
                System.out.println("prod found between indexes " + start
                        + " and " + p);
                return 1;
            }

            // Add this element to curr_prod
            if (i < n) {
                curr_prod = curr_prod * arr[i];
            }

        }

        System.out.println("No subarray found");
        return 0;
    }

    public static void main(String[] args) {
        ContiguousSubArrayWithSumK arraysum = new ContiguousSubArrayWithSumK();
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int n = arr.length;
        int sum = 23;
        //arraysum.subArraySum(arr, n, sum);
        sum = 7;
        arr = new int[]{1, 2, 10, 7, 4};
        n = arr.length;
        //arraysum.subArraySum(arr, n, sum);
        int prod = 40;
        arr = new int[]{1, 2, 10, 7, 4};
        n = arr.length;
        //arraysum.subArrayProduct(arr, n, prod);
        sum = 11;
        arr = new int[]{-1, 3, 10, 7, 4};
        n = arr.length;
        arraysum.subArraySumWithNegatives(arr, sum);
    }
}
