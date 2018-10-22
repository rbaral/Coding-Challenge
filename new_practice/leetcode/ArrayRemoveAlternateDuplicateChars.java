/**
Remove Alternate Duplicate characters from a char array you have to do it in Place.Like keeping only the odd occurences of each character.
Example: Input: "you got beautiful eyes"
Output: "you gtbeaiful es"
Allowed Time Complexity was O(n) and Space Complexity was O(1)
*/

public class ArrayRemoveAlternateDuplicateChars{

	public static String removeAlternateDuplicate(String s){
		char[] chars = s.toCharArray();
		int[] arr = new int[256];
		int i=0;
		while(i<chars.length){
			arr[chars[i]]++;
			//for every second repetition
			if(arr[chars[i]]>0 && arr[chars[i]]%2==0){
				squeezeArray(chars, i);
			}else{
				i++;
			}
		}
		return String.valueOf(chars);
	}

	/**
	-remove the duplicate by shifting all the elements after this element
	-at the end of the char array, add space to maintin the array size
	*/
	public static void squeezeArray(char[] c, int index){
		for(int i = index; i<c.length-1; i++){
			c[i] = c[i+1];
		}
		c[c.length-1]='\t';
	}
	
	public static void main(String[] args){
		String s = "you got beautiful eyes";
		System.out.println("after removal:"+removeAlternateDuplicate(s));
	}

}