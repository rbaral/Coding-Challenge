/**
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class BinaryTreeLevelOrderTraversal{


	/**
	MEthod1:
	-we perform recursive solution
	*/
	public static List<List<Integer>> levelOrder1(TreeNode root) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		//TODO: handle base case
		if(root==null)
			return lists;
		levelOrderRecursive(root, lists, 0);
		return lists;
    }
	
	public static void levelOrderRecursive(TreeNode root, List<List<Integer>> lists, int level){
		if(root==null){
			return;
		}
		if(lists.size()==level){//create a new list for this level
			lists.add(new ArrayList<Integer>());
		}
		lists.get(level).add(root.val);
		levelOrderRecursive(root.left, lists, level+1);
		levelOrderRecursive(root.right, lists, level+1);
	}
	
	
	public static void main(String[] args){
		TreeNode three = new TreeNode(3);
		TreeNode nine = new TreeNode(9);
		TreeNode twenty = new TreeNode(20);
		TreeNode fifteen = new TreeNode(15);
		TreeNode seven = new TreeNode(7);
		three.left = nine;
		three.right = twenty;
		twenty.left = fifteen;
		twenty.right = seven;
		
		List<List<Integer>> lists = levelOrder1(three);
		for(List<Integer> list:lists){
			System.out.println(Arrays.toString(list.toArray(new Integer[list.size()])));
		}
	}
}