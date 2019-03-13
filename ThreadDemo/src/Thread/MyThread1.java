package Thread;

public class MyThread1 extends Thread{
    @Override
    public void run(){
        // 线程的任务，即线程执行体
        System.out.println("我是继承了Thread创建的线程");
    }
}
