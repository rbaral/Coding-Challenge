/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

import java.util.HashMap;
import java.util.Map;

/**
 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
* 
 *
 * The idea is to have the stones not multiple of 4 when its your turn because when its your turn
 * and there are 4 (or multiple of 4) stones, no matter how many stones we withdraw, the opponent will
 * withdraw to leave 4 stones on our turn. So we loose.
 * So the idea is to have stones that is not multiple of 4 and then we can win.
 * 
 * @author rbaral
 */
public class NimGame {
    
    static boolean canWinNim(int n){
        //base case
        if(n<=0){
            return false;
        }
        return (n%4!=0);
       
    }
    public static void main(String args[]){
        //System.out.println("can win: "+canWinNim(5));
        System.out.println("can win:"+canWinNim(1348820612));
    }
}
