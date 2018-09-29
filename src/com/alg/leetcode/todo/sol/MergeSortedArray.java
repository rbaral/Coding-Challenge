/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.todo.sol;

/**
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
* 
* Solution 1:
* 1)we assume that nums1 has enough slot to include all elements of nums2
* 2)As both arrays are sorted, we compare from the last indices of nums2 and the last index of nums1(nums1.length - nums2.length)
* 3) create pointers to store the last empty slot of nums1, last element compared of nums2
* 4) Iteratively compare nums2 and nums1 as mentioned in (2)
* 4 a) If nums1 has greater or equal element than that of nums2, bring this to the last empty slot of nums1, update the last empty slot index of nums1
* 4 b) If nums2 has greater element, bring this to the last empty slot of nums1, update the last element compared of nums2
* 5) repeat until the nums1 array's index is less than 0 or nums2 array's index is less than 0
* 6) nums1 will have the merged arrays
 * 
 * 
 * @author rbaral
 */
public class MergeSortedArray {
    
}
