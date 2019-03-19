package test;


import bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.StudentService;

import java.util.List;

public class TestDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        List<Student> allStudent = studentService.findAllStudent();
        for (Student student : allStudent) {
            System.out.println(student);
        }
    }
}
