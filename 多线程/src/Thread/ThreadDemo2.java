package Thread;

/*
 * 休眠状态下的线程被打断时  会抛出异常 InterrupterException
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
				// jion方法  暂停执行本线程,让执行此jion方法的线程执行完毕后,本线程继续执行(可指定时间)
				try {
					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(i == 8) {
				// (第一种中断方法)做了一个中断标记
//				t.interrupt();
				// (第二种中断方法)自定义中断标记flag
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
			// 判断，如果碰到中断标记，执行以下代码，调用interrupted方法后，中断标记会被清除
			if(Thread.interrupted()) {
				System.out.println("俺已经被中断了");
			}
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
}



class MyRunnable4 implements Runnable{
	// 定义自定义中断标记
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




