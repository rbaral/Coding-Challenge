/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ccup;

import java.util.Arrays;

/**
 *
 * @author rbaral
 */
public class MinCoinchange {
    int[] coins;
    int amt;
    int[] coinCount;
    int[] coinsUsed;
    
    public MinCoinchange(int[] coins, int amt, int[] coinCount, int[] coinsUsed){
        this.coins = coins;
        this.amt = amt;
        this.coinsUsed = coinsUsed;
        this.coinCount = coinCount;
        
    }
    public int[] getChanges(){
        return makeChangeDynamic(coins, amt, coinCount, coinsUsed);
    }

    public int[] makeChangeDynamic(int[] coins, int amt, int[] minCoins, int[] coinsUsed) {
        for(int cents=0;cents<=amt;cents++){
            int coinCount = cents;
            int newCoin = 1;
            for(int j = 0;j<coins.length;j++){
                if(coins[j]<=cents){
                    if((minCoins[cents -coins[j]]+1) <coinCount){
                        coinCount = minCoins[cents-coins[j]]+1;
                        newCoin = coins[j];
                    }
                }
            }
            minCoins[cents] = coinCount;
            coinsUsed[cents] = newCoin;
        }
        //System.out.println(minCoins[amt]);
        return coinsUsed;
    }
    
    

    public static void main(String[] args) {
        int[] coins = {1, 5, 10,25};
        int amount = 9;
        int[] coinsUsed = new int[amount+1];
        int[] coinCount = new int[amount+1];
        MinCoinchange m = new MinCoinchange(coins, amount, coinCount, coinsUsed);
        coinsUsed = m.getChanges();
        int coin = amount;
        while(coin>0){
            System.out.println(coinsUsed[coin]);
            coin = coin - coinsUsed[coin];
        }
    }
}
