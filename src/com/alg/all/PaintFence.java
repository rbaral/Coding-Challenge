/**
There is a fence with n posts, each post can be painted with one of the k colors. You have to paint all the posts such that no more than two adjacent fence posts have the same color. Return the total number of ways you can paint the fence.

Examples:

Input : n = 2 k = 4
Output : 16
We have 4 colors and 2 posts.
Ways when both posts have same color : 4 
Ways when both posts have diff color :
4*(choices for 1st post) * 3(choices for 
2nd post) = 12

Input : n = 3 k = 2
Output : 6

If c, c' and c'' are the three adjacent fences, then we have the following observations:
According to the constraint of the problem, c = c' = c" is not possible simultaneously, so either c' != c or c" != c or both. There are k – 1 possibilities for c' != c and k – 1 for c" != c.

 diff = no of ways when color of last
        two posts is different
 same = no of ways when color of last 
        two posts is same
 total ways = diff + sum

for n = 1
    diff = k, same = 0
    total = k

for n = 2
    diff = k * (k-1) //k choices for
           first post, k-1 for next
    same = k //k choices for common 
           color of two posts
    total = k +  k * (k-1)

for n = 3
    diff = [k +  k * (k-1)] * (k-1) 
           (k-1) choices for 3rd post 
           to not have color of 2nd 
           post.
    same = k * (k-1) 
           c'' != c, (k-1) choices for it

Hence we deduce that,
total[i] = same[i] + diff[i]
same[i]  = diff[i-1]
diff[i]  = (diff[i-1] + diff[i-2]) * (k-1)
         = total[i-1] * (k-1)
*/

public class PaintFence{

	public static int numWays(int n, int k) {
		int[] ways = new int[n+1];
		//k colors, 0 fences
		ways[0] = 0;
		//k colors, 1 fence
		//diff colors = 0, same color = k
		ways[1] = k;
		//k colors, 2 fences
		//diff colors = k*(k-1)
		//same color = k, total = diff + same
		ways[2] = k*k;
		//iteratively use the relation, ways[i] = ways
		for(int i=3;i<=n; i++){
			ways[i] = (ways[i-1] + ways[i-2])*(k-1);
		}
		return ways[n];
	}
	
	public static void main(String[] args){
		int n = 2;
		int k = 4;
		System.out.println(numWays(n, k));
		n = 3;
		k = 2;
		System.out.println(numWays(n, k));
	}

}