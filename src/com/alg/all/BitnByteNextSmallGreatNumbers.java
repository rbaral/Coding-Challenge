/**
Given a positive integer, print the next smallest and the next largest number that
have the same number of 7 bits in their binary representation.
*/

public class BitnByteNextSmallGreatNumbers{
	
	/**
	get binary representation of a given number
	-O(logx), where x is the decimal number
	*/
	public static String getBinary(int num){
		StringBuffer sb = new StringBuffer();
		if(num==0){
			sb.append("0");
			return sb.toString();
		}else{
			while(num>0){
				int rem = num%2;
				num = num/2;
				sb.insert(0,rem);
			}
		return sb.toString();
		}
	}
	
	/**
	counts number of 1s in the given string
	*/
	public static int countOnesInBinaryString(String bin){
		//base case
		if(bin==null || bin.trim().length()<1){
			return 0;
		}
		int count = 0;
		for(int i=0;i<bin.length();i++){
			if(bin.charAt(i)=='1'){
				count++;
			}
		}
		return count;
	}

	/**
	-we increase the number by one, get the binary and check if there are same number of 1s
	-we repeat till we get the larger number with same 1s
	--cost: find binary representation of each number, find the number of 1s
	*/
	public static int getNextLarge1(int num){
		//base case
		//if number is 0,then there cannot be larger number with same number of 1s
		if(num==0)
			return num;
		int binCount1 = countOnesInBinaryString(getBinary(num));
		int binCount2 = 0;
		while(true){
			num++;
			binCount2 = countOnesInBinaryString(getBinary(num));
			if(binCount1==binCount2){
				return num;
			}
		}
	}
	
	/**
	-decrease the number by one and check if the binary has same number of 1s
	-repeat till we get the next smaller number with same number of 1s
	--cost: find binary representation of each number, find the number of 1s
	*/
	public static int getNextSmall1(int num){
		//handle base cases where there cannot be smaller with same number of 1s
		if(num==0){
			return 0;
		}
		int binCount1 = countOnesInBinaryString(getBinary(num));
		int binCount2 = 0;
		while(true){
			num--;
			binCount2 = countOnesInBinaryString(getBinary(num));
			if(binCount1==binCount2){
				return num;
			}
		}
	}
	
	/**
	-we do bit manipulation to get next larger number
	-get the binary representation of the given number
	-we need to flip zero-to-one and one-to-zero in appropriate position to get the next larger and next small number
	-the zero-to-one flip makes the number larger so we find the rightmost 0 bit that has some ones on its right
	-we flip the 0 bit to 1, this makes the number larger, but we want the next larger number than the given number
	-so, we need to flip one 1 bit on the right of the flipped 0 bit to make the number closer to the desired value
	-we flip all the 1 bits on the right of just flipped 0 bit and add one less 1s from the rightmost of the binary of given number
	*/
	public static int getNextLarge2(int num){
		/**
		handle base cases, e.g., we cannot get same number of 1s for next larger number for values like 0
		*/
		if(num==0)
			return -1;
		
		int c = num;
		int p = 0; //position of rightmost 0 that has some 1s on its right side
		int c0 = 0;//count of no. of 0s on right of p
		int c1 = 0;//count of no. of 1s on right of p
		
		//lets find c0, i.e. the number of 0s on the right side of p
		while(((c&1)==0) && (c!=0)){
			c0++;
			c = c>>1;
		}
		//find the number of 1s on the rightmost non-trailing end
		while((c&1)==1){
			c1++;
			c = c>>1;
		}
		p = c0+c1;
		
		
		//from p onwards clear all 1s
		int mask1 = 1<<p; //all 0s except 1 at position p
		//flip the rightmost non-trailing 0
		num=num|mask1;
		mask1 = mask1 - 1; //all 0s followed by p 1s
		mask1 = ~mask1; //all 1s followed by p 0s
		num = num&mask1;
		//now insert c1-1 1s
		int mask2 = 1<<(c1-1); //all 0s except 1 at position c1-1
		mask2 = mask2 -1;//all 1s from position 0 to c1-1 and rest is 0s
		num = num|mask2;
		return num;
	}
	
	/**
	-we use bit manipulation to get the next smaller number for the given number
	-find the number of trailing 1s and set it to c1
	-find the number of 0s on left of the trailing 1s and set it to c0
	-flip the rightmost non-trailing 1 to 0 at postion p = c1+c0
	-clear all bits on the right of p
	-insert c1+1 bits immediately right on p as 1s
	
	*/
	public static int getNextSmall2(int num){
		//handle base case where the same number of 1s cannot give smaller  number
		if(num==0){
			return -1;
		}
		int c = num;
		int c1 = 0;
		int c0 = 0;
		int p = 0;
		
		//now find the number of trailing ones
		while((c&1)==1){
			c1++;
			c = c>>1;
		}
		//now find the number of 0s immediately on left of the trailing 1s
		while((c&1)==0 && c!=0){
			c0++;
			c = c>>1;
		}
		p = c0 + c1;
		//flip the 1 at position p to 0
		int mask1 = (~0<<(p+1)); //1 at postion p and rest is 0
		num = num&mask1;//clear all bits from position p onwards
		//now insert c1+1 ones immediately right of position p
		int mask2 = (1<<(c1+1))-1;
		num=num|(mask2<<(c0-1));
		return num;
	}
	
	public static void main(String args[]){
		int num = 10;
		//int large1 = getNextLarge1(num);
		//int small1 = getNextSmall1(num);
		System.out.println("Binary of :"+num+" is:"+getBinary(num)+" and 1s count "+countOnesInBinaryString(getBinary(num)));
		System.out.println("Next large1 of:"+num+" is "+getNextLarge1(num)); 
		System.out.println("Next small1 of:"+num+" is "+getNextSmall1(num)); 
		System.out.println("Next large2 of:"+num+" is "+getNextLarge2(num)); 
		System.out.println("Next small2 of:"+num+" is "+getNextSmall2(num)); 
		System.out.println(~0);
	}
}