package DeadLock;

public class DeadLockDemo {
	public static void main(String[] args) {
		new DeadThread();
	}
}

// 死锁线程
class DeadThread implements Runnable{
	Customer c = new Customer();
	Service s = new Service();
	
	public DeadThread() {
		new Thread(this).start();
		c.say(s);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		s.say(c);
	}
	
}

class Customer{
	public synchronized void say(Service s) {
		System.out.println("先吃饭再买单");
		s.doServer();
	}
	
	public synchronized void doServer() {
		System.out.println("同意了，先买单再吃饭");
	}
}

class Service {
	public synchronized void say(Customer c) {
		System.out.println("先买单再吃饭");
		c.doServer();
	}
	
	public synchronized void doServer() {
		System.out.println("同意了，先吃饭再买单");
	}
}

