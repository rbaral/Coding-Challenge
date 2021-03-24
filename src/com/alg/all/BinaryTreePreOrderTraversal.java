/**
Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively?
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreePreOrderTraversal{

	/**
	Method1:
	-recursively perform preorder traversal from teh root node
	*/
	public static List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> nodeList = new ArrayList<Integer>();
		if(root==null)
			return nodeList;
		performPreorderRecursive(root, nodeList);
		return nodeList;
    }
	
	//recursively perform the pre-order operation
	public static void performPreorderRecursive(TreeNode root, List<Integer> nodeList){
		if(root==null)
			return;
		nodeList.add(root.val);
		if(root.left!=null)
			performPreorderRecursive(root.left, nodeList);
		if(root.right!=null)
			performPreorderRecursive(root.right, nodeList);
	}
	
	/**
	Method2:
	-iteratively perform the pre-order operation
	
	*/
	public static List<Integer> preorderTraversalIterative(TreeNode root) {
		List<Integer> nodeList = new ArrayList<Integer>();
		//base case
		if(root==null)
			return nodeList;
		Stack<TreeNode> nodestack = new Stack<TreeNode>();
		nodestack.push(root);
		while(!nodestack.isEmpty()){
			TreeNode temp = nodestack.pop();
			//add the node's value to the list
			nodeList.add(temp.val);
			
			//push the right node to the stack
			if(temp.right!=null)
				nodestack.push(temp.right);
			//push the left node to stack
			if(temp.left!=null)
				nodestack.push(temp.left);
		}
		return nodeList;
	}

	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		root.left = two;
		root.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;
		
		System.out.println("preorder recursive is:");
		List<Integer> nodesList = preorderTraversalRecursive(root);
		for(Integer val:nodesList){
			System.out.print(val+" ");
		}
		System.out.println();
		
		
		System.out.println("preorder iterative is:");
		nodesList = preorderTraversalIterative(root);
		for(Integer val:nodesList){
			System.out.print(val+" ");
		}
		System.out.println();
		
	}
}