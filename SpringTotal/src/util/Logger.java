package util;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {
    public Object aroundPrintLogger(ProceedingJoinPoint jionPoint){
        Object res = null;
        try {
            System.out.println("前置通知:开始查询,请稍后~~~~~");
            res = jionPoint.proceed();
            System.out.println("后置通知:查询结束,结果已返回~~~~~");
        } catch (Throwable throwable) {
            System.out.println("异常通知:查询失败,出现未知问题~~~~~");
            throwable.printStackTrace();
        } finally {
            System.out.println("最终通知:查询完毕.");
        }
        return res;
    }
}
