package service;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {
    /**
     * 前置通知
     */
    public void beforePrintLogger(){
        System.out.println("前置通知:开始记录日志了");
    }
    /**
     * 后置通知
     */
    public void afterReturningPrintLogger(){
        System.out.println("后置通知:开始记录日志了");
    }
    /**
     * 异常通知
     */
    public void afterThrowingPrintLogger(){
        System.out.println("异常通知:开始记录日志了");
    }
    /**
     * 最终通知
     */
    public void afterPrintLogger(){
        System.out.println("最终通知:开始记录日志了");
    }
    /**
     * 最终通知
     */
    public Object aroundPrintLogger(ProceedingJoinPoint joinPoint){
        Object res = null;
        try {
            System.out.println("前置通知:开始记录日志了");
            res = joinPoint.proceed();
            System.out.println("后置通知:开始记录日志了");
        } catch (Throwable throwable) {
            System.out.println("异常通知:开始记录日志了");
            throwable.printStackTrace();
        } finally {
            System.out.println("最终通知:开始记录日志了");
        }
        return res;
    }

}
