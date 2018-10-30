package 快速排序;


public class QuickSort {
	public static int quickSort(int[] a,int low,int high) {
		int x = a[low];
		int row = low;
		int temp = 0;
		while(low < high) {
			if(a[high] <= x) {
				temp = a[high];
				while(low < high) {
					if(a[low] > x) {
						a[high] = a[low];
						a[low] = temp;
						break;
					}
					low++;
				}	
			}
			high--;
		}
		a[row] = a[low];
		a[low] = x;
		return low;
	}
	
	public static void sort(int[] a,int low,int high) {
		// 注意递归出口
		if(low < high) {
			int num = quickSort(a, low, high);
			sort(a, low, num-1);
			sort(a, num+1, high);
		}	
	}
	
	public static void main(String[] args) {
		int[] a = {345,234,456,3242,123,43,556,23,1,654};
		sort(a,0,a.length-1);
		for (int i : a) {
			System.out.print(i+" ");
		}
	}
}
