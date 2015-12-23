package com.alg.leetup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Stack;
/**
 * TIMELIMITEXCEEDED
 * @author rbaral
 *
 */
public class LongestPalindrome {

	public static void main(String[] args) {
		System.out.println(new Date());
		String test ="civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		System.out.println("longst pal is:"+longestPalindrome(test));
		System.out.println(new Date());

	}
	 public static String longestPalindrome(String s) {
	        //we use the concept of a PDA
	        List<Integer> repeatIndices = new ArrayList<Integer>();
	        int repeatIndex=0;
	        boolean proceed=false;
	        if(s.isEmpty())
	            return "";
	        else if(s.length()==1)
	            return s;
	        else if(s.length()==2){
	            if(s.charAt(0)==s.charAt(1))
	                return s;
	            else
	                return s.substring(0,1);
	        }
	        else{
	        	String tempString="", pal=s.substring(0, 1), tempPal=pal;
	        	for(int i=0;i<s.length();i++){
		            //find the repititions of the ith char in string s
		            repeatIndices.clear();
		            proceed =false;
		            repeatIndex =i;
		            repeatIndices.add(i);
		            tempString = s.substring(repeatIndex+1);
		            //System.out.println("checkign for:"+i+" out of "+s.length()+" characters");
		            while(repeatIndex>=0 && tempString.length()>0){
		                repeatIndex = tempString.indexOf(s.charAt(i));
		                if(repeatIndex>=0){
		                	repeatIndices.add(repeatIndex+s.length()-tempString.length());
		                	//find the next interval
		                	tempString = s.substring(repeatIndex+s.length()-tempString.length()+1);
		                	
		                }else
		                	break;
		            }
		            //now for every pair of the repeated indices, check if the included string is a palindrome
		            if(repeatIndices.size()>1){
			            for(int k=0;k<repeatIndices.size();k++){
			                for(int j= k+1;j<repeatIndices.size();j++){
			                    if((j-k)> tempPal.length()){
			                        proceed = true;
			                        break;
			                    }
			                }
			            }
			            if(proceed){
			                tempPal = findPalStartingWith(repeatIndices,s,tempPal.length());
			                if(tempPal.length()>pal.length())
			                	pal=new String(tempPal.toCharArray());
			            }
		            }
		            
		        }
		        
		        return pal;
	        }
	        
	}

	    public static String findPalStartingWith(List<Integer> indices, String s, int minLength){
	        String pal="";
	        int mid=0,index=0;
	        boolean isPal = false;
	        String palString="";
	        //System.out.println("Proceeding with:"+s+" and indices:"+Arrays.toString(indices.toArray()));
	      for(int i=0;i<indices.size();i++){
	          for(int j=i+1;j<indices.size();j++){
	        	  if(indices.get(j)-indices.get(i)>minLength){
	        		  pal = s.substring(indices.get(i),indices.get(j)+1);
		              //System.out.println("checking if:"+pal);
		              mid = pal.length()/2;//we push this many strings to stack and check if the remaining has same pattern
		              Stack stack = new Stack();
		              index =0;
		              do{
		                  stack.push(pal.charAt(index));
		                  index++;
		              }while(index<mid);
		              //stack.addAll(pal.substring(0,mid+1).toCharArray());
		              //if the string was of odd length, ignore the middle char
		              if(mid*2<pal.length()){
		                 index++; 
		              }
		              isPal = true;
		              do{
		                  char c = (char)stack.pop();
		                  if(c!=pal.charAt(index)){//not a palindrome
		                      isPal = false;
		                      break;
		                  }
		                  index++;
		              }while(index<pal.length());
		              if(isPal && palString.length()<pal.length()){
		                 palString = new String(pal.toCharArray()); 
		              }  
	        	  }
	              
	          }
	          
	      } 
	      return palString;
	    }
	}
