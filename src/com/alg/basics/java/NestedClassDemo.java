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
public class NestedClassDemo {
    private int a = 100;
    int b = 200;
    private static int c = 500;

    public NestedClassDemo() {
        TestInnerStatic teststat = new TestInnerStatic();
        System.out.println("const of NestedClassDemo, a is:"+a+", b is:"+b+".."+teststat.teststat_a);
    }
    
    public String getTask1(){
        return new TestInnerClass().getTask1();
    }
    
    public String getTask2(){
        return getTask1();
    }
    
    
    class TestInnerClass{
        int test_a = 10;

        TestInnerClass() {
            System.out.println("const of testinner private member of outerlcass"+a+"..."+c);
        }
        String getTask1(){
            return "task1 from inner:"+test_a+","+a;
        }
    }
    
    static class TestInnerStatic{
        int teststat_a = 20;

        public TestInnerStatic() {
            System.out.println("const of testinnerstat:"+teststat_a+" member of outer:"+c);
        }
        
        String getTask1stat(){
            return "task1 from inner stat:"+teststat_a+","+c;
        }
    }
    
    public static void main(String[] args){
        TestInnerStatic teststat = new TestInnerStatic();
        System.out.println(teststat.teststat_a);
        NestedClassDemo nestdemo = new NestedClassDemo();
        System.out.println(nestdemo.getTask1()+"...."+nestdemo.getTask2());
    }
}
class C{
    
    NestedClassDemo.TestInnerStatic teststat = new NestedClassDemo.TestInnerStatic();
}
