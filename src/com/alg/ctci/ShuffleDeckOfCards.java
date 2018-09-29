/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;

import java.util.Arrays;

/**
 *Write a method to shuffle a deck of cards. It must be a perfect shuffle—in other
words, each of the 52! permutations of the deck has to be equally likely. Assume that
you are given a random number generator which is perfect.
 * 
 * 
 * 
 * Solution 1:
 * Let's imagine our n-element array. Suppose it looks like this:
[1] [2] [3] [4] [5]
Using our Base Case and Build approach, we can ask this question: suppose we had a
method shuffle ( . . .) that worked on n - 1 elements. Could we use this to shuffle
n elements?
* 
 * 
 * @author rbaral
 */
public class ShuffleDeckOfCards {
    
    static int random(int low, int high){
        return low + (int)(Math.random()*(high - low +1));
    }
    
    static int[] shuffleRecursive(int[] cards, int i){
        if(i==0){
            return cards;
        }else{
            /**
             * get teh shuffled cards from other i-1 cards
             * and add this card to every possible postion
             * within those other cards
             */
            shuffleRecursive(cards, i-1);
            int ran = random(0, i); //the inserting or swapping position
            int temp = cards[i];
            cards[i] = cards[ran];
            cards[ran] = temp;
        }
        return cards;
    }
    
    static int[] shuffleIteratively(int[] cards, int a){
        for(int i = 0;i <=a; i++){
            int k = random(i, a);
            int temp = cards[k];
            cards[k] = cards[i];
            cards[i] = temp;
        }
        return cards;
    }
    
    public static void main(String args[]){
        //System.out.println(rand(3,6));
        int cards[] = new int[52];
        for(int i=0;i<52;i++){
            cards[i] = i+1;
        }
        System.out.println("Before shuffling:"+Arrays.toString(cards));
        shuffleRecursive(cards, 10);
        System.out.println("after shuffling:"+Arrays.toString(cards));
    }
}
