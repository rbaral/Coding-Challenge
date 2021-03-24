/**
https://www.geeksforgeeks.org/connect-leaves-doubly-linked-list/

Extract Leaves of a Binary Tree in a Doubly Linked List
Given a Binary Tree, extract all leaves of it in a Doubly Linked List (DLL). Note that the DLL need to be created in-place. Assume that the node structure of DLL and Binary Tree is same, only the meaning of left and right pointers are different. In DLL, left means previous pointer and right means next pointer.

Let the following be input binary tree
        1
     /     \
    2       3
   / \       \
  4   5       6
 / \         / \
7   8       9   10


Output:
Doubly Linked List
7<->8<->5<->9<->10

Modified Tree:
        1
     /     \
    2       3
   /         \
  4           6
*/

import java.util.*;

class Node  
{ 
    int val; 
    Node left, right; 
   
    Node(int item)  
    { 
        val = item; 
        right = left = null; 
    } 
} 

public class BinaryTreeExtractLeavesToDoublieLinkedList{

	static Node dlist = new Node(0);// a dummy node
	static Node dhead = dlist;
	/**
	-use the DFS method to traverse the tree and keep track of the leaf nodes
	-whenever a leaf node  is encountered, add it to the doubly linked list
	*/
	public static Node findListFromLeaves(Node root){
		if(root==null){
			return root;
		}
		//traverse the tree using dfs
		dfsTraversal(root);
		//now the dlist should have all the leaf nodes
		return dhead.right;
	}
	
	public static void dfsTraversal(Node root){
		if(root.left==null && root.right==null){
			//reached the leaf node
			Node temp = new Node(root.val);
			temp.left = dlist;
			dlist.right = temp;
			dlist = dlist.right;
			return;
		}
		if(root.left!=null)
			dfsTraversal(root.left);
		if(root.right!=null)
			dfsTraversal(root.right);
	}
	
	public static void printDlist(Node dlist){
		System.out.println("the dlist nodes start from:"+dlist.val);
		while(dlist.right!=null){
			System.out.print(dlist.val+" ");
			dlist = dlist.right;
		}
		System.out.println();
		//again print the list usign the left link
		while(dlist.left!=null){
			System.out.print(dlist.val+" ");
			dlist = dlist.left;
		}
	}
	
	public static void main(String[] args){
		Node root = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node nine = new Node(9);
		Node ten = new Node(10);
		root.left = two;
		root.right = three;
		two.left = four;
		two.right = five;
		four.left = seven;
		four.right = eight;
		three.right = six;
		six.left = nine;
		six.right = ten;
		Node dlist = findListFromLeaves(root);
		printDlist(dlist);
	}

}