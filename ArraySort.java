package test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
		 ��������
		��������һ������Ϊn�����У���������а���С�����˳�����С�1<=n<=200
		�����ʽ
		������һ��Ϊһ������n��
		�����ڶ��а���n��������Ϊ�����������ÿ�������ľ���ֵС��10000��
		�����ʽ
		�������һ�У�����С�����˳��������������С�
		��������
			5
			8 3 6 4 9
		�������
			3 4 6 8 9
*/

public class ArraySort {
	public static void sort(ArrayList<Integer> a){
		Collections.sort(a);
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i)+" ");
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> ar = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		for (int i = 0; i < num1; i++) {
			int num2 = sc.nextInt();
			ar.add(num2);
		}
		sort(ar);
	}
}
