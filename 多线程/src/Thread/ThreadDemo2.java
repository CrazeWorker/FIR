package Thread;

/*
 * ����״̬�µ��̱߳����ʱ  ���׳��쳣 InterrupterException
 * 
 * 
 * 
 * */



public class ThreadDemo2 {
	public static void main(String[] args) {
		MyRunnable3 mr = new MyRunnable3();
		Thread t = new Thread(mr);
		MyRunnable4 mr4 = new MyRunnable4();
		Thread t2 = new Thread(mr4);
		t2.start();
		t.start();
		for (int i = 0; i < 20; i++) {
			if(i == 10) {
				// jion����  ��ִͣ�б��߳�,��ִ�д�jion�������߳�ִ����Ϻ�,���̼߳���ִ��(��ָ��ʱ��)
				try {
					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(i == 8) {
				// (��һ���жϷ���)����һ���жϱ��
//				t.interrupt();
				// (�ڶ����жϷ���)�Զ����жϱ��flag
				mr4.flag = false;
			}
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
		
	}
}


class MyRunnable3 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 15; i++) {
			// �жϣ���������жϱ�ǣ�ִ�����´��룬����interrupted�������жϱ�ǻᱻ���
			if(Thread.interrupted()) {
				System.out.println("���Ѿ����ж���");
			}
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
}



class MyRunnable4 implements Runnable{
	// �����Զ����жϱ��
	public boolean flag = true;
	@Override
	public void run() {
		int i = 0;
		// TODO Auto-generated method stub
		while(flag) {
			System.out.println(Thread.currentThread().getName()+" "+(i++));
		}
	}
}




