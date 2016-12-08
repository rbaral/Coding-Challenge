/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author rbaral
 */
public class TestClass {
    
    public static void main(String args[]){
        LinkedList myLinkedList = new LinkedList();
        myLinkedList.add(0, 1);
        myLinkedList.add(1,3);
        System.out.println(myLinkedList.size());
        Iterator iter = myLinkedList.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
