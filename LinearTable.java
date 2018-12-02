package Day_2;

import org.junit.Test;

public class LinearTable {
	static int[] a = {1,7,2,5,3};
	// ����
	public static int find(int value) {
		for (int i = 0; i < a.length; i++) {
			if(a[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	// ɾ��
	public static int[] remove(int index) {
		int[] newA = new int[a.length - 1];
		for (int i = 0; i < newA.length; i++) {
			if(i<index) {
				newA[i] = a[i];
			}else if(i>=index){
				newA[i] = a[i+1];
			}
		}
		return newA;
	}
	
	// ���
	public static int[] add(int value,int index) {
		int[] newA = new int[a.length + 1];
		for (int i = 0; i < newA.length; i++) {
			if(i<index) {
				newA[i] = a[i];
			}else if(i == index){
				newA[i] = value;
			}else {
				newA[i] = a[i - 1];
			}
		}
		return newA;
	}
	
	// ����
	public static int[] reverse(int[] a) {
		int i = 0,j = a.length - 1;
		while(i<=j) {
			int temp = 0;
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		return a;
	}
	
	@Test
	public void test() {
		// ԭ�������
		System.out.print("ԭ���������");
		for (int i : a) {
			System.out.print(i+" ");
		}
		System.out.println();
		// ���Ҳ���
		System.out.println("���Ҳ��ԣ�"+find(2));
		// ��Ӳ���
		System.out.print("��Ӳ��ԣ�");
		for (int i : add(4,1)) {
			System.out.print(i+" ");
		}
		System.out.println();
		// ɾ������
		System.out.print("ɾ�����ԣ�");
		for (int i : remove(3)) {
			System.out.print(i+" ");
		}
		System.out.println();
		// ���ò���
		System.out.print("���ò��ԣ�");
		for (int i : reverse(a)) {
			System.out.print(i+" ");
		}
	}
}
