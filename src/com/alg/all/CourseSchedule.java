/**
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
*/
import java.util.*;

public class CourseSchedule{

	/**
	https://leetcode.com/problems/course-schedule/discuss/58516/Easy-BFS-Topological-sort-Java
	*/
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		//a graph with all the nodes and their connectivity
        int[][] mat = new int[numCourses][numCourses];
		//to record the indegree of all the nodes
		int[] indegree = new int[numCourses];
		for(int i=0;i<prerequisites.length; i++){
			//the course
			int course = prerequisites[i][0];
			//the prereq
			int pre = prerequisites[i][1];
			if(mat[pre][course]==0){//avoid duplicate tuples
				indegree[course]++;
			}
			mat[pre][course] = 1;//set the link between the two courses
		}
		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		for(int i=0;i<indegree.length; i++){
			//add the courses without any prerequisites into a queue
			if(indegree[i]==0){
				queue.offer(i);
			}
		}
		while(!queue.isEmpty()){
			int course = queue.poll();
			count++;
			for(int i=0;i<numCourses; i++){
				if(mat[course][i]!=0){
					if(--indegree[i]==0){//this course can be taken now
						queue.offer(i);
					}
				}
			}
		}
		return count==numCourses;
		
    }
	
	public static void main(String args[]){
		
		int[][] prereq = new int[1][2];
		prereq[0] = new int[]{1, 0};
		int numcourses = 2;
		System.out.println(canFinish(numcourses, prereq));
		prereq = new int[2][2];
		prereq[0] = new int[]{1, 0};
		prereq[1] = new int[]{0, 1};
		numcourses = 2;
		System.out.println(canFinish(numcourses, prereq));
		//[[0,2],[1,2],[2,0]]
		prereq = new int[3][2];
		prereq[0] = new int[]{0,2};
		prereq[1] = new int[]{1,2};
		prereq[2] = new int[]{2,0};
		numcourses = 3;
		System.out.println(canFinish(numcourses, prereq));
		//[[1,0],[2,6],[1,7],[5,1],[6,4],[7,0],[0,5]]
		prereq = new int[7][2];
		prereq[0] = new int[]{1,0};
		prereq[1] = new int[]{2,6};
		prereq[2] = new int[]{1,7};
		prereq[3] = new int[]{5,1};
		prereq[4] = new int[]{6,4};
		prereq[5] = new int[]{7,0};
		prereq[6] = new int[]{0,5};
		numcourses = 8;
		System.out.println(canFinish(numcourses, prereq));
		//3
		//[[1,0],[2,0]]
		numcourses = 3;
		prereq = new int[2][2];
		prereq[0] = new int[]{1,0};
		prereq[1] = new int[]{2,0};
		System.out.println(canFinish(numcourses, prereq));
		
	}
}