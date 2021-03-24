package com.alg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 */
/**
 * 
 * @author rbaral
 *
 */
 
 class ListNodeTestSet{
	 ListNode input;
	 ListNode result;
	 int elem;
	 
	public ListNodeTestSet(int[] inputs, int[] outputs, int elemIndex){
		ListNode curNode;
		for(int i=inputs.length-1;i>=0;i--){
			if(i==inputs.length-1)
				input = new ListNode(inputs[i]);
			else{
				curNode =new ListNode(inputs[i]);
				curNode.next = input;
				input = curNode;
			}
		}
		
		for(int i=outputs.length-1;i>=0;i--){
			if(i==outputs.length-1)
				result = new ListNode(outputs[i]);
			else{
				curNode =new ListNode(outputs[i]);
				curNode.next = result;
				result = curNode;
			}
		}
		this.elem = elemIndex;
		
	}
	public ListNode getInput() {
		return input;
	}
	public void setInput(ListNode input) {
		this.input = input;
	}
	public ListNode getResult() {
		return result;
	}
	public void setResult(ListNode result) {
		this.result = result;
	}
	public int getElem() {
		return elem;
	}
	public void setElem(int elem) {
		this.elem = elem;
	}
 }


public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		/**
		 * [1,2]
			1
		 */
		boolean test =false;
		if(test){
			performTest();
		}else{
			int nums[] = new int[]{1,2};
			int elemIndex = 1;
			ListNode node=null;
			ListNode curNode = null;
			for(int i=nums.length-1;i>=0;i--){
				if(i==nums.length-1)
					node = new ListNode(nums[i]);
				else{
					curNode = new ListNode(nums[i]);
					curNode.next = node;
					node = curNode;
				}
			}
			removeNthFromEnd(node,elemIndex);
		}

	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        if(head==null)
        	return head;
        for(int i=0;i<n-1;i++){
        	pointer1 = pointer1.next;
        }
        if(pointer1==null){//if reached end before reaching nth node from beginning
        	head = head.next; //if n is greater than the size of list, then remove the first node
        	return head;
        }
        do{
        	pointer2 = pointer2.next;
        }while(pointer1.next!=null);
        return pointer2;
    }
	
	
	public static void performTest(){
		List<ListNodeTestSet> testCases= new ArrayList<ListNodeTestSet>();
		List<String> failedCases = new ArrayList<String>();
		int inputs[],outputs[];// = new int[]{1,2};
		int elemIndex = 4;
		ListNodeTestSet testSet=null;
		inputs = new int[]{1,2,3,4,5};
		outputs = new int[]{1,3,4,5};
		testSet = new ListNodeTestSet(inputs, outputs, elemIndex);
		//testCases.add(testSet);
		inputs = new int[]{1,2};
		elemIndex = 1;
		outputs = new int[]{1};
		testSet = new ListNodeTestSet(inputs, outputs, elemIndex);
		testCases.add(testSet);
		ListNode result;
		ListNode expected;
		for(ListNodeTestSet testCase: testCases){
			result = removeNthFromEnd(testCase.input, testCase.elem);
			expected = testCase.result;
			if(!expected.toString().equals(result.toString())){
				failedCases.add("Failed for:{"+testCase.input.toString()+","+testCase.elem+"} got:"+result.toString()+" expected:"+expected.toString());	
			}
		}
		System.out.println("TEST RESULT, Passed:"+(testCases.size()-failedCases.size())+" failed:"+failedCases.size());
		for(String failure:failedCases)
			System.err.println(failure);
	}

}
