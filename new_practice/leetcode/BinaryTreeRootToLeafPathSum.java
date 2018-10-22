/**
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/

public class BinaryTreeRootToLeafPathSum{

	public boolean hasPathSum(TreeNode root, int sum){
		if(root==null){
			return sum==0;
		}
		//now recursively traverse the tree using DFS and check if the sum is obtained on the DFS path
		int cursum = 0;
		return performDFSTraversal(root, cursum, sum);
	}
	
	public boolean performDFSTraversal(TreeNode root, int cursum, int sum){
		if(root!=null && root.left==null && root.right==null && root.val+cursum==sum){
			return true;
		}
		if(root.left!=null){
			boolean leftvalid = performDFSTraversal(root.left, cursum+root.val, sum);
			if(leftvalid){
				return true;
			}
		}
		//now check the right branch
		if(root.right!=null){
			return performDFSTraversal(root.right, cursum+root.val, sum);	
		}
		return false;
		
	}
}