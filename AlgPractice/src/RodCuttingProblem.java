public class RodCuttingProblem {
	public static double negativeInfinity=-1.0;
	
	public static void main (String args[]){
		double price[]= new double[11];
		price[0]=0;
		price[1]=1;
		price[2]=5;
		price[3]=8;
		price[4]=9;
		price[5]=10;
		price[6]=17;
		price[7]=17;
		price[8]=20;
		price[9]=24;
		price[10]=30;
		performTopDown(price, 5);
		performBottomUp(price, 4);
		performExtendedBottomUp(price, 9);
	}
	
	/**
	 * represents the Memoized rod cut in CLRS
	 */
	public static void performTopDown(double[] priceArray, int rodSize){
		double price = MemoizedCutRod(priceArray, rodSize);
		System.out.println("TOP DOWN RESULT, MAX PRICE FOR SIZE:"+rodSize+"... can be:"+price);
	}
	
	public static double MemoizedCutRod(double[] priceArray, int rodSize){
		double price=0.0;
		//initialize the temp array
		double r[] = new double[rodSize+1];
		for (int i =0; i<r.length; i++){
			r[i]=negativeInfinity;// treating -100 as equivalent to - infinity
			
		}
		return MemoizedCutRodAux(priceArray, rodSize, r);
	}
	
	public static double MemoizedCutRodAux(double[] priceArray, int rodSize, double[] tempArray){
		double price=0.0;
		double tempMax=0.0;
		if(tempArray[rodSize]>=0)
			return tempArray[rodSize];
		if(rodSize==0)
			price=0.0;//the price of 0 length rod is assumed to be zero
		else{
			price = negativeInfinity;
			for (int i=1; i<=rodSize;i++){
				tempMax=priceArray[i] + MemoizedCutRodAux(priceArray, rodSize- i, tempArray);
				//System.out.println("comparing:"+price+" and:"+tempMax);
				price = Math.max(price, tempMax);
			}
		}
		tempArray[rodSize]= price;
		return price;
	}
	
	public static double performBottomUp(double[] priceArray, int rodSize){
		//initialize temp array
		double tempArray[]= new double[rodSize+1];
		tempArray[0]=0.0;
		double price=0.0;
		for (int j=1; j<=rodSize;j++){
			price = negativeInfinity;
			for (int i=1; i<= j;i++){
				price = Math.max(price, priceArray[i]+tempArray[j-i]);
			}
			tempArray[j]=price;
		}
		System.out.println("BOTTOM UP RESULT, MAX PRICE FOR SIZE:"+rodSize+".. can be:"+price);
		return price;
	}
	
	public static double performExtendedBottomUp(double[] priceArray, int rodSize){
		//initialize temp array
		double tempArray[]= new double[rodSize+1];
		tempArray[0]=0.0;
		int tempSizeArray[] = new int[rodSize+1];
		double price=0.0;
		for (int j=1; j<=rodSize;j++){
			price = negativeInfinity;
			for (int i=1; i<= j;i++){
				//price = Math.max(price, priceArray[i]+tempArray[j-i]);
				if( price <priceArray[i]+tempArray[j-i]){
					price = priceArray[i]+tempArray[j-i];
					tempSizeArray[j]=i;
				}
			}
			tempArray[j]=price;
		}
		System.out.println("Extended BOTTOM UP RESULT, MAX PRICE FOR SIZE:"+rodSize+".. can be:"+price);
		int n= rodSize;
		while(n>0){
			System.out.println(tempSizeArray[n]);
			n= n- tempSizeArray[n];
		}
		return price;
	}

}
