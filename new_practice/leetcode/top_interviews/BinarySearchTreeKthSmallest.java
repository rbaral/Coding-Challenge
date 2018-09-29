/**
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
	public String toString(){
		return String.valueOf(val);
	}
}
 
public class BinarySearchTreeKthSmallest{

	/**
	Method1:
	-perform in-order traversal of the given tree to get an in-order traversal string
	-scan the in-order traversal string to get the k-th item
	-Optimize: we can stop the in-order traversal when the in-order string is of length k
	O(n)
	*/
	public static int kthSmallest1(TreeNode root, int k) {
        List<TreeNode> nodesList = new ArrayList<TreeNode>();
		getInOrderTraversal(root, nodesList);
		System.out.println("In order string is:"+Arrays.toString(nodesList.toArray(new TreeNode[nodesList.size()])));
		return nodesList.get(k-1).val;
    }
	
	public static void getInOrderTraversal(TreeNode root, List<TreeNode> nodesList){
		if(root==null){
			return;
		}
		if(root.left!=null){
			getInOrderTraversal(root.left, nodesList);
		}
		nodesList.add(root);
		if(root.right!=null){
			getInOrderTraversal(root.right, nodesList);
		}
	}
	
	public static void main(String args[]){
		//lets create a bst
		TreeNode three = new TreeNode(3);
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode four = new TreeNode(4);
		three.left = one;
		one.right = two;
		three.right = four;
		int k =1;
		System.out.println(k+" th smallest element is: "+ kthSmallest1(three, 1));
	}

}