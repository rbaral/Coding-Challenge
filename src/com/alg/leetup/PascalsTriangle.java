/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

/**
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
* 
* Solution 1:
* 1)handle base cases, when row is 1 (or even row is 2)
* 2)the row number gives the number of elements in that row, so create an array of that size and iterate from 0 to that value
* 2 a)the elements to be inserted always start from 1 (val)
* 2 b) have two pointers one pointing to start and another to end of the array
* 2 c)copy 1 to the start and end of the array
* 2 d) initialize the change value in array = #row - 2
* 3) repeat while start<> end
* 3 a) advance start and end (start++, end--)
* 3 b) arr[start] = arr[end] = arr[start-1]+changeValue;
* 3 c) start++, end--;
 *
 * @author rbaral
 */
public class PascalsTriangle {
    
}
