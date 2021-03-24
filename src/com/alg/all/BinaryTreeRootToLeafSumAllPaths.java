/**
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
*/

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class BinaryTreeRootToLeafSumAllPaths{

	/**
	recursively perform DFS and check if the path so far yields the given sum,
	if found, store that path in a list, and move forward
	-if not found, move forward
	*/
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        
		List<List<Integer>> paths = new ArrayList<List<Integer>>();
		if(root==null){
			return paths;
		}
		List<Integer> curpath = new ArrayList<Integer>();
		performDFSTraversal(root, paths, curpath, 0, sum);
		return paths;
    }
	
	public static void performDFSTraversal(TreeNode root, List<List<Integer>> paths, List<Integer> curpath, int cursum, int sum){
		if(root==null){
			return;
		}
		//add the current node to the path
		curpath.add(root.val);
		cursum+=root.val;
		
		if(root.left==null && root.right==null){
			if(cursum==sum){
				paths.add(new ArrayList<Integer>(curpath));
			}
		}
		performDFSTraversal(root.left, paths, curpath, cursum, sum);
		performDFSTraversal(root.right, paths, curpath, cursum, sum);
		curpath.remove(curpath.size()-1);
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(5);
		TreeNode four = new TreeNode(4);
		TreeNode four2 = new TreeNode(4);
		TreeNode eight = new TreeNode(8);
		TreeNode eleven = new TreeNode(11);
		TreeNode thirteen = new TreeNode(13);
		TreeNode seven = new TreeNode(7);
		TreeNode two = new TreeNode(2);
		TreeNode one = new TreeNode(1);
		root.left = four;
		root.right = eight;
		four.left = eleven;
		eleven.left = seven;
		eleven.right = two;
		eight.left = thirteen;
		eight.right = four2;
		four2.left = new TreeNode(5);
		four2.right = one;
		int sum = 22;
		List<List<Integer>> paths = pathSum(root, sum);
		for(List<Integer> path:paths){
			System.out.println(Arrays.toString(path.toArray(new Integer[path.size()])));
		}
	}
}