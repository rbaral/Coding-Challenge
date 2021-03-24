/**
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
*/
import java.util.*;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class MergeIntervals{

	/**
	Method1: Brute force solution
	-use nested loops and check if two loops can be merged, if so, create a new list by having min of start and max of end
	-if merge took place, add the merged list to result list and retain the merged interval to procced with remaining items in the second loop
	-we might need to create a map of intervals that are merged so that we don't use them to create other merged lists
	O(n^2)
	*/
	public List<Interval> merge1(List<Interval> intervals) {
        return null;
    }
	
	/**
	Method2: by sorting the starting and ending values of the intervals
	REf: https://leetcode.com/problems/merge-intervals/discuss/21223/Beat-98-Java.-Sort-start-and-end-respectively.
	-sort the starting points and ending points and assign them into different array
	-iterate through the list of intervals and check if it fits within the startin and ending value of the sorted array
	-if it fits, add into the result list
	*/
	public static List<Interval> merge2(List<Interval> intervals) {
        //handle base cases
		if(intervals==null || intervals.size()<2){
			return intervals;
		}
		int[] starts = new int[intervals.size()];
		int[] ends = new int[intervals.size()];
		for(int i=0;i<intervals.size();i++){
			starts[i] = intervals.get(i).start;
			ends[i] = intervals.get(i).end;
		}
		//sort the start and end values
		Arrays.sort(starts);
		Arrays.sort(ends);
		//now iterate through the intervals and check if they fit within the start and end values of the sorted start, end arrays
		List<Interval> res = new ArrayList<Interval>();
		for(int i=1; i<=intervals.size(); i++){
			if(i!=intervals.size() && starts[i]<=ends[i-1]){
				//the intervals are overlapping, update the start of interval i and wait for the next interval that will be overlapping with this one
				starts[i] = starts[i-1];
			}else{
				res.add(new Interval(starts[i-1], ends[i-1]));//this interval is disjoint to start[i] so add it as an individual interval
			}
		}
		return res;
    }
	public static void main(String args[]){
		Interval i1 = new Interval(1, 3);
		Interval i2 = new Interval(2, 6);
		Interval i3 = new Interval(8,10);
		Interval i4 = new Interval(15, 18);
		List<Interval> intList = new ArrayList<Interval>();
		intList.add(i1);
		intList.add(i2);
		intList.add(i3);
		intList.add(i4);
		List<Interval> merged = merge2(intList);
		for(Interval interval: merged){
			System.out.println(interval.start+"..."+interval.end);
		}
	}
}