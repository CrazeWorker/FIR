package Thread;

public class Test {
	public static void main(String[] args) {
		SubThread sb = new SubThread("ss");
		sb.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("main�߳�"+i);
		}
		
		// ����Runnable�ӿڵ�ʵ����
		Runnable rub = new MyRunnable();
		Thread th = new Thread(rub);
		th.start();
	}
}
