/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

import java.util.List;
import java.util.ArrayList;

/**
 * Given an array of boxes with height, width, and depth. Find the maximum
 * possible height we can get, given that every box should be of less in height,
 * width, and depth, than that of the box below it.
 *
 */
/**
 * Sol: We recursively check for the sequence that we can get with each box in
 * bottom
 */
class Box {

    int width, height, depth;

    public Box(int w, int h, int d) {
        width = w;
        height = h;
        depth = d;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

    public int getWidth() {
        return width;
    }

    //check if the current box can be above the given box
    public boolean canBeAbove(Box b) {
        if (b == null) {
            return true;
        }
        return width < b.getWidth() && height < b.getHeight() && depth < b.getDepth();
    }

    //check if the current box can be below the given box
    public boolean canBeBelow(Box b) {
        if (b == null) {
            return true;
        }
        return width > b.getWidth() && height > b.getHeight() && depth > b.getDepth();
    }

}

public class BoxLongestSequence {

    /**
     * recursively find the layout with maximum height
     */
    public static List<Box> getMaxHeight(Box[] boxarr, Box bottom) {
        List<Box> listMaxBox = new ArrayList<Box>();
        int maxHeight = 0;
        for (int i = 0; i < boxarr.length; i++) {
            if (boxarr[i].canBeAbove(bottom)) {//if the current box can fit
                //recursively check if this box can hold other boxes on top
                List<Box> listCurBox = getMaxHeight(boxarr, boxarr[i]);
                int curHeight = getHeightOfStack(listCurBox);
                if (curHeight > maxHeight) {
                    maxHeight = curHeight;
                    listMaxBox = listCurBox;
                }
            }
        }
        
        //handle the case for the last box which might not have entered the loop
        if(bottom!=null){
            listMaxBox.add(bottom);
        }
        
        return listMaxBox;
    }

    public static int getHeightOfStack(List<Box> listBox) {
        int height = 0;
        for (Box b : listBox) {
            height += b.getHeight();
        }
        return height;
    }

    public static void main(String args[]) {
        //create and initialize Box objects
        Box[] boxarr = {new Box(3, 4, 1), new Box(8, 6, 2), new Box(7, 8, 3)};
        //call the recursive method
        List<Box> listBox = getMaxHeight(boxarr, null);
        //print the longest height obtained
        int height = 0;
        for (Box b : listBox) {
            height += b.getHeight();
        }
        System.out.println("longest height is:" + height);

    }

}
