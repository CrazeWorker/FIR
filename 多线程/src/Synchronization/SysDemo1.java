package Synchronization;

import java.util.concurrent.locks.ReentrantLock;

/*
 * 
 * ���߳���Դ�������ݣ��ᷢ���̲߳���ȫ�����
 * ��˶��̹߳�������ʱ������ʹ��ͬ��(һ��ʱ����ֻ����һ���߳�ʵ�ִ˴���)
 * 
 * ʵ��ͬ���ķ�����
 * 		1��ʹ��ͬ������飬��Ҫʵ��ͬ���Ĵ�����ͬ��������������
 * 		2��ʹ��ͬ��������װҪʵ��ͬ���Ĵ���
 * 		3��ʹ�û�������lock��unlock����ʵ��ͬ��
 * 
 * ע�⣺
 * 1��ʹ��ͬ�����Խ����ȫ���⣬�����������ܣ�����ͬ���Ĵ��벿��Ҫ�������ּ��
 * 	   �Ѳ������ݱ仯����ش����Ƴ�ͬ����
 * 2����Ҫ����
 * 3����ͬ���б���������������ͬ����������ֹ��������
 * 
 * */
public class SysDemo1 {
	public static void main(String[] args) {
		MyRunnable6 mr = new MyRunnable6();
		Thread t1 = new Thread(mr);
		Thread t2 = new Thread(mr);
		t1.start();
		t2.start();
	}
}


class MyRunnable6 implements Runnable{
	private int  ticket = 10;
	// ͬ����(����Ϊ�κζ���)
	private Object ob = new Object();
	
	// ������
	ReentrantLock rl = new ReentrantLock();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {	
			 //����1��ʹ��ͬ�������ʹ�̰߳�ȫ(�ο�PV����)
			
				if(ticket>0) {
					synchronized(ob) {
					ticket--;
					System.out.println("�ɹ���Ʊһ�ţ���Ʊʣ��:"+ticket);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				}else {
					System.out.println("��Ʊ�Ѿ��ۿգ�");
					break;
				}
			}	
		}
		

		// ����ͬ������
//		putOff();
		
		// ����3��ʹ��Lock��(�ȶ�����)
//		while(true) {
//			rl.lock();
//			if(ticket>0) {
//				ticket--;
//				System.out.println(Thread.currentThread().getName()+"�ɹ���Ʊһ�ţ���Ʊʣ��:"+ticket);
//				try {
//					Thread.sleep(300);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}else {
//				System.out.println("��Ʊ�Ѿ��ۿգ�");
//				break;
//			}
//			rl.unlock();
//		}
	
	// ����2����Ҫִ�еķ�����װ��ͬ������
	public synchronized void putOff() {
		while(true) {
			if(ticket>0) {
				ticket--;
				System.out.println(Thread.currentThread().getName()+"�ɹ���Ʊһ�ţ���Ʊʣ��:"+ticket);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("��Ʊ�Ѿ��ۿգ�");
				break;
			}
		}
		
	}
}
