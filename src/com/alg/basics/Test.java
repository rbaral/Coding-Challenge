/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author rbaral
 */
public class Test {
    
    public static List<String> topK(int k, Iterator<String> iter){
        PriorityQueue<String> minHeap = new PriorityQueue<>(3, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        while(iter.hasNext()){
            minHeap.add(iter.next());
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return new ArrayList<String>(minHeap);
    }
    
    public static void main(String args[]){
        Deque d = new LinkedList();
        
        
    }
}
