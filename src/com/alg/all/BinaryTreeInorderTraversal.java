/**
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 
public class BinaryTreeInorderTraversal{


	/**
	Method1:
	-recursively traverse the left node, the node itself, and the right node
	*/
	public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        //base case
		List<Integer> nodesList = new ArrayList<Integer>();
		if(root==null){
			return nodesList;
		}
		performInorderTraversalRecursive(root, nodesList);
		return nodesList;
    }
	
	public static void performInorderTraversalRecursive(TreeNode root, List<Integer> nodesList){
		if(root==null){
			return;
		}
		//add the left node
		if(root.left!=null){
			performInorderTraversalRecursive(root.left, nodesList);
		}
		//add the node itself
		nodesList.add(root.val);
		//add the right node
		if(root.right!=null){
			performInorderTraversalRecursive(root.right, nodesList);
		}
	}
	/**
	Method2:
	-use iteration to traverse the tree
	-we traverse the left path using DFS and then print the node value and again traverse back to the right
	*/
	public static List<Integer> inorderTraversalIterative(TreeNode root) {
		List<Integer> nodeList = new ArrayList<Integer>();
		//base case
		if(root==null){
			return nodeList;
		}
		//now iterate on the left path of the root and store the left path in a stack
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		while(root!=null){
			if(root.left!=null){
				nodeStack.push(root);
				root = root.left;
			}else{
				nodeList.add(root.val);
				//we already finished the left path, if there is no right path we can traverse back towards root of the tree
				while(root.right==null){
					if(!nodeStack.isEmpty()){
						root = nodeStack.pop();
						nodeList.add(root.val);
					}else{//we already processed all the nodes
						return nodeList;
					}
				}
				root = root.right;
			}
			
		}
		return nodeList;
    }
	
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		root.right = two;
		two.left = three;
		System.out.println("inorder recursive is:");
		List<Integer> nodesList = inorderTraversalRecursive(root);
		for(Integer val:nodesList){
			System.out.print(val+" ");
		}
		System.out.println();
		
		System.out.println("inorder iterative is:");
		nodesList = inorderTraversalIterative(root);
		for(Integer val:nodesList){
			System.out.print(val+" ");
		}
		System.out.println();
	}

}