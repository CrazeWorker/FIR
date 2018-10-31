package 直接插入排序;

import org.junit.Test;

public class InsertSort {
	public void insertSort(int[] a) {
		// 从index=1开始插入
		for (int i = 1; i < a.length; i++) {
			// 记下开始插入的元素的index
			int j = i;
			// 如果插入的元素比它的前一个元素小，与前一个元素互换，直到此元素插入到相应的位置
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
