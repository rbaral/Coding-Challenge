package com.alg.leetup.others;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * ref:http://articles.leetcode.com/2011/11/longest-palindromic-substring-part-i.html
 * @modified rbaral
 *
 */
public class LongestPalindrome {

	
	public static String input ="civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
	public static Map statistic = new HashMap();
	public static Map allPalinDromes = new HashMap();

	public static void main(String[] args) {
		System.out.println(new Date());
		System.out.println(longestPalindrome("ab"));
		System.out.println(new Date());
	}

	public static String longestPalindrome(String s)
	{
		
		if(s.length()==0)
			return "";
		if(s.length()==1)
			return s;
		if(s.length()==2){
			if(s.charAt(0)==s.charAt(1))
				return s;
			else
				return s.substring(0,1);
		}
		char[] c = s.toCharArray();
		int maxLen = 0, len = 0;
		int begin = 0;
		for (int k = 0; k < s.length() - 1; k++) {
			len = 0;
			while (k - len - 1 >= 0 && k + len + 1 < s.length() && c[k - len - 1] == c[k + len + 1]) {
				len += 1;
			}
			if (len * 2 + 1 > maxLen) {
				begin = k - (len - 1) - 1;
				maxLen = len * 2 + 1;
			}
			len = 0;
			while (k >= len && k + len + 1 < s.length() && c[k - len] == c[k + len + 1]) {
				len += 1;
			}
			if (len * 2 > maxLen) {
				begin = k - (len - 1);
				maxLen = len * 2;
			}
		}
		return new String(c, begin, maxLen);
	}
}
