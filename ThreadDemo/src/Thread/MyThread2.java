package Thread;

public class MyThread2 implements Runnable {
    @Override
    public void run() {
        // 线程的执行体
        System.out.println("我是继承Runnable实现的线程");
    }
}
