package ProAndCos;

public class Producer implements Runnable{
	public synchronized void produce(String name) {
		
		// �����ʳ�ʲôҲ�������ȴ��˹˿�ȡ��ʳ���Լ���һ���˿ͻ���
		if(FoodLock.lock!=0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("������һ��"+name);
		FoodLock.lock++;
		this.notify();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			this.produce("�Ǵ��Ｙ");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			FoodLock.lock ++;
	}
}
