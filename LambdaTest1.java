package test1;

import java.io.File;
import java.util.ArrayList;

public class LambdaTest1 {
	public static void main(String[] args) {
		
		//����Lambda���ʽʵ��һ���ӿ�
		Eatable e = () -> {
			for (int i = 0; i < 20; i++) {
				System.out.println(i);
			}
		};
		e.taste();
		//����ѭ���������
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(1);
		//��һ��д����foreachѭ��
		for (Integer integer : a) {
			System.out.println(integer);
		}
		//�ڶ���д����Lambda���ʽ(��������)
		File file = new File("C:\\Users\\Administrator\\Desktop\\��������");
		file.listFiles((dir,name) -> name.endsWith(".doc"));
		a.forEach(integer -> System.out.println(integer));
		//����foreachѭ�����ʽ�������
		int [] a1 = new int [] {1,2,3,4,5,6};
		for (int i : a1) {
			System.out.println(i);
		}
	}
}
