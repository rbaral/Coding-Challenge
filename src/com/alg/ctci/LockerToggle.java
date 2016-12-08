/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;

/**
 *There are 100 closed lockers in a hallway. A man begins by opening all 100 lockers.
Next, he closes every second locker. Then, on his third pass, he toggles every third
locker (closes it if it is open or opens it if it is closed). This process continues for / 00
passes, such that on each pass i, the man toggles every ith locker. After his 100th
pass in the hallway, in which he toggles only locker #100, how many lockers are
open?
* 
 * @author rbaral
 */
public class LockerToggle {
    
    static int[] processLockers(int [] lockers){
        for(int i =0; i<100; i++){//passes
            //toggle every ith locker
            for(int j=0;j<100;j++){//lockers
                if((j+1)%(i+1)==0){
                    //toggle the locker
                    lockers[j] = 1 - lockers[j];
                }
            }
        }
        return lockers;
    }
    public static void main(String args[]){
        //create 100 lockers that are closed; 0 - closed; 1- opened
        int [] lockers = new int[100];
        processLockers(lockers);
        //now count the opened lockers
        int openedLockers = 0;
        for(int i=0;i<100;i++){
            if(lockers[i]==1)
                openedLockers++;
        }
        System.out.println("opened lockers:"+openedLockers);
    }
}
