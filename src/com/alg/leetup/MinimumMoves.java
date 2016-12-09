/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

/**
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, 
 * where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
* 
* Solution 1:
* 1) increase n-1 elements from the beginning -(O(n))
* 2)sort the list - O(nlogn)
* 3)check if every element is equal, if equal break - O(n)
* 4)Repeat 1-3 till every element is equal
* 
* Complexity: O(2n+nlogn)
* *************************************
* Ref:http://codereview.stackexchange.com/questions/148442/finding-the-minimum-number-of-moves-to-achieve-equal-array-elements

Instead of

Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, 
where a move is incrementing n - 1 elements by 1.

say instead

where a move is decrementing a single element by 1
Do you see why these are the same? Suppose we start with 1, 2, 3. Adding 1, 1, 0 produces 2, 3, 3. Adding 0, 0, -1 produces 1, 2, 2, 
which is effectively the same thing. However many moves it takes to make 2, 3, 3 all equal is surely the same number of moves as it 
takes to make 1, 2, 2, all equal, or 0, 1, 1, or 1000, 1001, 1001, or whatever. Where you start is irrelevant.
End of Ref:
*****************************************

* Solution 2:
* 1)Sort the elements
* 2) Find the difference of the largest to every other elements and add the difference
* 3) the sum in (2) is the number of moves
* 
* Ex:
* [1,2,3]: diff = 3-2+3-1 = 3
* [1,3,5]: diff = 5-3+5-1 = 6
* 
 *
 * @author rbaral
 */
import java.util.Arrays;

public class MinimumMoves {
    
    static int minMoves(int [] nums){
        //lets assume the array is not sorted
        //Arrays.sort(nums);
        int numSum = 0;
        int min = nums[0];
        for(int i= nums.length-1; i>=0;i--){
            numSum+=nums[i];
            if (nums[i]<min){
                min = nums[i];
            }
        }
        return numSum - min*nums.length;
    }
    
    public static void main(String args[]){
        int [] nums = {1,2,3};//3
        System.out.println(minMoves(nums));
        nums = new int[] {1,3,5};//6
        System.out.println(minMoves(nums));
        nums = new int[] {1,2,3,4};//6
        System.out.println(minMoves(nums));
        nums = new int[] {1,1,2147483647}; //2147483646
        System.out.println(minMoves(nums));
    }
}
