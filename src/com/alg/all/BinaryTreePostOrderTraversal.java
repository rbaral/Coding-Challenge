/**
Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
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

public class BinaryTreePostOrderTraversal{

	public static List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> nodeList = new ArrayList<Integer>();
		if(root==null)
			return nodeList;
		performPostorderRecursive(root, nodeList);
		return nodeList;
    }
	
	//recursively perform the pre-order operation
	public static void performPostorderRecursive(TreeNode root, List<Integer> nodeList){
		if(root==null)
			return;
		if(root.left!=null)
			performPostorderRecursive(root.left, nodeList);
		if(root.right!=null)
			performPostorderRecursive(root.right, nodeList);
		nodeList.add(root.val);
	}
	
	/**
	Method2:
	-iterative solution
	-we need to traverse left branch, then right branch, and finally the node
	*/
	public static List<Integer> postorderTraversalIterative(TreeNode root) {
		List<Integer> nodeList = new ArrayList<Integer>();
		//base case
		if(root==null)
			return nodeList;
		Stack<TreeNode> nodestack = new Stack<TreeNode>();
		nodestack.push(root);
		while(!nodestack.isEmpty()){
			TreeNode temp = nodestack.pop();
			nodeList.add(0, temp.val);
			//push the left
			if(temp.left!=null){
				nodestack.push(temp.left);
			}
			//push the right
			if(temp.right!=null){
				nodestack.push(temp.right);
			}
			
		}
		return nodeList;
	}
	
	public static void main(String args[]){
		/*
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		root.right = two;
		two.left = three;
		*/
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
		System.out.println("postorder recursive is:");
		List<Integer> nodesList = postorderTraversalRecursive(root);
		for(Integer val:nodesList){
			System.out.print(val+" ");
		}
		System.out.println();
		
		
		System.out.println("postorder iterative is:");
		nodesList = postorderTraversalIterative(root);
		for(Integer val:nodesList){
			System.out.print(val+" ");
		}
		System.out.println();
		
	}
}