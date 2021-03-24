/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

/**
 * class that implements a method to find a string in a sorted array of strings
 * that have interspersed spaces
 */
public class SortedStringWithSpace {

    public static int findString(String[] arr, int start, int end, String s) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (end < start) {
            System.out.println("rrrsss returning -1");
            return -1;
        }
        int mid = (start + end)/2;
        System.out.println("comparing "+s+"... and.."+arr[mid]+"..equals:"+s.equals(arr[mid]));
        if (s.equals(arr[mid])) {
            return mid;
        } else if (arr[mid].isEmpty()) {//check if the mid is a space
            //advance the mid by -1 or +1 repeatedly till we get a non-empty string
            //define the end of left half and start of right half
            int leftEnd = mid - 1;
            int rightStart = mid + 1;

            while (true) {
                if (leftEnd < start && rightStart > end) {
                    System.out.println("returning -1");
                    return -1;
                }
                System.out.println("comparing "+s+"..with "+arr[leftEnd]+"..start is:"+start+" leftend is:"+leftEnd);
                if(!arr[leftEnd].isEmpty() && arr[leftEnd].compareTo(s)>=0){
                    return findString(arr, start, leftEnd, s);
                }else if(!arr[rightStart].isEmpty() && arr[rightStart].compareTo(s)<=0){
                    return findString(arr, rightStart, end, s);
                }
                leftEnd--;
                rightStart++;
            }
        }else if(s.compareTo(arr[mid])>0){//right half
            return findString(arr, mid+1, end, s);
        }else if(arr[mid].compareTo(s)>0){//left half
            return findString(arr, start, mid-1, s);
        }
        System.out.println("returning default -1");
        return -1;
    }

    public static void main(String args[]) {

        String s[] = {"", "ab", "", "abc", "", "", "abcd", "abd", "", "baba"};
        String temp = "abc";
        System.out.println("Index of: " + temp + " in the array is:" + findString(s, 0, s.length-1, temp));
    }
}
