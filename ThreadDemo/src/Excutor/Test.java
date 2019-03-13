package Excutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {
    public static void main(String[] args) {
        // 创建缓存线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 创建固定大小的线程池
        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
        // 创建一个定长线程池，支持定时及周期性任务执行。
        Executors.newSingleThreadScheduledExecutor();
        Executors.newScheduledThreadPool(5);
        // 创建新加入的线程池
        Executors.newWorkStealingPool();
    }

}
