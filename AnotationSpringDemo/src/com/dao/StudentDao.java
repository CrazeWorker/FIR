package com.dao;

import com.bean.Student;

import java.util.List;

/**
 * 客户的持久层接口
 */
public interface StudentDao {
    List<Student> findAllStudent();

    void saveStudent(Student student);

    void deleteStudent(int number);

    Student findStudent(int id);

    void updateStudent(Student student);

    void printA();
}
