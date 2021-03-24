/**
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
*/

/**
Sol1:
-start from the root node and recursively increaset the depth count
-when a node with no child (leaf node) is reached return
*/
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;


//a simple representation of Tree
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	TreeNode(int v){
		val = v;
	}
	void setRight(TreeNode r){
		right = r;
		right.parent = this;
	}
	void setLeft(TreeNode l){
		left = l;
		left.parent = this;
	}
	
	TreeNode getRight(){
		return right;
	}
	
	TreeNode getLeft(){
		return left;
	}
}
public class BinaryTreeMaxDepth{

	public static int getMaxDepthRecursive(TreeNode root){
		if(root==null){
			return 0;
		}
		return 1 +Math.max(getMaxDepthRecursive(root.right), getMaxDepthRecursive(root.left));
	}
	
	/**
	-we can use DFS to find the max depth of a tree
	*/
	public static int getMaxDepthDFS(TreeNode root){
		if(root == null)
			return 0;
		//we use a stack to store the right and left child of a node and traverse through the left branch
		Stack<Integer> depthstack = new Stack<Integer>();
		Stack<TreeNode> nodestack = new Stack<TreeNode>();
		nodestack.push(root); //push the current node
		depthstack.push(1);//push the current level
		//iterate till the stack contains some node
		//the max depth value so far
		int maxdepth = 0;
		while(!nodestack.isEmpty()){
			//first store the right child in stack so that while popping we get the left child first
			int lastdepth = depthstack.pop();
			if(lastdepth>maxdepth)
				maxdepth = lastdepth;
			TreeNode topNode = nodestack.pop();
			if(topNode.right!=null){
				nodestack.push(topNode.right);
				depthstack.push(maxdepth+1);
			}
			if(topNode.left!=null){
				nodestack.push(topNode.left);
				//push the new level values
				depthstack.push(maxdepth+1);
			}
		}
		return maxdepth;
	}
	
	/**
	-we use queue to store the nodes and traverse the tree using BFS
	*/
	public static int getMaxDepthBFS(TreeNode root){
		//base case
		if(root ==null){
			return 0;
		}
		//store the nodes in queue and pop them to simulate BFS
		Queue<TreeNode> nodequeue = new LinkedList<TreeNode>();//use linkedlist as a queue
		nodequeue.offer(root);
		int level = 0;//level or depth 0 for the root node
		while(!nodequeue.isEmpty()){
			//lets first empty this queue because that gives the items at one level
			int itercount = nodequeue.size();
			while(itercount>0){
				//add the left and right childs to the queue and increase the level
				TreeNode topNode = nodequeue.poll();
				if(topNode.left!=null){
					nodequeue.offer(topNode.left);
				}
				if(topNode.right!=null){
					nodequeue.offer(topNode.right);
				}
				itercount--;
			}
			//now increase the level because we accessed the nodes at this level
			level++;
		}
		return level;
	}
	
	public static void main(String args[]){
		//create a tree
		TreeNode root = new TreeNode(0);
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		root.left = one;
		root.right = two;
		one.left = three;
		one.right = four;
		three.left = five;
		//five.left = new TreeNode(7);
		int maxDepth = getMaxDepthRecursive(root);
		System.out.println("max depth1 is:"+maxDepth);
		System.out.println("max depthDFS is:"+getMaxDepthDFS(root));
		System.out.println("max depthBFS is:"+getMaxDepthBFS(root));
	}
	
}