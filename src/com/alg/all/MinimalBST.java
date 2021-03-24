/*
Given a sorted (increasing order) array with unique integer elements, write an algorithm
to create a binary search tree with minimal height

Solutioin 1:

- as the array is sorted, the middle element can be the root node
- the left subarray can be used to find the left node
- the right subarray can be used to find the right node
-the process can be recursively repeated for next level of nodes

 */
package com.alg.practice;

/**
 *
 * @author rbaral
 */
public class MinimalBST {

    public static TreeNode createMinimalBST(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        if (low > high) {
            return null;
        }
        //get the middle as the root node
        int mid = (low + high) / 2;

        TreeNode root = new TreeNode(arr[mid]);
        root.left = createMinimalBST(arr, low, mid - 1);
        root.right = createMinimalBST(arr, mid + 1, high);
        return root;
    }

    public static void main(String args[]) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }
        TreeNode root = createMinimalBST(arr, 0, arr.length - 1);
        BFSTraversal bfs = new BFSTraversal();
        String bfsString = bfs.performBFSTraversal(root);
        System.out.println(bfsString);

        String dfsString = new DFSTraversal().performDFSTraversal(root);
        System.out.println(dfsString);
    }

}
