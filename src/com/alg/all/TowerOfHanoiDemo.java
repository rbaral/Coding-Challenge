/*
In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
different sizes which can slide onto any tower. The puzzle starts with disks sorted
in ascending order of size from top to bottom (i.e., each disk sits on top of an even
larger one). You have the following constraints:
(T) Only one disk can be moved at a time.
(2) A disk is slid off the top of one tower onto the next rod.
(3) A disk can only be placed on top of a larger disk.
Write a program to move the disks from the first tower to the last using Stacks.
 */
package com.alg.practice;

/**
 *
 * @author rbaral
 */
//a tower is a stack of numbers
class Tower {

    MyStack disks;
    int index; //tower index to identify tower

    public Tower(int index) {
        this.index = index;
        disks = new MyStack();
    }

    public void add(Object item) {
        if(disks.peek()!= null && (int)disks.peek()<= (int)item) {
            //cannot be added
            System.err.println("given item " + item + " is smaller than peek " + disks.peek());
        }else {
            //add item to the tower
            disks.push(item);
        }
    }
    //moves this tower's top item to another tower if possible

    public void moveTopItem(Tower t) {
        if(t.disks.peek()==null || (int)t.disks.peek() > (int)this.disks.peek()) {
            t.add(this.disks.pop());
        }else {
            //item cannot be moved to target tower
            System.err.println("target tower not feasible");
        }
    }
}

class TowerOfHanoi {

    public TowerOfHanoi() {

    }
    //method that moves items between towers
    //move the top (n-1) items to a buffer tower

    public void moveItems(int n, Tower orig, Tower buff, Tower dest) {
        //recursively move top n-1 items
        if (n > 0) {
            moveItems(n - 1, orig, dest, buff); //the dest of n-1 items is to the buffer tower
            //move the last left one from orig to dest
            orig.moveTopItem(dest);
            //now use the buffer as source and the orig as buffer
            moveItems(n - 1, buff, orig, dest);
        }
    }

}

public class TowerOfHanoiDemo {

    public static void main(String args[]) {
        //lets create three towers
        Tower t1 = new Tower(0);
        Tower t2 = new Tower(1);
        Tower t3 = new Tower(2);
        int itemsCount = 5;
        //add some items to tower t1
        for (int i = itemsCount;i>= 0; i--) {//add larger items first
            t1.add(i);
        }
        TowerOfHanoi toh = new TowerOfHanoi();

        toh.moveItems(itemsCount, t1, t2, t3);
        //now repeatedly print the items of t3 to make sure that every item moved in correct order

        System.out.println("Items in Tower3");
        while (t3.disks.peek()!= null) {
            System.out.print(" " + t3.disks.pop());
        }

        System.out.println("");
    }
}
