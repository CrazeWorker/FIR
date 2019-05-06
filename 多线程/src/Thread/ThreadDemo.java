package Thread;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class ThreadDemo {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		mt.start();
		
		
		// �Ƽ�ʹ�÷�ʽ
		MyRunnable2 mr = new MyRunnable2();
		Thread t = new Thread(mr);
		t.start();
	}
}


/*
 * ʵ���̵߳ĵ�һ�ַ��� 
 * 
 */
class MyThread extends Thread{
	@Override
	public synchronized void run() {
		for (int i = 0; i < 20; i++) {
			if(i == 10) {
				try {
					this.wait();
					// ��ǰ�߳�����(����Ϊ������),���ͷ�CPU��ʱ��Ƭ
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// ��ȡ��ǰ���̶߳���
			System.out.println(Thread.currentThread()+" "+ i);
		}
	}
}


/*
 * ʵ���̵߳ĵڶ��ַ��� 
 * 
 */
class MyRunnable2 implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(i);
		}
	}
}
