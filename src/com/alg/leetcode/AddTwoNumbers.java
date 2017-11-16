/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
package com.alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author rbaral
 *
 */
public class AddTwoNumbers {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */

	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        List<Integer> sumOfList = new ArrayList<Integer>();
	        List<ListNode> listOfNodes = new ArrayList<ListNode>();
	        int item1=0, item2=0, carryOn=0;
	        if(l1!=null && l2!=null){
	            do{
	                item1=l1.val;
	                item2=l2.val;
	                //System.out.println(item1+"..."+item2);
	                listOfNodes.add(new ListNode((item1+item2+carryOn)%10));
	                carryOn=(item1+item2+carryOn)/10;
	                l1=l1.next;
	                l2=l2.next;
	            }while(l1!=null && l2!=null);
	        }
	        if(l1!=null){
	            do{
	            item1=l1.val;
	            listOfNodes.add(new ListNode((item1+carryOn)%10));
	            carryOn = (item1+carryOn)/10;
	            l1=l1.next;
	        }while(l1!=null);
	        }
	        else if(l2!=null){
	          do{
	            item2=l2.val;
	            listOfNodes.add(new ListNode((item2+carryOn)%10));
	            carryOn = (item2+carryOn)/10;
	            l2=l2.next;
	        }while(l2!=null);  
	        }
	        if(l1==null && l2==null && carryOn>0){
	            listOfNodes.add(new ListNode(carryOn));
	        }
	       
	        ListNode lNode = null;
	        if(listOfNodes.size()>0){
	             lNode = listOfNodes.get(0);
	        }
	        
	        for(int i=listOfNodes.size()-2;i>0;i--){
	            listOfNodes.get(i).next=listOfNodes.get(i+1);
	        }
	        if(listOfNodes.size()>1)
	            lNode.next=listOfNodes.get(1);
	        return lNode;
	    }
	}

