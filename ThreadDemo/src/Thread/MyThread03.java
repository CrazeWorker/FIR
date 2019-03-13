package Thread;

import java.util.concurrent.Callable;

public class MyThread03 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        // 线程的执行体，设置返回值为Integer类型,并声明抛出Exception
        System.out.println("我是继承了Callable接口实现的线程");
        return 5;
    }
}
