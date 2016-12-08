/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author rbaral
 * given two expressions, this will add them and return the result
 */

/**
 * A class representing a term of an expression
 * @author rbaral
 */
class Expression{
    double coeff;
    double exp;
}
public class ExpressionAddition {
    
    /**
     * adds the two expressions and returns the resulting expression
     * here we assume that the expressions are unsorted by the exp and hence
     * the solution is O(n^2)+O(n)
     * @param exp1
     * @param exp2
     * @return 
     */
    public static Expression[] sum(Expression[] exp1, Expression[] exp2){
        Expression [] expSum = null;
        List<Expression> sumList = new ArrayList<Expression>();
        boolean matchFound = false;
        for(int i=0; i<exp1.length; i++){//O(n)
            matchFound = false; //assume the entry of exp1 will not find match in exp2
            for(int j=0;j<exp2.length;j++){//O(n)
                //we compare with MAX_VALUE because we void the entry if a match was found in previous iterations
                if(exp2[j].coeff!=Double.MAX_VALUE && exp1[i].exp == exp2[j].exp){// a match
                    Expression exp = new Expression();
                    exp.coeff = exp1[i].coeff + exp2[j].coeff;
                    exp.exp = exp1[i].exp;
                    sumList.add(exp);
                    //make the exp2 void by changing its coeff to MAX_VALUE, we will use the non-zero exp2s later if they are left
                    exp2[j].coeff = Double.MAX_VALUE;
                    matchFound = true; // a match was encountered
                }
            }
            if(!matchFound){//if the entry of exp1 has not matching exp in exp2, then simply get the term into sumList
                sumList.add(exp1[i]); //this guarantees that every item fromm exp1 will be in the sumList
            }
            
        }
        //now if there are any non-zero coeffs in the exp2, then they have no match with exp1, we need to add them to sum
        //O(n)
        for(Expression exp:exp2){
            if(exp.coeff!=Double.MAX_VALUE){
                sumList.add(exp);
            }
        }
        //if we want to return the array instead, we need to convert the arrayList to array
        expSum = sumList.toArray(new Expression[sumList.size()]);
        return expSum;
    }
    
    
    public static void main(String args[]){
        System.out.println("main method started");
        //lets initialize exp1
        Expression[] exp1 = new Expression[3];
        for (int i=0;i<exp1.length; i++){
            exp1[i] = new Expression();
            exp1[i].coeff = i+2;
            exp1[i].exp = i+1;
        }
        
        Expression [] exp2 = new Expression[3];
        exp2[0] = new Expression();
        exp2[0].coeff = 5;
        exp2[0].exp = 5;
        
        exp2[1] = new Expression();
        exp2[1].coeff = 2;
        exp2[1].exp = 2;
        
        exp2[2] = new Expression();
        exp2[2].coeff = 9;
        exp2[2].exp = 0;
        
        
        System.out.println("Expression 1");
        for(Expression exp:exp1){
           System.out.println(exp.coeff+"x^"+exp.exp); 
        }
        
        System.out.println("Expression 2");
        for(Expression exp:exp2){
           System.out.println(exp.coeff+"x^"+exp.exp); 
        }
        
        Expression[] sumExp = sum(exp1, exp2);
        System.out.println("*****SUM*******");
        for(Expression exp:sumExp){
            System.out.println(exp.coeff+"x^"+exp.exp);
        }
    }
}
