/**
Given an integer n and a number k, find the kth root of the number n.

Example1:
n=9
k=2
output:3

Example2:
n=27
k = 3

output:3
*/
import java.util.*;


public class RootN{

	/**
	Method1:
	-use the concept of binary search
	-low = 1, high = n, mid = low +(high - low)/2
	-if (mid*mid > n) proceed with high = mid
	-if (mid*mid < n && (mid+1)*(mid+1)>n) save mid as answer and proceed with low = mid
	*/
	public static int findRootN(int n, int k){
		int low = 1, high = n/k;
		int mid = low +(high-low)/2;
		int ans = mid;
		while(low<=high){
			mid = low +(high-low)/2;
			int res = (int)Math.pow(mid, k);
			if(res==n){
				return (int) mid;
			}else if(res>n){
				high =mid-1;
			}else{
				if((int)Math.pow(mid+1, k)>n){
					ans = mid;
				}
				low = mid+1;
			}
		}
		return ans;
	}
	
	public static void main(String args[]){
		int n = 27;
		int k =3;
		//n = 9;
		//k = 2;
		//n = 125;
		//k = 3;
		n =2;
		k=2;
		System.out.println(k+" th root of:"+n+" is:"+findRootN(n, k));
		
	}
}