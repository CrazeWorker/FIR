public class ArrayMax{
	public static void main(String[] args){
		//创建数组对象并且进行赋值
		int [] arr = {2,1,2,5,6,7,8};
		//定义变量max用于记住最大值，并且假设arr[0]为最大值
		int max = arr[0];
		//for循环遍历数组
		for(int i = 1;i<arr.length;i++){
			if(arr[i]>max){
				max = arr[i];
			}
		}
		System.out.println("最大值为："+max);//打印最大值
	}
}