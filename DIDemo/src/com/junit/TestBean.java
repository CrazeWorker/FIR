package com.junit;

import com.bean.StudentBean;
import com.bean.TeacherBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {
    @Test
    public void test01(){
        // 通过setter方法注入，为bean的属性赋值
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentBean student01 = (StudentBean) applicationContext.getBean("student01");
        System.out.println(student01);

        // setter方法注入，给bean中的引用类型的属性赋值
        TeacherBean teacher01 = (TeacherBean) applicationContext.getBean("teacher01");
        System.out.println(teacher01);

        // setter方法注入list集合和properties文件
        TeacherBean teacher02 = (TeacherBean) applicationContext.getBean("teacher02");
        System.out.println(teacher02);
    }
}
