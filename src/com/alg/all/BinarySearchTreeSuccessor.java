/**
Write an algorithm to find the 'next'node (i.e., in-order successor) of a given node in
a binary search tree. You may assume that each node has a link to its parent
*/


/**
Soln1:
-perform inorder traversal of the tree and dump the items into an array/list
-traverse the array/list and return the item after the given node
-though this works, we could have done better by using the parent pointer that was provided for us

Soln2:
-the inorder traversal works as: left->node->right
-if a node has right child, its successor will be the leftmost node of its right child
-if a node does not have a right child, we use the parent pointer to scan upwards till we find a node which is on the left side of its parent
-if a node does not have a right child and does not have a parent node, then it should be the root node and does not have any successor
*/

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

public class BinarySearchTreeSuccessor{

public static TreeNode findSuccessor(TreeNode root){
	//handle base cases
	if(root==null){
		return null;
	}
	//if the node has right subtree, then the successor will be the leftmost child of the right child
	if(root.right!=null){
		TreeNode child = root.right;
		while(child.left!=null){
			child = child.left;
		}
		return child;
	}else{
		//if there is no right child, then we scan upwards using the parent pointer and repeat till we find a node which is the left child of its parent node
		TreeNode parent = root.parent;
		TreeNode cur = root;
		while(parent!=null && parent.right==cur){
			cur = parent;
			parent = parent.parent;
		}
		return parent;
	}
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
	one.parent = root;
	two.parent = root;
	one.left = three;
	one.right = four;
	three.parent = one;
	four.parent = one;
	three.left = five;
	five.parent = three;
	TreeNode node = four;
	TreeNode sucNode = findSuccessor(node);
	System.out.println("The inorder successor of:"+node.val+" is:"+(sucNode==null?"NONE":sucNode.val));
}
}