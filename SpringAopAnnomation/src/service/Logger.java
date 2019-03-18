package service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
// 配置切面
@Aspect
public class Logger {
    // 配置切入点表达式
    @Pointcut("execution(* service.imp.*.*(..))")
    private void ex1(){}

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
     * 环绕通知
     */
    // 配置环绕通知
    @Around("ex1()")
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
