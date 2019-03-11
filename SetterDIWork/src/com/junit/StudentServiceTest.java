package com.junit;

import com.bean.Student;
import com.service.StudentService;
import com.service.imp.StudentServiceImp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class StudentServiceTest {

    @Test
    public void testFindAll(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        List<Student> allStudent = studentService.findAllStudent();
        for (Student student : allStudent) {
            System.out.println(student);
        }
    }

    @Test
    public void testFindStudent(){
        StudentService studentService = new StudentServiceImp();
        Student student = studentService.findStudent(4);
        System.out.println(student.toString());
    }

    @Test
    public void testUpdate(){
        StudentService studentService = new StudentServiceImp();
        Student student = new Student();
        student.setName("效里");
        student.setAge(16);
        student.setMajor("吃屎");
        student.setImg("img/hhh.jpg");
        student.setNumber(4);
        studentService.udpateStudent(student);

        Student student1 = studentService.findStudent(4);
        System.out.println(student1.toString());
    }

    @Test
    public void testDelete(){
        StudentService studentService = new StudentServiceImp();
        studentService.deleteStudent(4);

        List<Student> allStudent = studentService.findAllStudent();
        for (Student s :
                allStudent) {
            System.out.println(s);
        }
    }

    @Test
    public void testSaveStudent(){
        StudentService studentService = new StudentServiceImp();
        Student student = new Student();
        student.setName("效里");
        student.setAge(16);
        student.setMajor("吃屎");
        student.setImg("img/hhh.jpg");
        student.setNumber(33);
        studentService.saveStudent(student);

        List<Student> allStudent = studentService.findAllStudent();
        for (Student s :
                allStudent) {
            System.out.println(s);
        }
    }
}
