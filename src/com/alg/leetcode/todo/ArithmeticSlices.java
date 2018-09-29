/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.todo;

/**
 *
 * @author rbara012
 * 
 * 
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequence:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.

1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of array A is called arithmetic if the sequence:
A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.


Example:

A = [1, 2, 3, 4]

return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
* 
* 
* Solution 1:
* 1)Use two loops the outer loop points to the element that acts as the first element of the Arithmetic series and the inner loop
* advances till the numbers satisfy the arithmetic series property.
* 2)Repeat till the inner loop pointer has at least two element to process (outer loop has one + inner loop has two => at least three elements)
* 2 a) if the diff between the element at outer loop and the element at inner loop is not consistent, break the inner loop and consider the next element
* from the outer loop
* 2 b) if the diff between the element at outer loop and the element at inner loop is consistent then record a counter and add the elements to the list when the counter reaches 3
* 
* Complexity: O(n^2) as we use two nested loops
* 
* 
* Solution 2:
* 1)Use two pointers p1 that points to the first element of the array and p2 that points to the second element of the array, the start pointer s to
* indicate from where we started/considered the array
* 2)Repeat till p2 hasn't reached the end of the array
* 2 a) record the difference between the elements arr[p1] and arr[p2]
* 2 b) if the difference was computed for the first time, simply advance the pointers (p1++, p2++)
* 2 c) if it was not the first time, check if the difference is consistent. If so, advance the pointers. If not, we cannot have arr[p1] and arr[p2] in the same series.
* So, we check if the value of s and p1 differs by at least 2, if so, then we have found at least one arithmetic slice so, the number of valid slices
* in this range is equal to 
* So we ignore the computed difference so far and again start from the advanced position of the pointers (p1++, p2++)
* 2 d)at every iteration check if the difference is consistent and
 * 
 * 
 */
public class ArithmeticSlices {
    
}
