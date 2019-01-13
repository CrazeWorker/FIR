package www.Oricle_Day08_Test;

public class ArrayTest {

	public static void main(String[] args) {
		//定义一个数组并初始化
		int [] array = {26,26,67,89,44};
		//调用遍历方法
		//printArray(array);
		//调用逆序方法
		//reverse(array);
		//System.out.println();
		//再次调用遍历方法
		//printArray(array);
		//System.out.println();
		//调用选择排序
		//selectSort(array);
		//调用遍历方法
		//printArray(array);
		//调用冒泡排序
		bubbleSort(array);
		//调用遍历方法
		printArray(array);

	}
/*
	 *选择排序的方法
	 *参数列表：数组
	 *返回值类型：void 
	 */
	private static void selectSort(int[] array) {
			// TODO Auto-generated method stub
		int m = 0;
		for (int l = 0; l < array.length - 1; l++){
			//外层循环控制排序次数，一共需要array-1次循环
	        for (m = l+1; m < array.length ; m++) {	
	        	//内层循环控制排序比较元素的个数，每次从第圈数个元素开始往后比较
				int temp = 0;
				//定义一个第三方变量
				if(array[l] > array[m]){
					//比较数组的元素，如果比后面的元素比前面的元素小就互换
					temp = array[l];
					array[l] = array[m];
					array[m] = temp;
				}
			}
	        }
			
		}
/*
 *冒泡排序的方法 
 * 参数列表：数组
 * 返回值类型：void
 * */	
private static void bubbleSort(int[] array) {
		// TODO Auto-generated method stub
	 	for (int i = 0; i < array.length - 1; i++) {
	 		//外层循环控制比较的次数
			for (int j = 0; j < array.length - 1 - i; j++) {
				//内层循环控制每次比较的元素个数
				if(array[j] > array[j+1]){
					//if语句对数组的元素进行比较
				int temp = 0;
				//定义第三方变量，交换元素的值
				temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
				}
			}
		}
		
	}
/*
 * 逆序数组的方法：
 * 参数类型：数组
 * 返回值类型：void	
 */
	private static void reverse(int[] array) {
		// TODO Auto-generated method stub
	    for (int min = 0,max = array.length - 1; min < max; min++,max--) {
			int temp = array[min];
			array[min] = array[max];
			array[max] = temp;
		}		
		}

/* 遍历数组的方法：
 * 参数类型：数组
 * 返回值类型：void
 */
	private static void printArray(int[] array) {
		// TODO Auto-generated method stub
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			if(i == array.length - 1){
				System.out.print(array[i]+"]");
			}
			else{
			System.out.print(array[i]+",");
			}
		}
		
	}

}
