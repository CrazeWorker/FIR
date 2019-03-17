package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        Actor actor = new Actor();
//        actor.basicAct(12321);
//        actor.dangerAct(12231);


        Broker broker = (Broker) Proxy.newProxyInstance(actor.getClass().getClassLoader(), actor.getClass().getInterfaces(), new InvocationHandler() {


            /**
             * 执行贝蒂阿里对象的任何方法都会经过该方法，该方法会有拦截的功能
             * 方法的参数：
             *      1、Object proxy：代理对象的引用，不一定每次都会有
             *      2、Method method：当前执行的方法
             *      3、Object[] args：当前执行方法所需的参数
             * 返回值：
             *      当前执行方法的返回值。
             * @param proxy
             * @param method
             * @param args
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object value = null;
                // 取出参数，即money
                Float money = (Float) args[0];
                // 判断方法类型
                if ("basicAct".equals(method.getName())) {
                    // 判断钱多钱少
                    if (money > 10000) {
                        // 执行方法，基本的演出
                        value = method.invoke(actor, money);
                    }
                }
                if ("dangerAct".equals(method.getName())) {
                    if (money > 50000) {
                        value = method.invoke(actor, money);
                    }
                }
                return value;
            }
        });
        broker.basicAct(20000);
        broker.dangerAct(60000);
    }
}
