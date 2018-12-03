package Demon;
/*
 * 当运行的唯一线程都是守护进程线程时，java虚拟机将退出
 * 
 * */
public class DemonDemo1 {
	public static void main(String[] args) {
		MyRunnable5 my = new MyRunnable5();
		Thread t = new Thread(my);
		
		// 设置线程名称
		t.setName("FIR");
		// 将线程设置为守护线程(线程分为用户线程和守护线程)
		t.setDaemon(true);
		// 设置线程优先级(抢占CPU的概率更大,参数为int)
		t.setPriority(Thread.MAX_PRIORITY);
		
		// isAlive用来判断此线程是否处于活动状态
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
//				// 将此进程让步一次
//				Thread.yield();
//			}
		}
	}
}