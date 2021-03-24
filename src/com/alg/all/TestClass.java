/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics.java;

/**
 *
 * @author rbaral
 */
public class TestClass {
    public static void main(String[] args){
        NestedClassDemo.TestInnerClass a = new NestedClassDemo().new TestInnerClass();
        NestedClassDemo.TestInnerStatic b = new NestedClassDemo.TestInnerStatic();
    }
}
