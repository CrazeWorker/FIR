package dao;

import bean.Student;

import java.util.List;

public interface StudentDao {

    List<Student> findAllStudent();

    Student findStudent(int number);

}
