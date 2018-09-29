/**
AnimalQueue:

An animal shelter holds only dogs and cats, and operates on a strictly "first in, first
out" basis. People must adopt either the "oldest" (based on arrival time) of all animals
at the shelter, or they can select whether they would prefer a dog or a cat (and will
receive the oldest animal of that type). They cannot select which specific animal they
would like. Create the data structures to maintain this system and implement operations
such as enqueue, dequeueAny, dequeueDog and dequeueCat. You may
use the built-in L inkedL ist data structure.
*/

/**
Method1: 
-Maintain a single queue and insert cat and dog with some timestamp record to indicate their arrival time.
-this would require scanning of all the items when we need to return specific animal
O(n) time for dequeuCat or dequeueDog, O(1) time for dequeueAny

Method2:
-we maintain separate queues for dog and cat
-we keep track of the arrival of animals using some timestamp or counter
-when we need to dequeuany, we check the timestamp between the top elements of the dog and cat queue and return the oldest one

O(1) time for dequeuCat or dequeuDog or deuqueAny
*/

import java.util.Queue;
import java.util.LinkedList;

class AnimalData{
	int time;
	String type;
	AnimalData(String type, int time){
		this.time = time;
		this.type = type;
	}
}
public class AnimalQueue{
	static Queue<AnimalData> dogQueue = new LinkedList<AnimalData>();
	static Queue<AnimalData> catQueue = new LinkedList<AnimalData>();
	
	//add cat item to cat queue
	public static void addCat(int time){
		System.out.println("adding cat at time:"+time);
		catQueue.add(new AnimalData("cat", time));
	}
	
	//add dog item to dog qeuee
	public static void addDog(int time){
		System.out.println("adding dog at time:"+time);
		dogQueue.add(new AnimalData("dog", time));
	}
	
	//remove the dog item from dog queue
	public static AnimalData removeDog(){
		System.out.println("removing dog of time:"+dogQueue.peek().time);
		return dogQueue.poll();
	}
	
	//remove cat item
	public static AnimalData removeCat(){
		System.out.println("removing cat of time:"+catQueue.peek().time);
		return catQueue.poll();
	}
	
	//remove the oldest betn dog and cat
	public static AnimalData removeAny() throws Exception{
		if(catQueue.isEmpty() && dogQueue.isEmpty()){
			throw new Exception("No animals left in the queue");
		}else if(catQueue.isEmpty()){
			return removeDog();
		}else if(dogQueue.isEmpty()){
			return removeCat();
		}else{
			if(dogQueue.peek().time<catQueue.peek().time){
				return removeDog();
			}else{
				return removeCat();
			}
		}
	}
	
	
	
	public static void main(String args[]) throws Exception{
		//add some items
		addDog(1);
		addCat(2);
		addDog(3);
		addDog(4);
		addDog(5);
		removeCat();
		//removeAny();
		removeAny();
		removeCat();
		removeAny();
		removeAny();
		removeAny();
		
	}
}