/**
Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output "Fizz" instead of the number and for the multiples of five output "Buzz". For numbers which are multiples of both three and five output "FizzBuzz".

Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
*/

/**
Sol1:
-straight forward solution using if-else to check if the number in iteration 1...n is multiple of 3, 5, both or none
-store the string value to be returned in a List of string and return the list
*/
import java.util.List;
import java.util.ArrayList;

public class FizzBuzz{
	
	public static List<String> fizzBuzz(int n) {
        if(n<1){
			return new ArrayList<String>();
		}else{
			List<String> stringList = new ArrayList<String>();
			for(int i =1; i<=n; i++){
				if(i%5==0 && i%3==0){
					stringList.add("FizzBuzz");
				}else if(i%3==0){
					stringList.add("Fizz");
				}else if(i%5==0){
					stringList.add("Buzz");
				}else{
					stringList.add(String.valueOf(i));
				}
			}
			return stringList;
		}
    }
	
	public static void main(String args[]){
		int n = 15;
		List<String> fizzString = fizzBuzz(n);
		for(String s: fizzString){
			System.out.println(s);
		}
	}
}