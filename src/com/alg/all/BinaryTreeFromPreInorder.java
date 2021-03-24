/**
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
*/
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 
public class BinaryTreeFromPreInorder{
 static Map<Integer, Integer> inmap=new HashMap<>();
/**
Method1:
-recursively build the tree using the inorder and preorder strings
Ref:https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34538/My-Accepted-Java-Solution
*/
	public static TreeNode buildTree(int[] iarr, int[] prearr){
		for(int i=0;i<iarr.length; i++){
			inmap.put(iarr[i], i);
		}
		return helper(iarr, prearr, 0, iarr.length-1, 0);
	}
	
	public static TreeNode helper(int[] iarr, int[] prearr, int istart, int iend, int pstart){
		//exit conditions
		if(pstart>prearr.length-1 || istart>iend){
			return null;
		}
		//get the root node from the pre-order array
		TreeNode root = new TreeNode(prearr[pstart]);
		//get the left subtree whose portion will be from istart to index of root in the preorder string
		int inindex = inmap.get(root.val);
		System.out.println("root is:"+root.val);
		root.left = helper(iarr, prearr, istart, inindex-1, pstart+1);//inindex holds the root node so the left portion is used
		//get the right node
		root.right = helper(iarr, prearr, inindex+1, iend, pstart+ inindex -istart+1);//inindex holds the root node so the right portion is used
		return root;
	}

	public static void main(String[] args){
		int[] preorder = new int[] {3,9,20,15,7};
		int [] inorder = new int[]{9,3,15,20,7};
		TreeNode root = buildTree(inorder, preorder);
		System.out.println("tree root is:"+root.val);
	}

}