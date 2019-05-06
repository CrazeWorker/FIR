package ProAndCos;

public class Producer implements Runnable{
	public synchronized void produce(String name) {
		
		// 如果有食物，什么也不做，等待此顾客取走食物以及下一个顾客唤醒
		if(FoodLock.lock!=0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("我做了一份"+name);
		FoodLock.lock++;
		this.notify();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			this.produce("糖醋里脊");
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
