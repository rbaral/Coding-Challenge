/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.locked;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author rbara012
 * 
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * determine if a person could attend all meetings. For example, Given [[0, 30],[5, 10],[15, 20]], return false.
 * 
 * If we are just looking for the chances of attending all the meetings,
 * we can just scan the intervals and check if this can be adjusted with
 * the one already considered for attending. If it conflicts, return false.
 * 1)If more than one meetings have same starting or same ending time, return false
 * 2)Sort the intervals based on the startig time
 * 3)Scan through the intervals array and check if the two consecutive intervals have overlapping interval, if so return false
 * 
 * Complexity: O(nlogn) for sorting and O(n) for scanning the intervals array
 * 
 * 
 * 
 */
public class MeetingRooms {
    
    class Interval{
        int start, end;
        public Interval(int s, int e){
            start = s;
            end = e;
        }
    }
    
    public static boolean canAttendMeetings(Interval[] intervals){
        //sort the intervals by the starting time
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval in1, Interval in2){
                return in1.start - in2.start; //sort by the starting time
            }
        });
        //now in the sorted array check if there is an overlap between the consecutive intervals
        for(int i=0; i<intervals.length-1; i++){
            if(intervals[i].end> intervals[i+1].start){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String args[]){
        MeetingRooms.Interval[] intervals = new MeetingRooms.Interval[3];
        intervals[0] = new MeetingRooms(). new Interval(0, 30);
        intervals[1] = new MeetingRooms(). new Interval(35, 40);
        intervals[2] = new MeetingRooms(). new Interval(45, 50);
        System.out.println("can attend? "+canAttendMeetings(intervals));
    }
}
