package ProAndCos;
/*
 * 
 * ����������������
 * 
 * �����⣺
 * sleep��wait������
 * 		sleep�����ó�CPU��ʱ��Ƭ�����ͷż�����������Ȩ(������)
 * 		wait���ó�CPU��ʱ��Ƭ��ͬʱ�ͷż�����������Ȩ���ȴ������߳�ͨ��notify����
 * 
 * */
public class ProducterDemo {
	public static void main(String[] args) {
		Costomer c = new Costomer();
		
		Thread t1 = new Thread(c);
		
		t1.start();
		
	}
}
