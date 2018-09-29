/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.locked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author rbara012
 * 
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] 
 * find the minimum number of conference rooms required.
 * 
 * Solution:
 * 1)Sort the intervals based on the starting time
 * 2)Initialize the list of rooms with a single room and schedule the first interval to that room
 * 3) Scan the rest of the intervals
  3 a) if the current interval has end time greater than the last meeting in either of the rooms, add this interval to this meeting room
  3 b) if no room has non-overlapping interval, create a new room and add the interval to this room
  * 
  * Complexity: O(nk) where n is the no. of intervals and k is the no. of meeting rooms required
 * 
 */
public class MeetingRoomsII {
    
    class Interval{
        int start, end;
        public Interval(int s, int e){
            start = s;
            end = e;
        }
    }
    public static int minMeetingRooms(Interval[] intervals){
        //sort the intervals
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval in1, Interval in2) {
                return in1.start - in2.start;
            }
        });
        List<Interval> rooms = new ArrayList<Interval>();
        //add the first meeting to the first room
        rooms.add(intervals[0]);
        for(int i = 1; i< intervals.length;i++){
            //check if it is non-overlappign with either of the room events
            for(int j=0;j<rooms.size();j++){
                Interval roomEvent = rooms.get(j);
                System.out.println("checking interval:"+intervals[i].start+","+intervals[i].end+" to room:"+roomEvent.start+","+roomEvent.end+"..total rooms:"+rooms.size()+"...j is:"+j+" i is:"+i);
                if(roomEvent.end<intervals[i].start){
                    //found one
                    //add this as the last event in that room
                    rooms.set(j, intervals[i]);
                    break;
                }else if(j==(rooms.size()-1)){//we reached the end without finding any suitable room, so create a new room
                    rooms.add(intervals[i]);
                    break; //so that the loop doesn't keep on executing due to increase in the size of the room
                }
            }
        }
        return rooms.size();
    }
    
    
    public static void main(String args[]){
        MeetingRoomsII.Interval[] intervals = new MeetingRoomsII.Interval[3];
        intervals[0] = new MeetingRoomsII(). new Interval(0, 30);
        intervals[1] = new MeetingRoomsII(). new Interval(35, 40);
        intervals[2] = new MeetingRoomsII(). new Interval(45, 50);
        System.out.println("rooms required? "+minMeetingRooms(intervals));
        intervals[0] = new MeetingRoomsII(). new Interval(0, 30);
        intervals[1] = new MeetingRoomsII(). new Interval(5, 10);
        intervals[2] = new MeetingRoomsII(). new Interval(15, 20);
        System.out.println("rooms required? "+minMeetingRooms(intervals));
    }
}
