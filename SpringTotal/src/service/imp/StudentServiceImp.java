package service.imp;

import bean.Student;
import dao.StudentDao;
import service.StudentService;

import java.util.List;

public class StudentServiceImp implements StudentService {

    StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> findAllStudent() {
        return studentDao.findAllStudent();
    }

    @Override
    public Student findStudent(int number) {
        return studentDao.findStudent(number);
    }
}
