/*
需求：0.01厚度的纸对着多少次能达到珠穆朗玛峰的高度
软件分析：
    1、定义一个统计变量
	2、对折一次是原来厚度的两倍，初始厚度为0.01
	3、每折一次，统计变量++
	4、输出统计变量

*/
public class WhileTest{
	public static void main(String [] args){
		//定义一个统计变量
		int number = 0;
		int start = 1;
		int end = 884800;
		//初始高度为1，最终高度为8848，用循环控制，计数器每次加一，初始高度每次乘2
		while(start<end){
			number++;
			start *=2;
			System.out.println("现在的统计次数为："+number+"现在的高度为："+start);
			
		}
		//输出统计变量
		System.out.println("需要折叠次数为："+number);
	}
}