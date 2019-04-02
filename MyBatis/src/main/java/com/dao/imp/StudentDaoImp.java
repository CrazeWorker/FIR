package com.dao.imp;

import com.bean.Student;
import com.dao.StudentDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentDaoImp implements StudentDao {

    SqlSession sqlSession = null;

    public StudentDaoImp() {
        InputStream in = null;
        try {
            // 加载conf.xml配置文件，转换成输入流
            in = Resources.getResourceAsStream("conf.xml");
            // 创建会话工厂，传入MyBatis的文件配置信息
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
            // 通过工厂的到sql会话
            sqlSession = build.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    /**
     * 根据id查询student对象
     */
    public Student selectStudentById(int number) {
        Student student = null;
        // 通过session对象操作数据库
        student = sqlSession.selectOne("studentMapper.selectStudentById", number);
        return student;
    }

    @Override
    public List<Student> selectStudentByName(String name) {
        List<Student> students = null;
        // 利用sqlSession对象操作数据库
        students = sqlSession.selectList("studentMapper.selectStudentByName", name);
        return students;
    }

    @Override
    public List<Student> selectAll() {
        List<Student> students = null;
        students = sqlSession.selectList("studentMapper.selectAll");
        return students;
    }

    @Override
    public boolean insertStudent(Student student) {
        int insert = sqlSession.insert("studentMapper.insertStudent",student);
        // 提交事务
        sqlSession.commit();
        return insert>0;
    }

    @Override
    public boolean deleteStudent(int number) {
        int delete = sqlSession.delete("studentMapper.deleteStudent", number);
        sqlSession.commit();
        return delete>0;
    }

    @Override
    public boolean updateStudent(Student student) {
        int update = sqlSession.update("studentMapper.updateStudent", student);
        sqlSession.commit();
        return update>0;
    }
}
