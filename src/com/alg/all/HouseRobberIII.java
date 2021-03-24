/**
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

Output: 7 
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
*/

public class HouseRobberIII{

	public int rob(TreeNode root) {
        if(root==null){
			return 0;
		}
		int[] res = robHelper(root);
		return Math.max(res[0], res[1]);
    }
	
	/**
	recursively check if including a root node is maximum profit or excluding it
	*/
	public static int[] robHelper(TreeNode root){
		if(root==null){
			return new int[]{0,0};
		}
		int[] left = robHelper(root.left);
		int[] right = robHelper(root.right);
		int[] res = new int[2];
		//when the root is taken, the grand child of it can be taken
		//res[0] holds the profit when root is taken, and res[1] is when the root is not taken
		res[0] = root.val + left[1] + right[1];
		//left[1] holds the max profit when the left node used its child node and not itself
		//right[1] is defined similarly
		res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return res;
	}
}