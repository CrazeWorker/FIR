package test1;

import java.util.Scanner;

/*
		 ��������
		����123321��һ���ǳ����������������߶��ʹ��ұ߶���һ���ġ�
		��������һ��������n�� �����������������λ����λʮ�������������λ����֮�͵���n ��
		�����ʽ
		��������һ�У�����һ��������n��
		�����ʽ
		��������С�����˳���������������������ÿ������ռһ�С�
		��������
			52
		�������
			899998
			989989
			998899
		���ݹ�ģ��Լ��
		����1<=n<=54
*/


public class Palindrome {
	public static void search(int n){
		int total = 0;
		for (int i = 10000; i < 1000000; i++) {
			StringBuffer sb = new StringBuffer(""+i);
			if(sb.toString().equals(sb.reverse().toString())){
				String s = sb.toString();
				total = 0;
				for (int j = 0; j < s.length(); j++) {
					char ch = s.charAt(j);
					total += ch-'0';
				}
				if(total==n){
					System.out.println(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		search(s);
	}
}
