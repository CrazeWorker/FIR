package 堆排序;

import java.util.Arrays;

import org.junit.Test;

/*
	堆是这样一种完全二叉树：根节点的值大于等于左右孩子节点的值（最大堆）或者根节点的值小于等于左右孩子节点的值（最小堆）。
	堆也是递归定义的，即堆的孩子节点本身也是堆。使用数组存储堆。
	
	堆具有以下性质：

	1）完全二叉树A[0:n-1]中的任意节点，索引为i的节点，其左右孩子节点是2*i+1和2*i+2。
	
	2）非叶子节点最大索引是⌊n/2⌋-1，叶子节点最小索引是⌊n/2⌋。
	
	3）最大(最小)堆的左右子树也是最大（小）堆。
	
	如果是升序排列，就使用最大堆，反之使用最小堆。以下假设是升序排列。
 */
public class HeapSort {
	// 1.构建大顶堆
	public void createHeap(int[] a) {
		// 从第一个非叶子结点(n/2-1)从下至上，从左至右调整结构
		for (int i = a.length/2-1; i > 0; i--) {
			adjust(a,i,a.length-1);
		}
	}
	// 调整堆
	public void adjust(int[] a, int i, int length) {
		// 记下当前元素i，即要调整的子堆的堆顶
		int temp = a[i];
		// 从其左孩子开始比较
		for (int k = i*2+1; k < length; k=k*2+1) {
			// 如果有右孩子并且右孩子比左孩子大，k指向右孩子
			if(k+1<length&&a[k]<a[k+1]) {
				k++;
			}
			// 最大的元素置换到子堆堆顶
			if(a[k]>temp) {
				a[i] = a[k];
				i = k;
			}else {
				break;
			}
		}
		a[i] = temp;
	}
	// 排序
	public void sort(int[] a) {
		createHeap(a);
		// 交换堆顶元素与末尾元素，并且重新调整堆的结构
		for (int i = a.length-1; i > 0; i--) {
			swap(a,0,i);
			adjust(a, 0, i);
		}
	}
	// 交换
	public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
	
	@Test
	public void test() {
		int[] a = {9,8,7,6,5,4,3,2,1};
		sort(a);
		System.out.println(Arrays.toString(a));
	}
}
