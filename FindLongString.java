package test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
		��������
		��������һ������Ϊn���ַ���S������һ������L��ͳ�Ƴ��ȴ��ڵ���L�ĳ��ִ��������Ӵ�����ͬ�ĳ��ֿ����ཻ����
		       ����ж���������ģ������Ȼ�ж���������һ�γ�������ġ�
		�����ʽ
		������һ��һ������L��
		�����ڶ������ַ���S��
		����L����0���Ҳ�����S�ĳ��ȡ�
		�����ʽ
		����һ�У���ĿҪ����ַ�����
		
		��������1��
			4
		    bbaabbaaaaa
		
		�������1��
		��  ��bbaa
		
		��������2��
			2
			bbaabbaaaaa
		
		�������2��
		���� 	aa
		 ���ݹ�ģ��Լ��
			n<=60
			S�������ַ�����СдӢ����ĸ��
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
