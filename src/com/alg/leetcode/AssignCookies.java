/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

/**
 *
 * Assume you are an awesome parent and want to give your children some cookies. 
 But, you should give each child at most one cookie. Each child i has a greed factor gi, which is the minimum size of a 
 cookie that the child will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to 
 the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the 
 maximum number.

Note:
You may assume the greed factor is always positive. 
You cannot assign more than one cookie to one child.

Example 1:
Input: [1,2,3], [1,1]

Output: 1

Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to output 1.


Example 2:
Input: [1,2], [1,2,3]

Output: 2

Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
You have 3 cookies and their sizes are big enough to gratify all of the children, 
You need to output 2.
 * 
 
 The brute force solution will be to sort both arrays and assign the cookies with min value that satisfies the greed of a child.
 The maximum number in the child array that was satisfied will be the answer.
 * 
 * @author rbaral
 */
 
 import java.util.Arrays;
 
public class AssignCookies {
    
	static int findContentChildren(int[] g, int [] s){
            //handle base cases
            if(g==null || s==null|| g.length<1 || s.length<1)
                return 0;
            Arrays.sort(g);
            Arrays.sort(s);
            int j = 0;
            int i = 0;
            int maxSatisfied = 0;
            while(i< g.length && j<s.length){
                if(g[i]<=s[j]){
                    maxSatisfied+= 1;
                    i++;
                    j++;
                }else if(s[j]<g[i]){// advance the satisfaction index
                    j++;
                }
            }
            return maxSatisfied;
	}
	
	public static void main(String args[]){
            int [] g = {1,2,3}; //[1,2,3], [1,1]
            int [] s = {1,1};

            System.out.println(findContentChildren(g, s));
            //[1,2], [1,2,3]
            g = new int[] {1,2};
            s = new int[] {1,2,3};
            System.out.println(findContentChildren(g, s));
            //[10,9,8,7]
            //[5,6,7,8]
            g = new int[]{10,9,8,7};
            s = new int[]{5,6,7,8};
            System.out.println(findContentChildren(g, s));
	}
	
	
}
