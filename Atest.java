public class Atest{
	public static void main(String [] args){
		int [] [] arr = {{11,22},{21,22,23},{31,32,33,34}};
		int sum1= 0,sum2 = 0;
		for(int i = 0; i<arr.length;i++){
			for(int j = 0; j<arr[i].length;j++){
		           sum1 += arr[i][j];
				   sum2 += arr[i][j];
		}
		System.out.println("第"+(i+1)+"小组的销售额为："+sum1);
		sum1 = 0;
		}
		System.out.println("总销售额为"+sum2);
	}
}