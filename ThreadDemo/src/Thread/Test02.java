package Thread;

import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test02 {
    public static void main(String[] args) {
        // 创建线程
        Thread thread = new MyThread1();
        // 启动线程
        thread.start();

        // 创建线程,实现Runnable的实现类作为Thread的参数创建线程
        Thread thread01 = new Thread(new MyThread2());
        // 执行线程
        thread01.start();

        // 创建Callable实现类
        MyThread03 myThread03 = new MyThread03();
        // 创建FutureTask对象包装Callable实现类，同时封装了call方法的返回值
        FutureTask<Integer> futureTask = new FutureTask<>(myThread03);
        // 创建线程，将FutureTask类对象作为Thread的参数
        Thread thread03 = new Thread(futureTask);
        thread03.start();
        // 获取futureTask封装的call方法的返回值,若此时线程任务并未返回参数，此方法会阻塞到任务返回参数为止
        try {
            Integer integer = futureTask.get();
            System.out.println("call方法的返回值为："+integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testHash(){
        int h;
        Object object=null;
        h = (object==null)?0:(h=object.hashCode())^(h>>>16);
    }
}

