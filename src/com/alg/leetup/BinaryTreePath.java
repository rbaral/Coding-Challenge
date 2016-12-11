/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * For example, given the following binary tree:
 *
 * 1
 * / \
 * 2 3
 * \
 * 5
 * All root-to-leaf paths are:
 *
 * ["1->2->5", "1->3"]
 *
 *
 * Solution 1: 1)start from the root node and traverse down its child 2)take one
 * branch at a time for every traversed node and add the value of the node to
 * the path string 3)when the next child node (on left side or right side) is
 * null, the string is complete
 *
 *
 * @author rbaral
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class BinaryTreePath {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> pathList = new ArrayList<String>();
        if (root != null) {
            performDFS(root, "", pathList);
        }
        return pathList;
    }

    static void performDFS(TreeNode root, String path, List<String> pathList) {
        if (root.left == null && root.right == null) {
            pathList.add(path + root.val);
        }
        if (root.left != null) {
            performDFS(root.left, path + root.val + "->", pathList);
        }
        if (root.right != null) {
            performDFS(root.right, path + root.val + "->", pathList);
        }
    }

    public static void main(String args[]) {

    }

}
