package com.proxy;

/**
 * 动态代理：
 *      作用，不改变源码的基础上，对已有的方法增强（他是OP思想的实现技术）
 *      分类：
 *          1、基础接口的动态代理：
 *              要求：被代理类最少实现一个接口
 *              提供者：JDK
 *              涉及的类：Proxy
 *              创建代理对象的方法：newProxyInstance(ClassLoaders,Class[],invocationHandler)
 *              参数列表：ClassLoader：类加载器，和被代理对象使用相同的类加载器
 *                       Cllas[]：字节码的数组。被代理类实现的接口，要求代理对象和被代理对象具有相同的行为，一般是固定写法
 *                       InvocationHandler：她是一个借口，用于我们提供增强代码的。我们一般都是写一个该接口的实现类。实现类可以是匿名内部类。
 *                                          它的含义是：如何代理。此处代码只能是谁用谁提供。
 *                                          策略模式：使用要求：数据已经有了，目的明确，达成目标的过程就是策略。
 *                                          DBUtil的ResultSetHandler就是策略模式的具体要求。
 *
 */


public class Actor implements Broker{
    /**
     * 基本的演出
     */
    public void basicAct(float money) {
        System.out.println("拿到钱，开始基本的表演");
    }


    /**
     * 危险的演出
     */
    public void dangerAct(float money){
        System.out.println("拿到钱，开始危险的表演！");
    }
}
