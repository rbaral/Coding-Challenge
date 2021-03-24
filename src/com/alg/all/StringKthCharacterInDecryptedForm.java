/**
Find k’th character of decrypted string
Given an encoded string where repetitions of substrings are represented as substring followed by count of substrings. For example, if encrypted string is "ab2cd2" and k=4 , so output will be ‘b’ because decrypted string is "ababcdcd" and 4th character is ‘b’.

Note: Frequency of encrypted substring can be of more than one digit. For example, in "ab12c3", ab is repeated 12 times. No leading 0 is present in frequency of substring.

Examples:

Input: "a2b2c3", k = 5
Output: c
Decrypted string is "aabbccc"

Input : "ab4c2ed3", k = 9
Output : c
Decrypted string is "ababababccededed"

Input: "ab4c12ed3", k = 21
Output: e
Decrypted string is "ababababccccccccccccededed"
*/

public class StringKthCharacterInDecryptedForm{
	/**
	we use a recursive approach, until the portion without a digit is of length k
	*/
	public static String findDecrypted(String s, int k){
		//base case
		if(s==null || k<0 || s.length()<1){
			return "";
		}
		if(k==0){
			return s.substring(0,1);
		}
		//use a recursive call on the string that uses the substring from begining to the point where there is a digit, makes a copy of that portion that many times and append it to the new string
		StringBuilder sb = new StringBuilder();
		decryptHelper(s, k, 0, sb);
		return sb.toString();
	}
	
	public static void decryptHelper(String s, int k, int start, StringBuilder sb){
		//if(sb.toString().length()>=k){
		//	return;
		//}
		int charval;
		int countstart = 0;
		int size = s.length();
		int last = 0;
		StringBuilder digit;
		for(int i=start; i<size; i++){
			charval = s.charAt(i) -'0';
			System.out.println(charval);
			digit = new StringBuilder();
			while(charval>=0 && charval<=9 && i<size){
				digit.append(s.charAt(i) -'0');
				i++;
				if(i<size)
					charval = s.charAt(i) -'0';
			}
			//now if we have  some positive counts for digits, copy the immediate left portion that many times
			if(digit.toString().length()>0 && Integer.parseInt(digit.toString())>0){
				int num = Integer.parseInt(digit.toString());
				String sub = s.substring(last, i-digit.toString().length());
				while(num>0){
					sb.append(sub);
					num--;
				}
				last = i;
				//System.out.println("digit is:"+digit+" sb so far is:"+sb.toString());
			}
		}
	}
	
	public static void main(String[] args){
		String s = "a2b2c3";
		int k = 5;
		String res = findDecrypted(s, k);
		System.out.println("decrypted string is:"+res+" kth char is:"+res.charAt(k-1));
		s = "ab4c2ed3";
		k = 9;
		res = findDecrypted(s, k);
		System.out.println("decrypted string is:"+res+" kth char is:"+res.charAt(k-1));
		s = "ab4c12ed3";
		k = 21;
		res = findDecrypted(s, k);
		System.out.println("decrypted string is:"+res+" kth char is:"+res.charAt(k-1));
		
	}
}