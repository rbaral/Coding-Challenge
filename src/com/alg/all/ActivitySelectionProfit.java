/*
Given N jobs where every job is represented by following three elements of it.

Start Time
Finish Time
Profit or Value Associated
Find the maximum profit subset of jobs such that no two jobs in the subset overlap.

Example:

Input: Number of Jobs n = 4
       Job Details {Start Time, Finish Time, Profit}
       Job 1:  {1, 2, 50} 
       Job 2:  {3, 5, 20}
       Job 3:  {6, 19, 100}
       Job 4:  {2, 100, 200}
Output: The maximum profit is 250.
We can get the maximum profit by scheduling jobs 1 and 4.
Note that there is longer schedules possible Jobs 1, 2 and 3 
but the profit with this schedule is 20+50+100 which is less than 250. 

Solution:
-we use a recursive approach to solve this problem in O(n^2) when used DP
 */
package com.alg.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author rbaral
 */
public class ActivitySelectionProfit {

    // A job has start time, finish time and profit.
    static class Job {

        int start, finish, profit;
        public Job(int st, int fin, int prof){
            this.start = st;
            this.finish = fin;
            this.profit = prof;
        }
        public String toString(){
            return "start:"+start+" finish:"+finish+" prof:"+profit;
        }
    };
    public static void sortJobsByFinishtime(Job[] arr){
        Comparator<Job> jobComparator = new Comparator<Job>(){
            @Override
            public int compare(Job o1, Job o2) {
                if(o1.finish>o2.finish)
                    return 1;
                else
                    return -1;
            }
            
        };
        Arrays.sort(arr, jobComparator);
    }

    public static int findNonOverlap(Job[] arr, int i){
        //check if the ith job has any non-overlapping job
        for(int j=i-1;j>=0; j--){
            if(arr[j].finish<=arr[i].start){
                return j;
            }
        }
        return -1;
    }
    
    public static int findMaxProfit(Job[] arr, int length){
        //create an array to hold the profit of jobs
        int[] prof = new int[length];
        prof[0] = arr[0].profit;//the first job will be added by default
        for(int i=1; i<length; i++){
            //profit including the current item
            int curitemProf = arr[i].profit;
            //check if this activity is no overlapping with the one already added
            int nonoverlap = findNonOverlap(arr, i);
            if(nonoverlap!=-1){
                curitemProf+=prof[nonoverlap];
            }
            //max between the profit excluding the current item or including the current item
            prof[i] = Math.max(curitemProf, prof[i-1]);
        }
        System.out.println("profs:"+Arrays.toString(prof));
        return prof[length-1];
    }
    public static void main(String[] args) {
        Job arr[] = {new Job(3, 10, 20), new Job(1, 2, 50), new Job(6, 19, 100), new Job(2, 100, 200)};
        int n = arr.length;
        sortJobsByFinishtime(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("The optimal profit is " + findMaxProfit(arr, n));
    }
}
