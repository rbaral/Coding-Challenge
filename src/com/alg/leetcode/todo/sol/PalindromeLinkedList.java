/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.todo.sol;

import com.alg.leetup.ListNode;

/**
 *
 * Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
* 
* Solution 1:
* 1)Scan the linked list and store the value of every node to a stack
* 2)In second pass, scan the linked list again and compare it with the popped element from the stack
* 2 a) if its a match then continue to compare with next element
* 2 b) if no match then return false
* 2 c) if we reached till the stack is empty then return true
* 
* Complexity: O(n) to scan linked list and O(n) to push to stack + O(n) to scan and O(n) to pop from stack
* Space : O(n)
* 
* Solution 2:
* 1)use two pointers - fast and slow; the fast pointer advances twice and the slow pointer advances once
* 2)when the fast pointer points to null (crossed the end of list), the slow pointer is at the middle of the list
* 3)Now use the slow pointer to reverse the right half of the list (just bring the second, third...nth nodes to the head position)
* 4)compare the first half with the second half
* 
* Complexity: O(n); Space O(1)
* 
* Solution 3:
* 1)We can use recursion and check if the two ends are equal
* 2) pointer 1 points to head and a recursion repeats till the next element is null (we reached the extreme of the list)
* 3)check if the two elements are equal, if not return false
* 4)if equal, advance the pointer1 and the recursion will have the pointer to second last element
* 
* 
* 
 * @author rbaral
 */
public class PalindromeLinkedList {
    ListNode left;
    public boolean isPalindrome3(ListNode head){
        left = head;
        return isExtremeEndEqual(head);
    }
    
    public boolean isExtremeEndEqual(ListNode right){
        if(right==null){
            return true; //we reached the end
        }
        
        //recursively advance the sublist
        boolean isSubListPalindrome = isExtremeEndEqual(right.next);
        if(!isSubListPalindrome){
            return false;
        }
        boolean extremeEqual = (left.val==right.val);
        //advance the left portion
        left = left.next;
        return extremeEqual;
    }
    
}
