/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ccup;

import java.util.Arrays;

/**
 *
 * @author rbaral
 * 
 * Given an array of integer, find the minimum in the sliding window of size 4, in most optimal way. 
ex [2,1,3,4,6,3,8,9,10,12,56] 
Output : [1,1,3,3,3,3,8.....]
 * 
 * 
 * 
 * Solution:
 * 
 * There is a better way in O(n) using a DP approach: Let's window size = w and array size = n, n>w. 

Observe that the minimum at a position in current window is the minimum of what we would have seen so far and what we will see in future in the current window boundary. 
* So, we can find min so far while traversing from left to right of the current window. 
* But what about min in future? the trick is that we can traverse backwards to get the future min at a position. 
* Also note that: windows separated by elements >=w will have no overlapping and so min so far should be reset at each block of w elements. 

So, we will divide the array into [n/w] blocks. We'll keep calculate array's of min: min_so_far by traversing from start to end and min_in_future by traversing from end to start. 
* Reset the min at the boundary of each block in the direction of traversal. 

Example: [2,1,3,4,6,3,8,9,10,12,56] w=4 
1. partition the array in blocks of size w=4. The last block may have less then w. 
2, 1, 3, 4 | 6, 3, 8, 9 | 10, 12, 56| 
2. Traverse the list from start to end and calculate min_so_far. Reset min to 0 after each block (of w elements). 
min_so_far[] = 2, 1, 1, 1 | 6, 3, 3, 3 | 10, 10, 10 
3. Similarly calculate min_in_future by traversing from end to start. 
min_in_future[] = 1, 1, 3, 4 | 3, 3, 8, 9 | 10, 12, 56 
4. now, min at each position i in current window, sliding_min(i) = min {min_in_future[i], min_so_far[i+w-1]} 
sliding_min = 1, 1, 3, 3, 3, 3, 8, ....
* 
* Ref:https://careercup.com/question?id=5634264741707776
 */
public class MinimumInSlidingWindow {

    public static int[] slidingWindowMin(final int[] in, final int w) {
        int[] min_left = new int[in.length];
        int[] min_right = new int[in.length];

        min_left[0] = in[0];
        min_right[min_right.length - 1] = in[in.length - 1];

        for (int i = 1; i < in.length; i++) {
            min_left[i] = (i % w == 0) ? in[i] : Math.min(min_left[i - 1], in[i]);

            int j = in.length - i - 1;
            min_right[j] = (j % w == 0) ? in[j] : Math.min(min_right[j + 1], in[j]);
        }

        int[] sliding_min = new int[in.length - w + 1];
        for (int i = 0, j = 0; i + w <= in.length; i++) {
            sliding_min[j++] = Math.min(min_right[i], min_left[i + w - 1]);
        }

        return sliding_min;
    }
    
    public static void main(String args[]){
        int a[] ={2,1,3,4,6,3,8,9,10,12,56,1};
        int win = 4;
        System.out.println(Arrays.toString(slidingWindowMin(a, win)));
    }
}
