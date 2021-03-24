/*
Given a binary tree, design an algorithm which creates a linked list of all the nodes at
each depth (e.g., if you have a tree with depth D, you'll have D linked lists


Solution:
We can use BFS technique
1) store the root node to queue and a delimiter $ to the queue
2)Repeat till you see a delimiter in queue
a) if the top of queue is delimiter, check if there are any other elements in besides it, if none, then end
b) if other elements exist then create a new list
c) dequeue the front element from queue, add its left and right child to queue
d) add the dequeued element to list created in (b)


Complexity: O(V)
Space: O(V)

 */
package com.alg.practice;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author rbaral
 */
public class ListForEachDepth {

    public static List<List<Integer>> createListForLevels(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode delim = new TreeNode(-1);//as we store ints the queue
        MyQueue queue = new MyQueue();
		
		queue.enqueue(delim);
        queue.enqueue(root);
        
        List<List<Integer>> allLists = new ArrayList<List<Integer>>();
        List<Integer> levelList = null;
        while (queue.peek() != null) {
            TreeNode top = (TreeNode) queue.dequeue();
            if ((int) top.getValue() == -1) {//time to start a new level
                //store the previous level list
                if (levelList != null) {
                    allLists.add(levelList);
                }
                if (queue.peek() != null) {
                    queue.enqueue(delim);
                    levelList = new ArrayList();
                    //indicate the ending of this level
                }
            } else {
                levelList.add((int) top.getValue());
                //add its child to the queue
                if (top.left != null) {
                    queue.enqueue(top.left);
                }
                if (top.right != null) {
                    queue.enqueue(top.right);
                }
            }
        }
        return allLists;
    }

    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n1l = new TreeNode(2);
        TreeNode n1r = new TreeNode(3);
        n1.left = n1l;
        n1.right = n1r;

        TreeNode n2 = new TreeNode(4);
        TreeNode n2l = new TreeNode(5);
        TreeNode n2r = new TreeNode(6);
        
        TreeNode n22 = new TreeNode(11);
        TreeNode n23 = new TreeNode(12);
        n2l.left = n22;
        n2l.right = n23;
        n2.left = n2l;
        n2.right = n2r;

        TreeNode root = new TreeNode(7);
        root.left = n1;
        root.right = n2;
        
        BFSTraversal bfs = new BFSTraversal();
        String bfsString = bfs.performBFSTraversal(root);
        System.out.println(bfsString);
        
        List<List<Integer>> levelLists = createListForLevels(root);
        for (List levelList : levelLists) {
            System.out.println("new list:\n");
            for(Object item : levelList) {
                System.out.println((int)item + " ");
            }
            System.out.println("");
        }

    }
}
