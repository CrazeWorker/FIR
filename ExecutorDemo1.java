package ExecutorDemo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * 线程池： 
 * 	Executor接口：顶级接口
 * 	ExecutorService接口
 * 
 * 
 * 
 * */


public class ExecutorDemo1 {
	public static void main(String[] args) {
		
		// 创建线程池（4种）
		
		// 1、创建一个单线程的线程池，此线程池只有一个线程在工作，相当于串行多有任务
//		ExecutorService es = Executors.newSingleThreadExecutor();
		
		// 2、创建一个固定大小的线程池
//		ExecutorService es = Executors.newFixedThreadPool(2);
		
		// 3、创建一个可缓存的线程池，其大小没有限制，可根据线程的执行状态回收空闲线程
//		ExecutorService es = Executors.newCachedThreadPool();
		
		// 4、创建一个大小无限的线程池，此线程池支持定时以及周期性的执行任务
		ScheduledExecutorService es = Executors.newScheduledThreadPool(2);
		// 延迟执行线程，TimeUnit.MILLISECONDS为时间单位
		es.schedule(new MyRunnable7(), 3000, TimeUnit.MILLISECONDS);
		
//		es.execute(new MyRunnable7());
//		es.execute(new MyRunnable7());
		
		
		
		// 关闭线程池
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
