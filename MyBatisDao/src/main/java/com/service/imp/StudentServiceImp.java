package com.service.imp;

import com.bean.Student;
import com.bean.StudentVo;
import com.bean.TestAdmin;
import com.dao.StudentMapper;
import com.service.StudentService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentServiceImp implements StudentService {
    StudentMapper studentMapper;



    public StudentServiceImp(){
        // 加载配置文件conf.xml
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("conf.xml");
            // 创建SqlSession工厂
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            // 创建SqlSession
            SqlSession sqlSession = build.openSession();
            // 创建Mapper
            studentMapper = sqlSession.getMapper(StudentMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student selectStudentById(int number) {
        return studentMapper.selectStudentById(number);
    }

    @Override
    public List<Student> selectStudentByName(String name) {
        return studentMapper.selectStudentByName(name);
    }

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    @Override
    public boolean insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    @Override
    public boolean deleteStudent(int number) {
        return studentMapper.deleteStudent(number);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public List<Student> selectStudentByStudentVo(StudentVo studentVo) {
        return studentMapper.selectStudentByStudentVo(studentVo);
    }

    @Override
    public List<TestAdmin> getTestAdmin() {
        return studentMapper.getTestAdmin();
    }
}
