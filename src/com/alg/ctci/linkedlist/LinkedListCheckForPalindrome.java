/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci.linkedlist;

/**
 * Implement a function to check if a linked list is a palindrome
 *
 * Solution 1: Create a linked list that is reverse of the given list and check
 * if every node has a match.
 *
 * Solution 2: We store the first half of the linked list into a stack and
 * compare it with the second half by iterating through them
 *
 * @author rbaral
 */
public class LinkedListCheckForPalindrome {

    /**
     * checks if a linkedlist is a palindrome by iterative method
     *
     * @param n
     * @return
     */
    static boolean isPalindrome(LinkedListNode n) {
        //handle the base cases here
        if (n == null) {
            return false;
        } else if (n.nextNode == null) {//has only one element, which will be palindrome too
            return true;
        } else {

            //we define two pointers - one is fast and one is slow. The fast hops two nodes and the slow hops one node.
            //when the fast reaches the end, the slow should be in the middle.
            LinkedListNode fast = n;
            LinkedListNode slow = n;
            java.util.Stack<Integer> st = new java.util.Stack<Integer>();
            //lets advance the two pointers
            while (fast != null) {
                fast = fast.nextNode; //just make one hop to handle the null end easily

                if (fast != null) {//second step for the fast pointer by checking if we already reached end in the before step
                    //now we push the first half of the linked list to the stack
                    System.out.println("pushing " + slow.data);
                    st.push(slow.data);
                    slow = slow.nextNode; 
                    
                    fast = fast.nextNode;
                    
                } else {//already reached the end
                    slow = slow.nextNode; //even when the fast is null, the slow advances once because fast has advanced once but couldn't do twice due to odd elements in the list
                    break;
                }
            }
            System.out.println(slow.printForward());
            //now pop the elements from the stack and compare with the second half of the linked list
            int stItem;
            while (slow != null) {
                stItem = st.pop();
                System.out.println("comparing " + stItem + " vs " + slow.data);
                if (slow.data != stItem) {
                    return false;
                }
                slow = slow.nextNode;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        //lets create some nodes and add them to a linked list
        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode second;
        LinkedListNode current = head;
        //lets create linked list with 10 nodes and a loop somewhere in the middle
        LinkedListNode loopStartNode = null;
        int[] nums = {2, 2, 1}; //1 is already added to the linkedlist
        for (int i = 0; i < nums.length; i++) {
            second = new LinkedListNode(nums[i]);
            current.nextNode = second;
            current = second;
        }
        System.out.println(head.printForward());
        System.out.println(isPalindrome(head));
    }
}
