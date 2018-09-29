/**
#Busiest Time in The Mall

The mall management is trying to figure out what was the busiest moment in the mall in the last year. You are given data from the door detectors: each data entry includes a timestamp (seconds in Unix Epoch format), an amount of people and whether they entered or exited.

Example of a data entry: { time: 1440084737, count: 4, type: "enter" }

Find what was the busiest period in the mall on the last year. Return an array with two Epoch timestamps representing the beginning and end of that period. You may assume that the data your are given is accurate and that each second with entries or exits is recorded. Implement the most efficient solution possible and analyze its time and space complexity.

The return value is the timestamp, e.g. 1480640292. Note that if there is more than one period with the same visitor peak, return the earliest one.

Assume that the array data is sorted in an ascending order by the timestamp. Explain your solution and analyze its time and space complexities.

Example:

input:  data = [ [1487799425, 14, enter], 
                 [1487799425, 4,  exit],
                 [1487799425, 2,  exit],
                 [1487800378, 10, enter],
                 [1487801478, 18, exit],
                 [1487801478, 18, enter],
                 [1487901013, 1,  exit],
                 [1487901211, 7,  enter],
                 [1487901211, 7,  exit] ]

output: 1487800378 # since the increase in the number of people
                   # in the mall is the highest at that point
*/
import java.util.*;

class Entries{
	long time;
	int count;
	String type;
	Entries(){}
	Entries(long t, int c, String s){
		time = t;
		count = c;
		type = s;
	}
}
public class BusiestTimeinMall{

	/**
	Method1:
	-we can just accumulate the entering count and deducting the exiting count to keep track of current people within mall
	
	*/
	public static long findBusiestTime(Entries[] ens){
		if(ens==null || ens.length<1){
			return -1;
		}
		int maxPeople = -1;
		long maxTime = ens[0].time;
		int curPeople = 0;
		for(int i=0;i<ens.length; i++){
			Entries en = ens[i];
			if(en.type=="enter"){
				curPeople+= en.count;
			}else{
				curPeople-= en.count;
			}
			//it can be the case that for the same time, the next entry can reduce the number of people
			if(i==ens.length-1 || ens[i].time!=ens[i+1].time){//the next entry has different time as this entry
				if(curPeople>maxPeople){
					maxPeople=curPeople;
					maxTime = en.time;
				}	
			}
			
		}
		return maxTime;
	}
	
	public static void main(String args[]){
		Entries [] ens = new Entries[]{new Entries(1487799425, 14, "enter"), new Entries(1487799425, 4, "exit"), new Entries(1487799425, 2, "exit"), new Entries(1487800378, 10, "enter"), new Entries(1487801478, 18, "exit"), new Entries(1487801478, 18, "enter"), new Entries(1487901013, 1, "exit"), new Entries(1487901211, 7, "enter"),new Entries(1487901211, 7, "exit")};
		System.out.println("busiest time is:"+findBusiestTime(ens));
		
	}
}