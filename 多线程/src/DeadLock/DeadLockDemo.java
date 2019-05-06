package DeadLock;

public class DeadLockDemo {
	public static void main(String[] args) {
		new DeadThread();
	}
}

// �����߳�
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
		System.out.println("�ȳԷ�����");
		s.doServer();
	}
	
	public synchronized void doServer() {
		System.out.println("ͬ���ˣ������ٳԷ�");
	}
}

class Service {
	public synchronized void say(Customer c) {
		System.out.println("�����ٳԷ�");
		c.doServer();
	}
	
	public synchronized void doServer() {
		System.out.println("ͬ���ˣ��ȳԷ�����");
	}
}

