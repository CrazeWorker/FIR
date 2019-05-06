package ProAndCos;
/*
 * 
 * 生产者消费者问题
 * 
 * 面试题：
 * sleep与wait的区别：
 * 		sleep：会让出CPU的时间片，不释放监视器的所有权(对象锁)
 * 		wait：让出CPU的时间片，同时释放监视器的所有权，等待其他线程通过notify唤醒
 * 
 * */
public class ProducterDemo {
	public static void main(String[] args) {
		Costomer c = new Costomer();
		
		Thread t1 = new Thread(c);
		
		t1.start();
		
	}
}
