/**
Write methods to implement the multiply, subtract, and divide operations for integers.
Use only the add operator
*/   
public class SubtractMultiplyDivisionUsingAdd{

	//find the abs value of a
	public static int abs(int a){
		if(a>0){
			return a;
		}
		return neg(a);
	}
	
	/**
	iteratively increase a number till we get a value equal to a
	*/
	public static int neg(int a){
		int d = a>0?-1:1;
		int b = 0;
		while(a!=0){
			a+=d;
			b+=d;
		}
		return b;
	}
	
	public static int sub(int a, int b){
		//find a -b
		return a+neg(b);
	}
	
	/**
	-we use the concept of a/b=x, or a = xb
	-iteratively multiply b by itself until it becomes equal to a
	*/
	public static int div(int a, int b){
		//find a/b
		int prod = 0;
		int x = 0;
		int absa = abs(a);
		int absb = abs(b);
		while((prod+absb)<=absa){
			prod+=absb;
			x++;
		}
		if(a<0 && b<0 || a>0 && b>0){
			return x;
		}else{
			return neg(x);
		}
	}
	
	public static int mul(int a, int b){
		//find a*b
		//repeatedly add b to itself
		int absa = abs(a);
		int absb = abs(b);
		int prod = 0;
		//System.out.println(absa+".."+absb);
		while(absb>1){
			absa+=abs(a);
			absb--;
		}
		//System.out.println(absa+".."+absb);
		if(a<0 && b<0 || a>0 && b>0){
			return absa;
		}
		return neg(absa);
	}

	public static void main(String args[]){
		int a =5;
		int b = 10;
		System.out.println(sub(b, a));
		System.out.println(mul(b, a));
		System.out.println(div(b, a));
		b = 8;
		a = 3;
		System.out.println(sub(b, a));
		System.out.println(mul(b, a));
		System.out.println(div(b, a));
		
	}

}