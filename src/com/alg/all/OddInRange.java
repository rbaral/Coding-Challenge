/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.realtest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author rbaral
 */
public class OddInRange {

      public static String formatPhone1(String phone){
        StringBuffer newPhone = new StringBuffer("P:");
        phone = phone.replace(") "," ");
        phone = phone.replace(")"," ");
        phone = phone.replace("("," ");
        phone = phone.trim();
        System.out.println(phone);
        char [] chars = phone.toCharArray();
        for(int i=0;i<chars.length-5; i++){//skip the last four numbers
            if(chars[i]=='+'){
                newPhone.append(chars[i]);
            }
            else if(chars[i]=='(' || chars[i]==')'){
                continue;
            }
            else if(chars[i]==' '){
                newPhone.append("-");
            }else{
                newPhone.append("*");
            }
        }
        newPhone.append("-");
        newPhone.append(phone.substring(phone.length()-4));
        
        return newPhone.toString().trim();
    }
      
    public static String formatEmail(String email){
        StringBuffer newEmail = new StringBuffer("E:");
        if(email.trim().length()<1){
            return null;
        }
        String[] tokens = email.split("@");
        if(tokens.length<2){
            return null;
        }
        newEmail.append(tokens[0].substring(0,1));
        newEmail.append("*****");
        newEmail.append(tokens[0].substring(tokens[0].length()-1));
        newEmail.append("@");
        newEmail.append(tokens[1]);
        //System.out.println("for input:"+email+" we got:"+newEmail.toString().trim());
        return newEmail.toString().trim();
    }
    
    public static String formatPhone0(String phone){
      StringBuffer newPhone = new StringBuffer("P:");
        phone = phone.replace(") "," ");
        phone = phone.replace(")"," ");
        phone = phone.replace("("," ");
        phone = phone.trim();
        
        char [] chars = phone.toCharArray();
        for(int i=0;i<chars.length-5; i++){//skip the last four numbers
            if(chars[i]=='+'){
                newPhone.append(chars[i]);
            }
            else if(chars[i]=='(' || chars[i]==')'){
                continue;
            }
            else if(chars[i]==' '){
                newPhone.append("-");
            }else{
                newPhone.append("*");
            }
        }
        newPhone.append("-");
        newPhone.append(phone.substring(phone.length()-4));
        //System.out.println("for input:"+phone+" we got:"+newPhone.toString().trim());
        return newPhone.toString().trim();
    }  
      
      public static String formatPhone(String phone){
          phone = phone.trim();
          if(phone.length()<10){
              return null;
          }
          phone = phone.replace("(", " ");
          phone = phone.replace(")"," ");
          phone = phone.replace("  "," ");
          StringBuffer newPhone = new StringBuffer("P:");
          String token1 = phone.substring(0, phone.length() - 5);
          String[] tokens = token1.split(" ");
          for(String item:tokens){
              item = item.trim();
              if(item.length()>0){
                  char[] chars = item.toCharArray();
              for(char c:chars){
                  if(c=='+'){
                      newPhone.append(c);
                  }else if(c==' '){
                    continue;
                }else{
                      newPhone.append("*");
                  }
              }
              newPhone.append("-");
              }
          }
          //append the last token
          newPhone.append(phone.substring(phone.length()-4));
          return newPhone.toString().trim();
      }
      
    public static void main(String args[]){
        String a = "+1 (333) 444-5678";
        System.out.println(formatPhone(a));
        String b= "+11 (333) 444-5678";
         System.out.println(formatPhone(b));
         String c= "+111 (333) 444-5678";
         System.out.println(formatPhone(c));
         String d= "333 444-5678";
         System.out.println(formatPhone(d));
         String e= "(333) 444-5678";
         System.out.println(formatPhone(e));
         String f= "(333)444-5678";
         System.out.println(formatPhone(f));
         String g="(333)456-7890";
         System.out.println(formatPhone(g));
         String h ="+1(333) 456-7890";
         System.out.println(formatPhone(h));
        
    }
}
