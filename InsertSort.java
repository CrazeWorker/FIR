package ֱ�Ӳ�������;

import org.junit.Test;

public class InsertSort {
	public void insertSort(int[] a) {
		// ��index=1��ʼ����
		for (int i = 1; i < a.length; i++) {
			// ���¿�ʼ�����Ԫ�ص�index
			int j = i;
			// ��������Ԫ�ر�����ǰһ��Ԫ��С����ǰһ��Ԫ�ػ�����ֱ����Ԫ�ز��뵽��Ӧ��λ��
			while(j > 0&&a[j]<a[j-1]) {
				int temp = a[j];
				a[j] = a[j-1];
				a[j-1] = temp;
				j--;
			}
		}
	}
	
	@Test
	public void test() {
		int[] a = {9,1,2,5,7,4,8,6,3,5};
		insertSort(a);
		for (int i : a) {
			System.out.print(i+" ");
		}
	}
}
