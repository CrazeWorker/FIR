package Thread;

public class SubThread extends Thread{
	
	public SubThread(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"Ïß³Ì"+i);
		}
	}
}
