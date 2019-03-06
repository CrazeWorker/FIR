package dao;

import bean.Student;

import java.util.ArrayList;

public interface StuDao {

    // 打印所有学生信息
    ArrayList<Student> getAll();
    // 根据学号模糊查询学生信息
    ArrayList<Student> getLikesById(int id);
    // 根据姓名模糊查询学生信息
    ArrayList<Student> getLikesByName(String name);
    // 根据年龄查询学生信息
    ArrayList<Student> getLikesByAge(int age);
    // 根据专业查询学生
    ArrayList<Student> getLikesByMajor(String major);
    // 增加学生
    boolean addStudent(Student student);
    // 修改学生信息
    boolean updateStudent(Student student);
    // 按照学号进行删除
    boolean deleteStudent(int id);
    // 根据id查学生对象
    Student getStudentById(int id);
}
