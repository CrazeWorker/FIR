package ExecutorDemo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * �̳߳أ� 
 * 	Executor�ӿڣ������ӿ�
 * 	ExecutorService�ӿ�
 * 
 * 
 * 
 * */


public class ExecutorDemo1 {
	public static void main(String[] args) {
		
		// �����̳߳أ�4�֣�
		
		// 1������һ�����̵߳��̳߳أ����̳߳�ֻ��һ���߳��ڹ������൱�ڴ��ж�������
//		ExecutorService es = Executors.newSingleThreadExecutor();
		
		// 2������һ���̶���С���̳߳�
//		ExecutorService es = Executors.newFixedThreadPool(2);
		
		// 3������һ���ɻ�����̳߳أ����Сû�����ƣ��ɸ����̵߳�ִ��״̬���տ����߳�
//		ExecutorService es = Executors.newCachedThreadPool();
		
		// 4������һ����С���޵��̳߳أ����̳߳�֧�ֶ�ʱ�Լ������Ե�ִ������
		ScheduledExecutorService es = Executors.newScheduledThreadPool(2);
		// �ӳ�ִ���̣߳�TimeUnit.MILLISECONDSΪʱ�䵥λ
		es.schedule(new MyRunnable7(), 3000, TimeUnit.MILLISECONDS);
		
//		es.execute(new MyRunnable7());
//		es.execute(new MyRunnable7());
		
		
		
		// �ر��̳߳�
		es.shutdown();
	}
}


class MyRunnable7 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 4; i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	
}
