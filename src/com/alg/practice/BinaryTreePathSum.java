/*
You are given a binary tree in which each node contains a value. Design an algorithm
to print all paths which sum to a given value. The path does not need to start
or end at the root or a leaf.


Solution 1:

We use a recursive approach for this:
1) start from root node, if it is equal to the given sum, add this node to path, recurse on
2) as there can be nodes with negative value, we can find additional path even we have already found the sum, so wee keep on continuing with this path
looking for potential new path
3) recurse on the left and right child nodes for sum-node.val 
4) recurse on the left and right chld nodes for sum, i.e. the path that starts with these child nodes

Complexity: O(nlog(n))

 */
package com.alg.practice;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author rbaral
 */
public class BinaryTreePathSum {

	static int i =1;
    public static void findPath(TreeNode node, List<String> allPaths, String path, int sum) {
		System.out.println("i is:"+i);
		i++;
        if (node == null) {
            //reached end of the tree
            return;
        }
        if ((int) node.getValue() < sum) {
            //add the item to path
            path = path+ String.valueOf((int) node.getValue())+" ";
        }
        if ((int) node.getValue() == sum) {
            System.out.print("cur node:" + String.valueOf(node == null ? "" : node.getValue()) + ". found sum:"+sum+".. cur path sum:");
            System.out.print(path);
            
            //add the path
            path = path+ String.valueOf((int) node.getValue())+" ";
            allPaths.add(path);
            
        }
        if (node.left != null) {
            findPath(node.left, allPaths, path, sum - (int) node.getValue());
            findPath(node.left, allPaths, "", sum);
        }
        if (node.right != null) {
            findPath(node.right, allPaths, path, sum - (int) node.getValue());
            findPath(node.right, allPaths, "", sum);
        }

    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(10);
        TreeNode l1_l = new TreeNode(5);
        TreeNode l1_r = new TreeNode(3);

        TreeNode l21_l = new TreeNode(6);
        TreeNode l21_r = new TreeNode(8);

        TreeNode l22_l = new TreeNode(12);
        TreeNode l22_r = new TreeNode(2);
		
		TreeNode l31_l = new TreeNode(9);

		l21_l.left = l31_l;
		
        l1_l.left = l21_l;
        l1_l.right = l21_r;

        l1_r.left = l22_l;
        l1_r.right = l22_r;

        root.left = l1_l;
        root.right = l1_r;

        int sum = 15;
        List<String> allPaths = new ArrayList<String>();
        List<Integer> path = new ArrayList<Integer>();
        //path.add((int)root.getValue());
        findPath(root, allPaths, "", sum);
        //iterate through the path and check
        System.out.println("list of valid paths are");
        for (String l : allPaths) {
            System.out.println(l);
        }
    }

}
