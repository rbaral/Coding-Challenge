/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.locked;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author rbaral
 * 
 * Implement an iterator to flatten a 2d vector.

For example, Given 2d vector =
[
[1,2],
[3],
[4,5,6]
]

By calling next repeatedly until hasNext returns false, 
* the order of elements returned by next should be: [1, 2, 3, 4, 5, 6].
 * 
 */
public class Flatten2DVector {
    Iterator<List<Integer>> i;
    Iterator<Integer> j;
    
    public Flatten2DVector(List<List<Integer>> vec){
        this.i = vec.iterator();
    }
    
    public int next(){
        hasNext();
        return j.next();
    }
    
    public boolean hasNext(){
        while((j==null || !j.hasNext()) && i.hasNext()){
            j = i.next().iterator();
        }
        return j!=null && j.hasNext();
    }
    
    
    public static void main(String args[]){
        List<List<Integer>> nums = new ArrayList<List<Integer>>();
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();
        List<Integer> c = new ArrayList<Integer>();
        a.add(1); a.add(2);
        b.add(3);
        c.add(4);c.add(5);c.add(6);
        nums.add(a);
        nums.add(b);
        nums.add(c);
        Flatten2DVector flatVector = new Flatten2DVector(nums);
        while(flatVector.hasNext()){
            System.out.println("next elem is:"+flatVector.next());
        }
        
    }
}
