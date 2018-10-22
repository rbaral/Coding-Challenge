/**
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeSubtree{

	/**
	we use recursive approach
	*/
	public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t==null){
			return true;
		}
		if(s==null && t==null){
			return true;
		}
		if(s.val==t.val){
			if(isMatchTree(s, t)){
				return true;
			}
		}
		//check on the left and right subtree of the source tree
		if(isSubtree(s.left, t)){
			return true;
		}
		return isSubtree(s.right, t);
    }
	
	public boolean isMatchTree(TreeNode n1, TreeNode n2){
		
		//if both empty, true
		if(n1==null && n2==null){
			return true;
		}
		//if only one emtpy, return false
		if((n1==null &&n2!=null) || (n2==null &&n1!=null)){
			return false;
		}
		//if the value matches, check on the subtree of both trees
		if(n1.val!=n2.val){
			return false;
		}
		return isMatchTree(n1.left, n2.left) && isMatchTree(n1.right, n2.right);
	}
}