package com.zc.maven;

import static org.junit.Assert.assertTrue;

import com.bean.Student;
import com.bean.StudentVo;
import com.service.StudentService;
import com.service.imp.StudentServiceImp;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        StudentService studentService = new StudentServiceImp();
        List<Student> students = studentService.selectAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void test(){
        StudentService studentService = new StudentServiceImp();
        Student student = new Student();
        student.setImg("img");
        StudentVo studentVo = new StudentVo();
        studentVo.setName("老");
        studentVo.setStudent(student);
        System.out.println(studentService.selectStudentByStudentVo(studentVo));
    }

    @Test
    public void test1(){
        StudentService studentService = new StudentServiceImp();
        System.out.println(studentService.getTestAdmin());
    }
}
