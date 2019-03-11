package com.dao.imp;

import com.bean.Student;
import com.dao.StudentDao;
import com.util.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 客户的持久层实现类
 */
public class StudentDaoImp implements StudentDao {

    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    @Override
    public List<Student> findAllStudent() {
        try {
            return queryRunner.query("select * from student", new BeanListHandler<>(Student.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveStudent(Student student) {
        try {
            queryRunner.update("insert into student(number,img,name,age,major) values (?,?,?,?,?);",
                    student.getNumber(),student.getImg(),student.getName(),student.getAge(),student.getMajor());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int number) {
        try {
            queryRunner.update("delete from student where number=?", number);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student findStudent(int number) {
        try {
            return queryRunner.query("select * from student where number = ?", new BeanHandler<Student>(Student.class),number);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateStudent(Student student) {
        try {
            queryRunner.update("update student set img=?,name=?,age=?,major=? where number=?",
                    student.getImg(),student.getName(),student.getAge(),student.getMajor(),student.getNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
