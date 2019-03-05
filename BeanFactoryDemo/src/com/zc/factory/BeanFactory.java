package com.zc.factory;


import com.zc.dao.ICustomerDao;
import com.zc.service.ICustomerService;
import jdk.internal.util.xml.impl.Input;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/*
 * 一个工厂类
 * */
public class BeanFactory {
/*
    // 1、定义一个properties对象
    private static Properties properties = null;
    // 2、使用静态代码块给对象复制
    static {
        try {
            // 项目发布之后src文件夹就不存在，根据src寻找文件会报ClassNotFoundException,因此不能用如下方法
            *//*InputStream in = new FileInputStream(new File("src/bean.properties"));*//*

            //
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties")
            properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    // 1、此对象只能用于读取properties文件，其他的文件类型读取不了
    // 2、此对象只能用于读取，不能用于写入
    // 3、此对象只能读取类路径下的文件，不在类路径下读取不了
    // 4、注意：方法参数的写法是按照 包名.类名 的方式来写的，因此文件不需要写后缀名
    private static ResourceBundle bundle = ResourceBundle.getBundle("bean");

    public static Object getBean(String beanName){
        try {
            // 1、读取配置文件，根据beanName获取全限定类名
            String beanPath = bundle.getString(beanName);
            return Class.forName(beanPath).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}


