/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

import java.util.Random;

/**
 *
 * @author rbara012
 * 
 * 
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();
 * 
 * 
 * Start...
When we read the first node "head", if the stream "ListNode" stops here, we can just return the head.val. The possibility is 1/1.

When we read the second node, we can decide if we replace the result 'r' or not. The possibility is 1/2. So we just generate a random number between 0 and 1, and check if it is equal to 1. If it is 1, replace 'r' as the value of the current node, otherwise we don't touch 'r', so its value is still the value of head.

When we read the third node, now the result 'r' is one of value in the head or second node. We just decide if we replace 'the value of r' as 'the value of current node(third node)'. The possibility of replacing it is 1/3, namely the possibility of we don't touch r is 2/3. So we just generate a random number between 0 ~ 2, and if the result is 2 we replace 'r'.

We can continue to do like this until the end of stream "ListNode".
* Ref: https://discuss.leetcode.com/topic/55049/java-solution-with-cases-explain/2
 */
public class LinkedListRandomNode {
    ListNode head;
    
    
    public LinkedListRandomNode(ListNode n){
        head = n;
    }
    
    public int getRandom(){
        ListNode cur = head;
        int val = cur.val;
        for(int i =1; cur.next!=null;i++){
            cur = cur.next;
            //generate a random number and check if it is equal to i, if so, update the value
            if(randInt(0,i)==i)
                val = cur.val;
        }
        return val;
    }
    
    public static int randInt(int min, int max){
        Random rand = new Random();
        return min + rand.nextInt((max-min)+1);
    }
    
    public static void main(String args[]){
        System.out.println(randInt(1, 5)+"...."+Math.random());
    }
}
