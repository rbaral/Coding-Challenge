/**
Given a binary tree, design an algorithm which creates a linked list of all the nodes at
each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
*/

import java.util.List;
import java.util.ArrayList;
/**
we do a recursive solution
*/
public class BinaryTreeLinkedListLevel{

public static void getTreeLevelLists(TreeNode root, List<List<TreeNode>> lists, int level){
	//we recursively call this method for each level
	//exit case
	if(root ==null){
		return;
	}
	List<TreeNode> list = null;
	//if the level is same as the lists size then we can create a new list for this level
	if(level == lists.size()){
		list = new ArrayList<TreeNode>();
		lists.add(list);
	}else{
		list = lists.get(level);
	}
	list.add(root);
	//now recursively call the method for left and right child
	getTreeLevelLists(root.left, lists, level+1);
	getTreeLevelLists(root.right, lists, level+1);
}

public static void main(String args[]){
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
	List<List<TreeNode>> lists = new ArrayList<List<TreeNode>>();
	getTreeLevelLists(root, lists, 0);
	//now print the nodes of each list
	for(List<TreeNode> list: lists){
		for(TreeNode node:list){
			System.out.print(node.val+" ");
		}
		System.out.println();
	}
}

}