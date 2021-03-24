/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;

/**
 *
 * @author rbaral
 */
public class Box {

    public int width;
    public int height;
    public int depth;

    public Box(int w, int h, int d) {
        width = w;
        height = h;
        depth = d;
    }

    public boolean canBeUnder(Box b) {
        if (width > b.width && height > b.height && depth > b.depth) {
            return true;
        }
        return false;
    }

    public boolean canBeAbove(Box b) {
        if (b == null) {
            return true;
        }
        if (width < b.width && height < b.height && depth < b.depth) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Box(" + width + "," + height + "," + depth + ")";
    }
}
