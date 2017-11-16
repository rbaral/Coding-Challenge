/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

/**
 *You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:

Solution:
As the squares are connected vertically or horizontally, we can count the contribution of each square as:
1)If left, right, top, bottom neighbors are 1, its contribution is zero
2)If only left and right neighbors are 1, its contribution will be 2 (up and down)

So we can iterate through the matrix and check its neighbors' values and increment the count accordingly
* 
 * @author rbaral
 */
public class IslandPerimiter {
    
}
