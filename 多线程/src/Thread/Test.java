package Thread;

public class Test {
	public static void main(String[] args) {
		SubThread sb = new SubThread("ss");
		sb.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("main线程"+i);
		}
		
		// 创建Runnable接口的实现类
		Runnable rub = new MyRunnable();
		Thread th = new Thread(rub);
		th.start();
	}
}
