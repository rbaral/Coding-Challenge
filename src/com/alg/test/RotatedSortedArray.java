/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

public class RotatedSortedArray {

    public static int findResetPoint(int[] arr) {
        int first = 0;
        int last = arr.length - 1;
        int mid = (first + last) / 2;

        int resetPoint = -1;
        if (arr[first] >= arr[mid]) {
            while (arr[first] >= arr[mid] && first < mid) {
                //System.out.println("reducing first arr[mid] is:" + arr[mid] + " arr[first] is:" + arr[first]);
                first++;
            }
            resetPoint = first;
        }

        if (arr[mid] >= arr[last]) {
            while (arr[mid] >= arr[last] && mid < last) {
                //System.out.println("reducing mid arr[mid] is:" + arr[mid] + "  arr[last] is:" + arr[last]);
                mid++;
            }
            resetPoint = mid;
        }

        return resetPoint;
    }

    public static void main(String args[]) {
        int[] a = {1, 2, 2, 3, 4, 5, 6};
        int resetPoint = findResetPoint(a);
        System.out.println("resetPoint is:" + resetPoint);
        
        a = new int[]{6, 1, 2, 3, 4, 5};
        resetPoint = findResetPoint(a);
        System.out.println("resetPoint is:" + resetPoint);
        
        a = new int[]{4, 5, 6, 1, 2, 3};
        resetPoint = findResetPoint(a);
        System.out.println("resetPoint is:" + resetPoint);
        
        a = new int[]{2, 2, 2, 3, 4, 2};
        resetPoint = findResetPoint(a);
        System.out.println("resetPoint is:" + resetPoint);
        
        //the first->resetpoint-1 is sorted, and the resetpoint->last is also sorted
        //do the binary search on the first half or second half
        int val = 5;
        int valIndex = -1;
        if(resetPoint>=0){
            if(val <a[resetPoint-1] && val>=a[0]){//left half
            /*
            int start = 0;
            while(val>=a[start]){
                if(val==a[start]){
                    valIndex = start;
                    break;
                }
                start++;
            }*/
            valIndex = findValue(a, 0, resetPoint-1, val);
        }else if(val>=a[resetPoint] && val<=a[a.length-1]){//right half
            /*
            int start = resetPoint;
            while(val>=a[start]){
                if(val==a[start]){
                    valIndex = start;
                    break;
                }
                start++;
            }*/
            valIndex = findValue(a, resetPoint, a.length-1, val);
        }else{
            System.out.println("searching both halves");
        }
        }else{
            //search on the whole array
            System.out.println("searching on the whole array");
            valIndex = findValue(a, 0, a.length, val);
        }
        
        System.out.println("the valindex is:"+valIndex);
    }
    
    public static int findValue(int[] arr, int start, int end, int val){
        int mid = (start+end)/2;
        if(end<start)
            return -1;
        if(val == arr[mid]){
            return mid;
        }else if(val<=arr[mid]){
            //search left half
            return findValue(arr, start, mid, val);
        }else{
            //search right half
            return findValue(arr, mid+1, end, val);
        }
    }

}
