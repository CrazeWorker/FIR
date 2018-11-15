package test1;

import java.io.File;
import java.util.ArrayList;

public class LambdaTest1 {
	public static void main(String[] args) {
		
		//利用Lambda表达式实现一个接口
		Eatable e = () -> {
			for (int i = 0; i < 20; i++) {
				System.out.println(i);
			}
		};
		e.taste();
		//集合循环遍历输出
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(1);
		//第一种写法：foreach循环
		for (Integer integer : a) {
			System.out.println(integer);
		}
		//第二种写法：Lambda表达式(集合特有)
		File file = new File("C:\\Users\\Administrator\\Desktop\\个人资料");
		file.listFiles((dir,name) -> name.endsWith(".doc"));
		a.forEach(integer -> System.out.println(integer));
		//数组foreach循环表达式遍历输出
		int [] a1 = new int [] {1,2,3,4,5,6};
		for (int i : a1) {
			System.out.println(i);
		}
	}
}
