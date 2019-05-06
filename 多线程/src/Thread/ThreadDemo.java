package Thread;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class ThreadDemo {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		mt.start();
		
		
		// 推荐使用方式
		MyRunnable2 mr = new MyRunnable2();
		Thread t = new Thread(mr);
		t.start();
	}
}


/*
 * 实现线程的第一种方法 
 * 
 */
class MyThread extends Thread{
	@Override
	public synchronized void run() {
		for (int i = 0; i < 20; i++) {
			if(i == 10) {
				try {
					this.wait();
					// 当前线程休眠(参数为毫秒数),会释放CPU的时间片
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 获取当前的线程对象
			System.out.println(Thread.currentThread()+" "+ i);
		}
	}
}


/*
 * 实现线程的第二种方法 
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
