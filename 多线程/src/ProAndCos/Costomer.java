package ProAndCos;

public class Costomer implements Runnable{
	Producer p = new Producer();
	Thread t2 = new Thread(p);
	public synchronized void payForFood(String name) {
		// 如果此时不能消费，让消费者等待,并且唤醒生产者
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
		System.out.println("我买到了一份"+name);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			this.payForFood("糖醋里脊");
			// 消费完毕后改变消费状态
			FoodLock.lock -= FoodLock.lock;
		}
	}
}
