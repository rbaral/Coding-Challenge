/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;

/**
 *Write a method to count the number of 2s between 0 and n.
 * @author rbaral
 */
public class CountTwos {
    /**
     * counts the number of 2 digits between 0 and n
     * @param a
     * @return 
     */
    static int countTwos(int a){
        int count = 0;
        for(int i=2;i<=a;i++){
            count+=numberOf2s(i);
        }
        return count;
    }
    
    static int numberOf2s(int a){
        int count = 0;
        while(a>0){
            if(a%10==2){
                count++;
            }
            a = a/10;
        }
        return count;
    }
    
    public static void main(String args[]){
        System.out.println("count of 2's is:"+countTwos(20));
    }
}
