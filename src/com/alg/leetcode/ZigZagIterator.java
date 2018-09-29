/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author rbara012
 * 
 * 
 * Given two 1d vectors, implement an iterator to return their elements alternately.

For example, given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

[1,2,3]
[4,5,6,7]
[8,9]
It should return [1,4,8,2,5,9,3,6,7].
* 
 * 
 */
public class ZigZagIterator {
    LinkedList<Iterator> list;
    public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<Iterator>();
        if(!v1.isEmpty()) list.add(v1.iterator());
        if(!v2.isEmpty()) list.add(v2.iterator());
    }

    public int next() {
        Iterator poll = list.remove();
        int result = (Integer)poll.next();
        if(poll.hasNext()) list.add(poll);
        return result;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
    
    public static void main(String args[]){
       int[] v1 = {1, 2};
       int [] v2 = {3, 4, 5, 6};
       List<Integer> l1 = new ArrayList<Integer>();
       l1.add(1);l1.add(2);
       List<Integer> l2 = new ArrayList<Integer>();
       l2.add(3);l2.add(4);l2.add(5);l2.add(6);
       ZigZagIterator it = new ZigZagIterator(l1, l2);
       while(it.hasNext()){
           System.out.print(""+it.next());
       }
        System.out.println("");
    }
}
