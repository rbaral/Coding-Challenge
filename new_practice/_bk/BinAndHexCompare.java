/**
this class checks if the two binary and hex numbers given in string are equal in value
*/

public class BinAndHexCompare{

	public static void main(String args[]){
		String n1 = "1110"; //14
		String n2 = "E"; //14
		n2 = "F" ;//15
		int bin = convertToBase(n1, 2);
		int hex = convertToBase(n2, 16);
		if(bin <0 || hex<0){
			System.out.println("Not equal");		
		}else{
			System.out.println("Equality is:"+(bin==hex));
		}
	}

	public static int convertCharToDigit(char c){
		if(c >='0' && c <= '9'){
			return c - '0';
		}
		else if(c >= 'A' && c <= 'F'){
			return c - 'A' + 10;
		}
		else if(c >= 'A' && c <= 'f'){
			return c - 'a' + 10;
		}
		return -1;

	}
	public static int convertToBase(String num, int base){
		if(base<2 || base>16){
			return -1;		
		}
		int value = 0;
		for(int i=num.length()-1; i>=0; i--){
			int digit = convertCharToDigit(num.charAt(i));
			if(digit<0 || digit>base){
				return -1;			
			}else{
				int exp = num.length() - 1-i;
				value+=digit*Math.pow(base,exp);
			}
		}
		return value;
	}

}
