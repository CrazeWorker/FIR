package com.dao.imp;

import com.bean.Student;
import com.dao.StudentDao;
import com.util.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * 客户的持久层实现类
 *
 * 注解分类：
 * 1、用于创建bean对象的
 *      @Component 作用：相当于一个bean标签    属性：value 用于指定bean的id（不写时有默认值，为当前类名-首字母小写）
 *    由此注解衍生出的三个注解：
 *      @Controller  一般用于表现层的注解
 *      @Service     一般用于业务层
 *      @Repository  一般用于持久层
 *      他们和@Component的作用和属性都是一模一样的，
 * 2、用于注入数据的
 *      @Autowired 作用：自动装配  如果被注解的对象有多个实现子类，会拿变量名称去和beand的id汽配
 *      @Qualifier 作用：在自动按照类型注入的基础之上，把bean的id注入，他在给类型成员注入数据是，不能独立使用，但是给方法的形参注入数据时，可以独立使用
 *      @Resource  作用：直接注入类型和id，相当于上面了两个注解结合使用
 *          以上三个注解都是哟关于注入其他bean类型的，用于注入基本类型和引用类型用value
 *      @Value     作用：用于指定要注入的数据
 * 3、用于改变作用范围的
 *      @Scope     作用：用于改变bean的作用范围  属性：value：用于指定范围的值，和xml中的范围一样（songleton，prototype，request，session，globalsession ）
 * 4、和生命周期有关的
 * 5、Spring新注解
 *
 */
@Repository(value = "studentDao")
public class StudentDaoImp implements StudentDao {

    @Resource(name = "runner")
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

    @Override
    public void printA() {
        System.out.println("调用了业务层逻辑");
    }
}
