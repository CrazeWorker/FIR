package Demon;
/*
 * �����е�Ψһ�̶߳����ػ������߳�ʱ��java��������˳�
 * 
 * */
public class DemonDemo1 {
	public static void main(String[] args) {
		MyRunnable5 my = new MyRunnable5();
		Thread t = new Thread(my);
		
		// �����߳�����
		t.setName("FIR");
		// ���߳�����Ϊ�ػ��߳�(�̷߳�Ϊ�û��̺߳��ػ��߳�)
		t.setDaemon(true);
		// �����߳����ȼ�(��ռCPU�ĸ��ʸ���,����Ϊint)
		t.setPriority(Thread.MAX_PRIORITY);
		
		// isAlive�����жϴ��߳��Ƿ��ڻ״̬
		System.out.println(t.isAlive());
		t.start();
		System.out.println(t.isAlive());
		
		for (int i = 0; i < 10; i++) {
			System.out.println("main "+i);
		}
	}
}

class MyRunnable5 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
//			if(i==5) {
//				// ���˽����ò�һ��
//				Thread.yield();
//			}
		}
	}
}