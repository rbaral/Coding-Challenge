/*
Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

Example 1:
Input: 
    1
   / \
  0   2

  L = 1
  R = 2

Output: 
    1
      \
       2
Example 2:
Input: 
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output: 
      3
     / 
   2   
  /
 1
 */
package com.alg.leetcode.incomplete;

import com.alg.leetcode.TreeNode;

/**
 *
 * @author rbaral
 */
public class TrimBinarySearchTree {
     
    public TreeNode trimBST(TreeNode root, int L, int R) {
        //first check if the root node is valid or not
        if(root.val<L || root.val>R){
            //get the successor and replace the root
            if(root.right==null){
                root = root.left;
            }else if(root.left==null){
                root = root.right;
            }
            else{
                TreeNode succ = getNextSuccessor(root.right);
                root.val = succ.val;
                
                //now remove the successor node
                removeNode(root, root.right, succ.val);
            }
            
        }
        if(root.val<L || root.val>R){
            trimBST(root, L, R);
        }
        if(root.left!=null){
            trimBSTLeft(root, root.left, L, R);
        }
        if(root.right!=null){
            trimBSTRight(root, root.right, L, R);
        }
        return root;
    }
    
    public void trimBSTLeft(TreeNode par, TreeNode cur, int L, int R){
        if(cur!=null && (cur.val<L || cur.val>R)){
            //no child
            if(cur.left==null && cur.right==null){
                par.left = null;
            }else if(cur.left==null){//no left child
                par.left = cur.right;
            }else if(cur.right==null){//no right child
                par.left = cur.left;
            }else{//has both childs
                //get the successor value from the right subtree
                TreeNode succ = getNextSuccessor(cur.right);
                //the successor will replace the current node
                par.left.val = succ.val;
                
                //now remove the successor node
                removeNode(cur, cur.right, succ.val);
            }
            cur = par.left;
        }
        //repeat the trimming process
        if(cur!=null && (cur.val<L || cur.val>R)){
            trimBSTLeft(par, cur, L, R);
        }
        
        //trim on the left
        if(cur!=null && cur.left!=null){
            trimBSTLeft(cur, cur.left, L, R);
        }
        //trim on the right
        if(cur!=null && cur.right!=null){
            trimBSTRight(cur, cur.right, L, R);
        }
    }
    /**
     * finds the minimum element from the right subtree of the given node
     * the minimu element is either the node itself (when it has no left child) or the leftmost grand child of it
     * @param cur
     * @return 
     */
    public TreeNode getNextSuccessor(TreeNode cur){
        if(cur.left==null){
            return cur;
        }else{
          return getNextSuccessor(cur.left);
        }
    }
    
    /**
     * remove the node with the given value, if present in tree with the Root at root
     * @param par
     * @param cur
     * @param val 
     */
    public void removeNode(TreeNode par, TreeNode cur, int val){
        if(val<cur.val){
            removeNode(cur, cur.left, val);
        }else if(val>cur.val){
            removeNode(cur, cur.right, val);
        }else{
            //we found the node to be replaced
            if(cur.left==null && cur.right==null){
                if(par.left!=null && par.left.val == cur.val)
                    par.left = null;
                else if(par.right!=null && par.right.val == cur.val)
                    par.right = null;
            }else if(cur.left==null){//no left child
                if(par.right!=null && par.right.val == cur.val)//is this node left side or right side of parent node?
                    par.right = cur.right;
                else
                    par.left = cur.right;
            }else if(cur.right==null){//no right child
                if(par.right!=null && par.right.val == cur.val)//is this node left side or right side of parent node?
                    par.right = cur.left;
                else
                    par.left = cur.left;
            }else{// has both child
                TreeNode succ = getNextSuccessor(cur.right);
                cur.val = succ.val;
                //now remove the successor node
                removeNode(cur, cur.right, cur.val);
            }
            
        }
    }
    
    
    
    public void trimBSTRight(TreeNode par, TreeNode cur, int L, int R){
        if(cur!=null &&(cur.val<L || cur.val>R)){
            //no child
            if(cur.left==null && cur.right==null){
                par.right = null;
            }else if(cur.left==null){//no left child
                par.right = cur.right;
            }else if(cur.right==null){//no right child
                par.right = cur.left;
            }else{//has both childs
                //get the successor value from the right subtree
                TreeNode succ = getNextSuccessor(cur.right);
                //the successor will replace the current node
                par.right.val = succ.val;
                
                //now remove the successor node
                removeNode(par.right, par.right.right, succ.val);
            }
            cur = par.right;
        }
        //repeat the trimming process
        if(cur!=null &&(cur.val<L || cur.val>R)){
            trimBSTRight(par, cur, L, R);
        }
        //trim on the left
        if(cur!=null && cur.left!=null){
            trimBSTLeft(cur, cur.left, L, R);
        }
        //trim on the right
        if(cur!=null && cur.right!=null){
            trimBSTRight(cur, cur.right, L, R);
        }
    }
}
