package client;

import config.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.StudentService;

public class Client {
    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
//        studentService.findAllStudent();
//        studentService.deleteStudent();
//        studentService.updateStudent(0);

        // 不使用xml文件的创建
        ApplicationContext applicationContext1 = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        StudentService service = (StudentService) applicationContext1.getBean("studentService");
        service.findAllStudent();
    }
}
