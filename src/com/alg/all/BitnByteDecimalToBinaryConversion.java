/**
Given a real number between 0 and 7 (e.g., 0.72) that is passed in as a double, print
the binary representation. If the number cannot be represented accurately in binary
with at most 32 characters, print "ERROR."
*/

/**
Soln:
-the binary fraction contains numbers that can be multiplied by 2^(-i) to get the equivalent decimal representation
-to
*/
public class BitnByteDecimalToBinaryConversion{

	public static String printBinaryofFraction(double frac){
		if(frac<=0 || frac>1){
			return "ERROR";
		}
		StringBuffer sb = new StringBuffer();
		sb.append(".");
		while(frac>0){
			double num = frac*2;
			if(num>=1){
				sb.append("1");
				frac = num - 1;
			}else{
				sb.append("0");
				frac = num;
			}
			if(sb.length()>=32){
				return "ERROR";
			}
		}
		return sb.toString();
	}
	public static void main(String args[]){
		double frac = 0.5;
		String bin = printBinaryofFraction(frac);
		System.out.println("binary of:"+frac+" is:"+bin);
	}
}