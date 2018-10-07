package test1;

import java.util.Scanner;

/*
 		十六进制转化为二进制
*/

public class SixChangeTwo {
	public static void change(String s){
		String total = "";
		String out = "";
		String t1 = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int num = 0 ;
			switch(ch){
				case 'A':
					num = 10;
					break;
				case 'B':
					num = 11;
					break;
				case 'C':
					num = 12;
					break;
				case 'D':
					num = 13;
					break;
				case 'E':
					num = 14;
					break;
				case 'F':
					num = 15;
					break;
				default:
					num = ch - '0';
			}
			out = "";
			while(num!=0){
				out += num%2;
				num = num/2;
			}
			while(out.length()<4&&i!=0){
				out = out+"0";
			}
			StringBuffer sb = new StringBuffer(out);
			sb = sb.reverse();
			total = total + sb;
		}
		System.out.println(total);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		change(n);
	}
}
