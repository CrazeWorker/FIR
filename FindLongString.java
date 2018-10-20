package test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
		问题描述
		　　给定一个长度为n的字符串S，还有一个数字L，统计长度大于等于L的出现次数最多的子串（不同的出现可以相交），
		       如果有多个，输出最长的，如果仍然有多个，输出第一次出现最早的。
		输入格式
		　　第一行一个数字L。
		　　第二行是字符串S。
		　　L大于0，且不超过S的长度。
		输出格式
		　　一行，题目要求的字符串。
		
		输入样例1：
			4
		    bbaabbaaaaa
		
		输出样例1：
		　  　bbaa
		
		输入样例2：
			2
			bbaabbaaaaa
		
		输出样例2：
		　　 	aa
		 数据规模和约定
			n<=60
			S中所有字符都是小写英文字母。
		*/


public class FindLongString {
	public static void find(int x) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int m = 0;
		ArrayList<String> st = new ArrayList<>();
		ArrayList<Integer> num = new ArrayList<>();
		for (int i = 0; x <= s.length(); i++) {
			m = 0;
			String small = s.substring(i, x);
			for (int j = 0; j < st.size(); j++) {
				if(small.equals(st.get(j))){
					int number = num.get(j);
					number++;
					num.set(j, number);
					m=1;
				}
			}
			if(m==0){
				st.add(small);
				num.add(1);
			}
			x++;
		}
		int big = Collections.max(num);
		System.out.println(st.get(num.indexOf(big)));
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		find(x);
	}
}
