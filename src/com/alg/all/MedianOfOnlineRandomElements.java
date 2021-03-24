/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * Numbers are randomly generated and stored into an (expanding) array. How
would you keep track of the median?
* 
* Solution 1:
* 1) Sort the array and find the median
* 2)every time we get a new element, user insertion sort to find its correct position, update the median
* 
* Complexity: O(n^2) for insertion sort
* 
* Solution 2:
* We use two heaps one min heap and one max heap
* keep on maintaining median as the elements arrive (e.g., when there is only one element, the median will be the element itself,
* when there are two elements, the median is the average of those two and so on..)
* 1)when a new element arrives, we find its position in one of those two heaps
* 2)If the two heaps are of same size
* 2 a) if the new element is less than the median so far, then insert the new element to the max heap (left portion of elements)
* update the new median as the root of the left heap
* 2 b) if the new element is greater than the median so far, then insert the new element to the min heap (right portion of elements)
*  update the median as the root of the right heap
* 3)If the left portion heap (max heap) has more elements
* 3 a) If the new element is less than or equal to the median, pop the element from left heap and insert into the right heap, insert the new element to the left heap
* 3 b) else, insert the element to the right heap
* 3 c) update new median as the avg of the root of the two heaps
* 4)If the right portion has more elements:
* 4 a) if the new element is larger than the median so far, pop from right heap and push into left heap, push the new element into right heap
* 4 b) else push the element into left heap
* 4 c) update new median as the avg of the root of the two heaps
* 
 * @author rbaral
 */
public class MedianOfOnlineRandomElements {
    
    class MaxComparator implements Comparator {
    
    @Override
    public int compare(Object x, Object y) {
        
        return (int)y - (int)x;
    }
    }
    public static int findMedian(int medianSoFar, int n, PriorityQueue lHeap, PriorityQueue rHeap){
        int diff = lHeap.size() - rHeap.size();
        //System.out.println("diff is:"+diff);
        if(lHeap.size()==rHeap.size()){ //both heaps of same size
            if(n<=medianSoFar){
                lHeap.offer(n);
                medianSoFar = (int)lHeap.peek();
            }else{
                rHeap.offer(n);
                medianSoFar = (int)rHeap.peek();
            }
        }else if(lHeap.size()>rHeap.size()){//left heap has more elements
            if(n<=medianSoFar){
                rHeap.offer(lHeap.poll());
                lHeap.offer(n);
            }else{
                rHeap.offer(n);
            }
            //find the new median
            medianSoFar = (((int)lHeap.peek() + (int)rHeap.peek())/2);
        }else{ //right heap has more elements
            if(n>medianSoFar){
                lHeap.offer(rHeap.poll());
                rHeap.offer(n);
            }else{
                lHeap.offer(n);
            }
            //find the new median
            medianSoFar = (((int)lHeap.peek() + (int)rHeap.peek())/2);
        }
        return medianSoFar;
    }
    
    public static void main(String args[]){
        int[] nums = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
        MaxComparator maxComparator = new MedianOfOnlineRandomElements().new MaxComparator();
        PriorityQueue lHeap = new PriorityQueue(nums.length/2,maxComparator);
        PriorityQueue rHeap = new PriorityQueue();
        int medianSoFar = 0;
        for(int i=0;i<nums.length;i++){
            medianSoFar = findMedian(medianSoFar, nums[i], lHeap, rHeap);
            System.out.println("Median till "+i+" th element of nums is:"+medianSoFar);
        }
        
    }
}
