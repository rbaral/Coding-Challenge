/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

import java.util.Stack;

class Tower {

    Stack<Integer> disks;
    int index;

    public Tower(int val) {
        index = val;
        disks = new Stack<Integer>();
    }

    int top() {
        return disks.isEmpty() ? -1 : disks.peek();
    }

    void add(int val) throws Exception {
        if (disks.isEmpty() || val < disks.peek()) {
            disks.push(val);
        } else {
            throw new Exception("val is greater than top");
        }
    }

    void moveTop(Tower dest) throws Exception {
        if (!dest.disks.isEmpty() && dest.top() <= this.top()) {
            throw new Exception("dest " + dest.index + " top " + dest.top() + " is smaller than current:" + index + " top " + top());
        } else {
            dest.disks.push(disks.pop());
        }
    }

    void moveDisks(int n, Tower buff, Tower dest) throws Exception {
        if (n <= 0) {
            return;
        }
        //move top n-1 disks to buff and the n disk to dest
        moveDisks(n - 1, dest, buff);
        //move the n disk to dest
        moveTop(dest);
        //now move the n-1 disks from buff to dest, use this tower as intermediate
        buff.moveDisks(n - 1, this, dest);
    }

    void printTopItem() {
        if (this.top() != -1) {
            System.out.println("Tower:" + index + " has :" + this.top());
        } else {
            System.out.println("Tower:" + index + " is empty :");
        }
    }

}

public class TowerofHanoi {

    public static void main(String args[]) throws Exception {
        //create three towers
        Tower[] towers = new Tower[3];
        towers[0] = new Tower(0);
        towers[1] = new Tower(1);
        towers[2] = new Tower(2);
        //add items to the first tower
        towers[0].add(3);
        towers[0].add(2);
        towers[0].add(1);
        towers[0].printTopItem();
        towers[1].printTopItem();
        towers[2].printTopItem();
        //now move the disks
        towers[0].moveDisks(3, towers[1], towers[2]);
        towers[0].printTopItem();
        towers[1].printTopItem();
        towers[2].printTopItem();

    }

}
