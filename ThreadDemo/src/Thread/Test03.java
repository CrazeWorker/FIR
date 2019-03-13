package Thread;

import Excutor.Test;

import java.util.concurrent.CountDownLatch;

public class Test03 {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final Test03 test = new Test03();
        CountDownLatch countDownLatch = new CountDownLatch(10);//创建闭锁,监听个数为10个
        try {
            
        }
    }
}

class LatchDemo implements Runnable {
    Test03 test03;
    CountDownLatch countDownLatch;

    public LatchDemo(Test03 test03, CountDownLatch countDownLatch) {
        this.test03 = test03;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10; j++)
            test03.increase();
    }
}
