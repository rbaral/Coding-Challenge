/**
In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
different sizes which can slide onto any tower. The puzzle starts with disks sorted
in ascending order of size from top to bottom (i.e., each disk sits on top of an even
larger one). You have the following constraints:
(1) Only one disk can be moved at a time.
(2) A disk is slid off the top of one tower onto the next rod.
(3) A disk can only be placed on top of a larger disk.
Write a program to move the disks from the first tower to the last using Stacks.
*/
import java.util.Stack;

class Tower{
	
	int towerIndex;
	Stack<Integer> disks;
	Tower(int val){
		towerIndex = val;
		disks = new Stack<Integer>();
	}
	
	//method to add element to the top of this disk
	public void moveTopTo(Tower t) throws Exception{
		//if the val is smaller than the top item of this tower, or if this tower is empty then its a valid move
		if(t.disks.isEmpty() || this.disks.peek()<t.disks.peek()){
			System.out.println("moving "+this.disks.peek()+" from tower:"+this.towerIndex+" to tower:"+t.towerIndex+" with top value:"+(t.disks.isEmpty()?"NONE":t.disks.peek()));
			t.add(this.disks.pop());
		}else{
			throw new Exception("invalid move "+this.disks.peek()+" from tower:"+this.towerIndex+" to tower:"+t.towerIndex+" with top value:"+(t.disks.isEmpty()?"NONE":t.disks.peek()));
		}
	}
	
	//method to add element to the top of this disk
	public void add(int val) throws Exception{
		if(this.disks.isEmpty() || this.disks.peek()>val){
			this.disks.push(val);
		}else{
			throw new Exception("invalid push of item:"+val+" to tower:"+this.towerIndex+" with top value:"+this.disks.peek());
		}
	}
	
	//move multiple disks using one of the tower as a buffer
	public void moveDisksUsingBuff(int n, Tower buff, Tower dest)throws Exception{
		if(n>0){
			//move the n-1 disks to buff disk as destination, using dest as buffer/intermediate
			moveDisksUsingBuff(n-1, dest, buff);
			//then move the last disk from this tower to the dest tower
			moveTopTo(dest);
			//now move the disks from buffer to dest using this Tower as buffer/intermediate
			buff.moveDisksUsingBuff(n-1, this, dest);
		}
	}
}

public class StackTowerofHanoi{
	public static void main(String args[]) throws Exception{
		//lets create three towers
		Tower t1 = new Tower(1);
		Tower t2 = new Tower(2);
		Tower t3 = new Tower(3);
		//push 3 disks to Tower1
		t1.add(5);
		t1.add(4);
		t1.add(3);
		t1.add(2);
		t1.add(1);
		//nowe move the disks to the Tower3 using our solution
		t1.moveDisksUsingBuff(5, t2, t3);
		
	}
}