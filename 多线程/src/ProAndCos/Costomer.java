package ProAndCos;

public class Costomer implements Runnable{
	Producer p = new Producer();
	Thread t2 = new Thread(p);
	public synchronized void payForFood(String name) {
		// �����ʱ�������ѣ��������ߵȴ�,���һ���������
		if(FoodLock.lock==0) {
			try {
				this.wait();
				if(!t2.isAlive()) {
					t2.start();
				}else {
					this.notify();
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("������һ��"+name);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			this.payForFood("�Ǵ��Ｙ");
			// ������Ϻ�ı�����״̬
			FoodLock.lock -= FoodLock.lock;
		}
	}
}
