package MyBatis;

import static org.junit.Assert.assertTrue;

import com.bean.Student;
import com.dao.StudentDao;
import com.dao.imp.StudentDaoImp;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        StudentDao studentDao = new StudentDaoImp();
        Student student = studentDao.selectStudentById(3);
        List<Student> student1 = studentDao.selectStudentByName("老");
        List<Student> students = studentDao.selectAll();
        System.out.println(student);
        System.out.println(student1);
        System.out.println(students);
    }

    @Test
    public void test(){
        StudentDao studentDao = new StudentDaoImp();
        Student student = new Student();
        student.setNumber(112);
        student.setImg("img");
        student.setAge(16);
        student.setName("Json");
        student.setMajor("数字媒体");
        System.out.println(studentDao.insertStudent(student));
    }

    @Test
    public void test1(){
        StudentDao studentDao = new StudentDaoImp();
        System.out.println(studentDao.deleteStudent(112));
    }

    @Test
    public void test2(){
        StudentDao studentDao = new StudentDaoImp();
        Student student = new Student();
        student.setNumber(9);
        student.setImg("img");
        student.setAge(16);
        student.setName("Change");
        student.setMajor("数字媒体");
        System.out.println(studentDao.updateStudent(student));
    }
}
