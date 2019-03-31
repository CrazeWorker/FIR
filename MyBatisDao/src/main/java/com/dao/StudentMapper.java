package com.dao;

import com.bean.Student;
import com.bean.StudentVo;
import com.bean.TestAdmin;

import java.util.List;

public interface StudentMapper {
    Student selectStudentById(int number);

    List<Student> selectStudentByName(String name);

    List<Student> selectAll();

    boolean insertStudent(Student student);

    boolean deleteStudent(int number);

    boolean updateStudent(Student student);

    List<Student> selectStudentByStudentVo(StudentVo studentVo);

    List<TestAdmin> getTestAdmin();
}
