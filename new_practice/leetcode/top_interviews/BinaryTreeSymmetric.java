/**
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
*/

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreeSymmetric{
	
	public static void getInorderString(TreeNode root, StringBuffer sb){
		if(root==null){
			sb.append("NULL ");
			return;
		}
		//process left node
		getInorderString(root.left, sb);
		//process the node
		sb.append(root.val+" ");
		//process right node
		getInorderString(root.right, sb);
	}
	
	/**
	MEthod1:
	-we perform inorder traversing of the tree and mark "NULL" for the null nodes
	-the inorder processed string is compared using two pointers p1 (that  points at first) and p2(that points at last)
	if element at p1 is equal to element at p2 then we keep on advancing p1++ and p2--, if they don't match we return false
	*/
	public static boolean issymmetric1(TreeNode root){
		//handle base case
		if(root==null || (root.left==null && root.right==null))
			return true;
        //if this is the first root then its left and right child should be same
        if((root.left==null && root.right!=null ) || (root.left!=null && root.right==null) || (root.left.val!=root.right.val))
            return false;
		StringBuffer sb = new StringBuffer();
		getInorderString(root, sb);
		String instring = sb.toString().trim();
		String[] tokens = instring.split(" ");
		int p1 = 0;
		int p2 = tokens.length-1;
		System.out.println("inorder string is:"+instring);
		while(p1<p2 && p1<tokens.length){
			if(!tokens[p1].equals(tokens[p2])){
				return false;
			}
			p1++;
			p2--;
		}
		return true;
	}
	
	/**
	recursively check if the two trees have similar structure
	*/
	public static boolean issymmetric2helper(TreeNode root1, TreeNode root2){
		if(root1==null && root2==null){//if both child are null 
			return true;
		}else if(root1==null || root2==null){//if only one is null
			return false;
		}else if(root1.val==root2.val){//if the value of the current root of both the trees are equal, then check for the next level
			return issymmetric2helper(root1.left, root2.right) && issymmetric2helper(root1.right, root2.left);
		}
        return false;//no match return false
	}
	
	/**
	Method2
	-perform recursive solution
	*/
	public static boolean issymmetric2(TreeNode root){
		if(root==null){
			return true;
		}else{
			return issymmetric2helper(root, root);
		}
	}
	
	
	/**
	Method3:
	-perform DFS but in slight different way, one goes on the left side and another on the right side (like mirror)
	-we put the items in stack as we go on performing the DFS
	-repeat till there are some items in the stack and check if the value of the items popped from the stack match
	*/
	public static boolean issymmetricIterative(TreeNode root){
		if(root==null)
			return true;
		Stack<TreeNode> stackNode = new Stack<TreeNode>();
		TreeNode p = root;
		TreeNode q = root;
		while(p!=null || q!=null ||!stackNode.isEmpty()){
			if(p!=null && q!=null){//both child  nodes are not null
				if(p.val!=q.val){
					return false;
				}else{
					//now go on next level
					stackNode.push(p.left);
					stackNode.push(q.right);
					p = p.right;
					q = q.left;
				}
			}else if(p==null && q==null){//both child nodes are null, lets check others from the stack
				//proceed with the items from the top of the stack
				p = stackNode.pop();
				q = stackNode.pop();
			}else{//only one of the child node is not null
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]){
		TreeNode root1 = new TreeNode(1);
		TreeNode two1 = new TreeNode(2);
		TreeNode two2 = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		root1.left = two1;
		root1.right = two2;
		two1.left = three;
		two1.right = four;
		two2.left = four;
		//two2.right = three;
		System.out.println("issymmetric1:"+issymmetric1(root1));
		System.out.println("issymmetric2:"+issymmetric2(root1));
		System.out.println("issymmetric3:"+issymmetricIterative(root1));
	}

}