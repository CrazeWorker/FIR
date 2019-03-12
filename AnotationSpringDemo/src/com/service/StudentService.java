package com.service;

/*
客户的业务层接口
 */


import com.bean.Student;

import java.util.List;

public interface StudentService {

    /**
     * 查询所有学生
     * @return
     */
    List<Student> findAllStudent();

    /**
     * 保存学生信息
     */
    void saveStudent(Student student);

    /**
     * 更新学生信息
     * @param student
     */
    void udpateStudent(Student student);

    /**
     * 根据id删除学生信息
     * @param number
     */
    void deleteStudent(int number);

    /**
     * 根据id查询学生
     * @param id
     * @return
     */
    Student findStudent(int id);

    void printA();

}
