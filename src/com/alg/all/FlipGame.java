/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.locked;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rbara012
 * 
 * 
 * Problem Description:

You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, 
* you and your friend take turns to flip two consecutive "++" into "--". 
* The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
 

If there is no valid move, return an empty list [].
* 
 * 
 */
public class FlipGame {
    
    public static List<String> generatePossibleNextMoves(String s){
        List<String> moves = new ArrayList<String>();
        if(s==null){
            return moves;
        }
        
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length-1;i++){
            if(chars[i]==chars[i+1] && chars[i]=='+'){
                //is a valid move
                chars[i]=chars[i+1]='-';
                moves.add(new String(chars));
                //reset to look for other combinations
                chars[i]=chars[i+1]='+';
            }
        }
        return moves;
    }
    
    public static void main(String args[]){
        String a="++++";
        for(String res:generatePossibleNextMoves(a)){
            System.out.println("valid move:"+res.toString());
        }
    }
}
