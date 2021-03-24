/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

/**
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * 
 * Solution 1:
 * Recursive approach:
 * 1)Get the middle of the array and make it as a root
 * 2) left half (excluding root) will be the left subtree of root
 * 3) right half(excluding root) will be the right subtree of root
 * 4)recursively make BST from left half
 * 5)recursively make BST from right half
 * 
 * 
 * @author rbaral
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
     if(nums==null || nums.length==0){
           return null;
       }
       TreeNode root = null;
       root = getBST(nums, 0, nums.length-1);
       return root;
    }
    
    public TreeNode getBST(int[] nums, int start, int end){
        if(nums.length==0 ||(start>end)){
            return null;
        }
        else if(nums.length==1){
            return new TreeNode(nums[0]);
        }else{
            //get the middle
            int mid = (start+end)/2;
            
            TreeNode root = new TreeNode(nums[mid]);
            root.left = getBST(nums, start, mid-1);
            root.right = getBST(nums,mid+1, end);
            return root;
        }
    }
}
