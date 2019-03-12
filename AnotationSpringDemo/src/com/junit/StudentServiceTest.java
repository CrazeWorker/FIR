package com.junit;

import com.bean.Student;
import com.config.SpringConfiguration;
import com.service.StudentService;
import com.service.imp.StudentServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class StudentServiceTest {

    @Autowired
    StudentService studentService = null;
    @Test
    public void testFindAll(){
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        List<Student> allStudent = studentService.findAllStudent();
        for (Student s: allStudent) {
            System.out.println(s);
        }
    }
}
