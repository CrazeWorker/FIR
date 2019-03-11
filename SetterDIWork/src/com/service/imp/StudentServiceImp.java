package com.service.imp;

import com.bean.Student;
import com.dao.imp.StudentDaoImp;
import com.service.StudentService;
import com.dao.StudentDao;

import java.util.List;

/**
 * 业务层实现类
 * @author zc
 */
public class StudentServiceImp implements StudentService {

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    private StudentDao studentDao;

    @Override
    public List<Student> findAllStudent() {
        return studentDao.findAllStudent();
    }

    @Override
    public void saveStudent(Student student) {
        studentDao.saveStudent(student);
    }

    @Override
    public void udpateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public void deleteStudent(int number) {
        studentDao.deleteStudent(number);
    }

    @Override
    public Student findStudent(int id) {
        return studentDao.findStudent(id);
    }
}
