package Synchronization;

import java.util.concurrent.locks.ReentrantLock;

/*
 * 
 * 多线程资源共享数据，会发生线程不安全的情况
 * 因此多线程共享数据时，必须使用同步(一段时间内只能由一个线程实现此代码)
 * 
 * 实现同步的方法：
 * 		1、使用同步代码块，将要实现同步的代码用同步代码块包裹起来
 * 		2、使用同步方法封装要实现同步的代码
 * 		3、使用互斥锁的lock和unlock方法实现同步
 * 
 * 注意：
 * 1、使用同步可以解决安全问题，但会牺牲性能，所以同步的代码部分要尽量保持简短
 * 	   把不随数据变化的相关代码移除同步。
 * 2、不要阻塞
 * 3、在同步中避免调用其他对象的同步方法，防止死锁发生
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
	// 同步锁(可以为任何对象)
	private Object ob = new Object();
	
	// 互斥锁
	ReentrantLock rl = new ReentrantLock();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {	
			 //方法1：使用同步代码块使线程安全(参考PV操作)
			
				if(ticket>0) {
					synchronized(ob) {
					ticket--;
					System.out.println("成功购票一张，机票剩余:"+ticket);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				}else {
					System.out.println("机票已经售空！");
					break;
				}
			}	
		}
		

		// 调用同步方法
//		putOff();
		
		// 方法3：使用Lock锁(先定义锁)
//		while(true) {
//			rl.lock();
//			if(ticket>0) {
//				ticket--;
//				System.out.println(Thread.currentThread().getName()+"成功购票一张，机票剩余:"+ticket);
//				try {
//					Thread.sleep(300);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}else {
//				System.out.println("机票已经售空！");
//				break;
//			}
//			rl.unlock();
//		}
	
	// 方法2：将要执行的方法封装成同步方法
	public synchronized void putOff() {
		while(true) {
			if(ticket>0) {
				ticket--;
				System.out.println(Thread.currentThread().getName()+"成功购票一张，机票剩余:"+ticket);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("机票已经售空！");
				break;
			}
		}
		
	}
}
