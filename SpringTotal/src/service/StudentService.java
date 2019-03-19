package service;

import bean.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudent();

    Student findStudent(int number);
}
