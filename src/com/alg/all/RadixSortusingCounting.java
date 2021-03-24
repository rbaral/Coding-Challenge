/*
we implement the radix sort (sort the elements based on the LSD/MSD one at a time) using the concept of counting sort

Complexity: O(nk)
 */
package com.alg.practice.sort;

import java.util.Arrays;

/**
 *
 * @author rbaral
 */
public class RadixSortusingCounting {

    /**
     * unlike pure counting sort, we use the digit that we need to consider to do the counting sort
     * because at each radix/index/position we can have 0-9 values we always use the max range of 10
     * @param arr
     * @param digit
     * @return 
     */
    public static int[] sortItems(int[] arr) {
        //we need to call the counting sort for each and every radix/digit
        //the number of radix/digit is determined by the maximum number we have in our input array
        int maxNum = getMaxNum(arr);
        for(int exp=1;maxNum/exp>0;exp*=10){
            //do the sorting for this exp
            countingSort(arr, exp);
            //lets see the result after sorting by this radix
            System.out.println("sorted:"+Arrays.toString(arr));
        }
        return arr;
    }
    
    public static int[] countingSort(int[] arr, int exp){
        //create a count array to store the count of all radix and store
        int[] count = new int[10];//we only have 10 radix (0-9)
        //store the count of exp in the given array
        for(int i=0;i<arr.length; i++){
            count[(arr[i]/exp)%10]+=1;
        }
        //increase the count by storing the count items before it
        for(int i=1;i<count.length;i++){
            count[i]+=count[i-1];
        }
        //create the output array
        int[] output = new int[arr.length];
        //store the items based on the count
        for(int i=arr.length-1;i>=0;i--){
            output[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }
        //the output at this stage contains the numbers sorted using the current digit
        //System.out.println("temp:"+Arrays.toString(output));
        for (int i = 0; i < arr.length; i++)
            arr[i] = output[i];
        return arr;
    }
    
    public static int getMaxNum(int[] arr){
        int max = arr[0];
        for(int i=1;i<arr.length; i++){
            if(arr[i]>max)
                max=arr[i];
        }
        return max;
    }

    public static void main(String args[]) {
        int[] a = {1, 3, 9, 1, 5, 2, 12, 15, 4, 6};
        System.out.println("Unsorted: " + Arrays.toString(a));
        int maxRange = 15; // assume that the elements are in the range 0 to k
        int[] sorted = sortItems(a);
        System.out.println("Sorted: " + Arrays.toString(sorted));

    }
}
