package Day_2;

import org.junit.Test;

public class LinearTable {
	static int[] a = {1,7,2,5,3};
	// ²éÕÒ
	public static int find(int value) {
		for (int i = 0; i < a.length; i++) {
			if(a[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	// É¾³ı
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
	
	// Ìí¼Ó
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
	
	// µ¹ÖÃ
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
		// Ô­Êı×é±éÀú
		System.out.print("Ô­Êı×é±éÀú£º");
		for (int i : a) {
			System.out.print(i+" ");
		}
		System.out.println();
		// ²éÕÒ²âÊÔ
		System.out.println("²éÕÒ²âÊÔ£º"+find(2));
		// Ìí¼Ó²âÊÔ
		System.out.print("Ìí¼Ó²âÊÔ£º");
		for (int i : add(4,1)) {
			System.out.print(i+" ");
		}
		System.out.println();
		// É¾³ı²âÊÔ
		System.out.print("É¾³ı²âÊÔ£º");
		for (int i : remove(3)) {
			System.out.print(i+" ");
		}
		System.out.println();
		// µ¹ÖÃ²âÊÔ
		System.out.print("µ¹ÖÃ²âÊÔ£º");
		for (int i : reverse(a)) {
			System.out.print(i+" ");
		}
	}
}
